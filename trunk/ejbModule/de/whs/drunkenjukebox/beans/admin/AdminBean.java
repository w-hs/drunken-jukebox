package de.whs.drunkenjukebox.beans.admin;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import de.whs.drunkenjukebox.common.Util;
import de.whs.drunkenjukebox.model.Party;
import de.whs.drunkenjukebox.model.Playlist;
import de.whs.drunkenjukebox.model.Song;

/**
 * Session Bean implementation class PartyBean
 */
@Stateless
public class AdminBean implements IAdminRemote {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AdminBean() {
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return null;
	}

	private void fillPlaylist(Playlist playlist) {
		// TODO Auto-generated method stub
		
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
		CriteriaQuery<Song> cquery = builder.createQuery(Song.class);
		TypedQuery<Song> query = em.createQuery(cquery);
		return query.getResultList();
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
