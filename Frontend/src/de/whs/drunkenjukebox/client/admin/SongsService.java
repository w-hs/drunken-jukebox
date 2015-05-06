package de.whs.drunkenjukebox.client.admin;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.whs.drunkenjukebox.shared.Song;

@RemoteServiceRelativePath("songs")
public interface SongsService extends RemoteService {
	ArrayList<Song> getSongList();
	Song getSong(String id);
	Song updateSong(Song song);
}