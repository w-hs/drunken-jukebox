package de.whs.drunkenjukebox.beans.admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.whs.drunkenjukebox.common.Util;
import de.whs.drunkenjukebox.model.Party;
import de.whs.drunkenjukebox.model.PlayedSong;
import de.whs.drunkenjukebox.model.Playlist;
import de.whs.drunkenjukebox.model.PlaylistEntry;
import de.whs.drunkenjukebox.model.Song;

/**
 * Session Bean implementation class PartyBean
 */
@Stateless
public class AdminBean implements IAdminRemote, IAdminLocal {

	@PersistenceContext
	private EntityManager em;
	
	private static final int PLAYLIST_LENGTH = 15;
	private static final int DETLA_DI = 10;
	private static final int DELTA_TS_IN_MINUTES = 30;
	private static final int MAX_TRIES = 5;
	
    public AdminBean() {

    }

	@Override
	public Party startParty() {
		if (Util.getCurrentParty(em) != null)
			throw new RuntimeException("Party already started!");
		
		Party p = new Party();
		p.setStartTime(Calendar.getInstance());
			
		Playlist playlist = new Playlist();
		fillPlaylist(playlist);
		p.setPlaylist(playlist);
		
		Song song = chooseCurrentSong(playlist);
		p.setCurrentSong(song);
		
		em.persist(p);
		return p;
	}
	
	private Song chooseCurrentSong(Playlist playlist) {
		Song song = playlist.getEntries().iterator().next().getSong();
		playlist.getEntries().remove(song);
		
		fillPlaylist(playlist);
		
		return song;
	}

	private void fillPlaylist(Playlist playlist) {
		while (playlist.getEntries().size() < PLAYLIST_LENGTH) {
			PlaylistEntry entry = new PlaylistEntry();
			entry.setSong(selectSong());
			entry.setVoteCount(0);
			playlist.getEntries().add(entry);
		}
	}
	
	private Song selectSong() {	
		Party party = Util.getCurrentParty(em);		
		int currentAverageDi = party.getCurrentAverageDi();
		
		for (int i = 1; i < MAX_TRIES; i++) {	
			Calendar startTs = Calendar.getInstance();
			startTs.add(Calendar.MINUTE, i * DELTA_TS_IN_MINUTES);
			
			Calendar endTs = Calendar.getInstance();
			endTs.add(Calendar.MINUTE, -i * DELTA_TS_IN_MINUTES);
			
			Query query = em.createQuery("from PlayedSong ps where ps.averageDI between :startDi and :endDi and "
								   + "ps.timestamp between :startTs and :endTs")
					.setParameter("startDi", currentAverageDi - i * DETLA_DI)
					.setParameter("endDi", currentAverageDi + i * DETLA_DI)
					.setParameter("startTs", startTs)
					.setParameter("endTs", endTs);
				
			List<?> results = query.getResultList();			
			if (!results.isEmpty()) {			
				int maxVoteValue = Integer.MIN_VALUE;
				PlayedSong maxVoteSong = null;
				for (Object ps : results) {
					PlayedSong song = (PlayedSong) ps;
					if (song.getVoteCount() > maxVoteValue) {
						maxVoteValue = song.getVoteCount();
						maxVoteSong = song;
					}
				}			
				return maxVoteSong.getSong();
			}
		}

		return randomSong();
	}


	private Song randomSong() {
		List<Song> songs = getSongs();
		Party p = Util.getCurrentParty(em);
		Collection<PlayedSong> songsToConvert = p.getPlayedSongs();
		
		List<Song> playedSongs = new ArrayList<Song>();
		for (PlayedSong ps : songsToConvert) {
			playedSongs.add(ps.getSong());
		}
		
		songs.removeAll(playedSongs);
		
		return songs.get(randInt(0, songs.size() - 1));
	}
	
	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

	@Override
	public void stopParty() {
		Party current = Util.getCurrentParty(em);
		current.setEndTime(Calendar.getInstance());
	}

	@Override
	public void addSongs(List<Song> songs) {
		for (Song song : songs) {
			em.persist(song);
		}
	}

	@Override
	public List<Song> getSongs() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
	    CriteriaQuery<Song> query = builder.createQuery(Song.class);
	    Root<Song> variableRoot = query.from(Song.class);
	    query.select(variableRoot);

	    return em.createQuery(query).getResultList();
	}

	@Override
	public void updateSong(Song s) {
		em.merge(s);
	}

	@Override
	public void deleteSong(Song s) {
		Song mergedSong = em.merge(s);
		em.remove(mergedSong);
	}
}
