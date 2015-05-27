package de.whs.drunkenjukebox.client.admin;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.whs.drunkenjukebox.shared.GlobalPlaylist;
import de.whs.drunkenjukebox.shared.Party;
import de.whs.drunkenjukebox.shared.Song;

public interface AdminServiceAsync {
	public void getSongList(AsyncCallback<ArrayList<Song>> callback);
	public void getSong(String id, AsyncCallback<Song> asyncCallback);
	public void updateSong(Song song, AsyncCallback<Song> asyncCallback);
	public void removeSong(int songId, AsyncCallback<Void> asyncCallback);
	void addSong(Song song, AsyncCallback<Song> callback);
	void startParty(AsyncCallback<Party> callback);
	void stoppParty(Party p, AsyncCallback<Party> callback);
	void getPlaylist(AsyncCallback<GlobalPlaylist> callback);
}