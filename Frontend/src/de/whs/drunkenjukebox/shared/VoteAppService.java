package de.whs.drunkenjukebox.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.whs.drunkenjukebox.model.PlayList;
import de.whs.drunkenjukebox.model.PlayListEntry;

@RemoteServiceRelativePath("app")
public interface VoteAppService extends RemoteService {
	Song getCurrentSong();
	
	PlayList getPlayList();
	
	void sendDi(int value);
	
	void sendVote(PlayListEntry entry, Vote vote);
}
