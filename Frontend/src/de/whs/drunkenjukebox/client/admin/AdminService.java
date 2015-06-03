package de.whs.drunkenjukebox.client.admin;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.whs.drunkenjukebox.shared.GlobalPlaylist;
import de.whs.drunkenjukebox.shared.Party;
import de.whs.drunkenjukebox.shared.Song;

@RemoteServiceRelativePath("admin")
public interface AdminService extends RemoteService {
	ArrayList<Song> getSongList();
	Song addSong(Song song);
	Song getSong(String id);
	Song updateSong(Song song);
	void removeSong(String songId);
	
	Party startParty();
	Party stoppParty(Party p);
	GlobalPlaylist getPlaylist();
}