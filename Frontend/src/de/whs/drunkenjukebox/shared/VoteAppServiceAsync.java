package de.whs.drunkenjukebox.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface VoteAppServiceAsync {

	void getCurrentSong(AsyncCallback<Song> callback);

	void getPlayList(AsyncCallback<PlayList> callback);

	void sendDi(int value, AsyncCallback<Void> callback);

	void sendVote(PlayListEntry entry, Vote vote, AsyncCallback<Void> callback);

}
