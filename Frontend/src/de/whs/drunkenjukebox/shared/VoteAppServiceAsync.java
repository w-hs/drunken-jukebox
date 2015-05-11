package de.whs.drunkenjukebox.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.whs.drunkenjukebox.model.PlayList;
import de.whs.drunkenjukebox.model.PlayListEntry;

public interface VoteAppServiceAsync {

	void getCurrentSong(AsyncCallback<Song> callback);

	void getPlayList(AsyncCallback<PlayList> callback);

	void sendDi(int value, AsyncCallback<Void> callback);

	void sendVote(PlayListEntry entry, Vote vote, AsyncCallback<Void> callback);

}
