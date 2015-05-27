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
	
	public interface AdminStyle extends CssResource {
		@ClassName("songManagementView")
		String managementView();
		
		@ClassName("songListView")
		String songListView();
		
		@ClassName("songDetailView")
		String songDetailView();
		
		@ClassName("inputBoxLabel")
		String inputBoxLabel();
		
		@ClassName("inputBoxText")
		String inputBoxText();
		
		@ClassName("listBoxSongs")
		String listBoxSongs();
	}
	
	@Source("admin.gss")
	AdminStyle adminStye();
	
	@Source("vote-app.gss")
	VoteAppStyle voteAppStyle();
}
