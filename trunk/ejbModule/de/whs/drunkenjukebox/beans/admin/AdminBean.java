package de.whs.drunkenjukebox.beans.admin;

import java.util.List;

import javax.ejb.Stateless;

import de.whs.drunkenjukebox.model.Party;
import de.whs.drunkenjukebox.model.Song;

/**
 * Session Bean implementation class PartyBean
 */
@Stateless
public class AdminBean implements IAdminRemote {

    /**
     * Default constructor. 
     */
    public AdminBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Party startParty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void stopParty() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSongs(List<Song> songs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Song> getSongs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSong(Song s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSong(Song s) {
		// TODO Auto-generated method stub
		
	}

}
