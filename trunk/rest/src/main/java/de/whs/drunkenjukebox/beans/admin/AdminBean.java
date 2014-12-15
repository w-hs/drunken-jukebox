package de.whs.drunkenjukebox.beans.admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.jboss.ejb3.annotation.SecurityDomain;

import de.whs.drunkenjukebox.common.Util;
import de.whs.drunkenjukebox.model.Party;
import de.whs.drunkenjukebox.model.PlayedSong;
import de.whs.drunkenjukebox.model.Playlist;
import de.whs.drunkenjukebox.model.PlaylistEntry;
import de.whs.drunkenjukebox.model.Song;
import de.whs.drunkenjukebox.rest.roles.IRoles;

/**
 * Session Bean implementation class PartyBean
 */
@SecurityDomain("DjDomain")
@DeclareRoles({IRoles.Admin})	
@RolesAllowed({IRoles.Admin})	
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
		
		Party party = new Party();
		party.setStartTime(Calendar.getInstance());
			
		Playlist playlist = new Playlist();
		party.setPlaylist(playlist);
		fillPlaylist(party, playlist);
		
		chooseCurrentSong(party, playlist);
		
		em.persist(party);
		return party;
	}
	
	private void chooseCurrentSong(Party party, Playlist playlist) {
		PlaylistEntry entryToPlay = playlist.getEntries().iterator().next();
		playlist.getEntries().remove(entryToPlay);
		party.setCurrentSong(entryToPlay.getSong());
		
		fillPlaylist(party, playlist);
	}

	private void fillPlaylist(Party party, Playlist playlist) {
		List<Song> songs = getSongs();
		int currentSongCount = 0;
		if (party.getCurrentSong() != null)
			currentSongCount = 1;
		while (playlist.getEntries().size() < PLAYLIST_LENGTH && playlist.getEntries().size() + currentSongCount < songs.size()) {
			PlaylistEntry entry = new PlaylistEntry();
			entry.setSong(selectSong(songs, party));
			entry.setVoteCount(0);
			playlist.getEntries().add(entry);
		}
	}
	
	private Song selectSong(List<Song> songs, Party party) {		
		int currentAverageDi = party.getCurrentAverageDi();
		
		for (int i = 1; i < MAX_TRIES; i++) {	
			Calendar startTs = Calendar.getInstance();
			startTs.add(Calendar.MINUTE, i * DELTA_TS_IN_MINUTES);
			
			Calendar endTs = Calendar.getInstance();
			endTs.add(Calendar.MINUTE, -i * DELTA_TS_IN_MINUTES);
			
			Query query = em.createQuery("from PlayedSong ps where ps.averageDI between :startDi and :endDi and "
								   + "ps.timestamp between :startTs and :endTs")
					.setParameter("startDi", (float)(currentAverageDi - i * DETLA_DI))
					.setParameter("endDi", (float)(currentAverageDi + i * DETLA_DI))
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

		return randomSong(songs, party);
	}


	private Song randomSong(List<Song> songs, Party party) {
		Collection<PlayedSong> playedSongs = party.getPlayedSongs();
		
		List<Song> songsToChooseFrom = new ArrayList<Song>(songs);
		List<Song> songsToRemove = new ArrayList<Song>();
		for (PlayedSong ps : playedSongs) {
			songsToRemove.add(ps.getSong());
		}
		for (PlaylistEntry entry : party.getPlaylist().getEntries()) {
			songsToRemove.add(entry.getSong());
		}
		songsToRemove.add(party.getCurrentSong());
		
		songsToChooseFrom.removeAll(songsToRemove);
		
		return songsToChooseFrom.get(randInt(0, songsToChooseFrom.size() - 1));
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
