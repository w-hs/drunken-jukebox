package de.whs.drunkenjukebox.beans.admin;

import java.util.List;

import de.whs.drunkenjukebox.model.Party;
import de.whs.drunkenjukebox.model.Song;

public interface IAdminCommon {
	Party startParty();
	void stopParty();

	void addSongs(List<Song> songs);
	List<Song> getSongs();
	void updateSong(Song s);
	void deleteSong(Song s);
	
}
