package de.whs.drunkenjukebox.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface AppResources extends ClientBundle {
	public interface VoteAppStyle extends CssResource {
		@ClassName("current-track")
		String currentTrack();
		
		@ClassName("playlist-entry")
		String playlistEntry();
		
		@ClassName("title")
		String title();
		
		@ClassName("artist")
		String artist();
	
		@ClassName("up-vote")
		String upVote();
		
		@ClassName("down-vote")
		String downVote();
		
		@ClassName("send-di")
		String sendDi();
	}
	
	@Source("vote-app.gss")
	VoteAppStyle voteAppStyle();
}
