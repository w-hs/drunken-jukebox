package de.whs.drunkenjukebox.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

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
		
		@ClassName("full-width")
		String fullWidth();
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
		
		@ClassName("songSourcePanel")
		String songSourcePanel();
		
		@ClassName("save-button")
		String saveButton();
		
		@ClassName("remove-button")
		String removeButton();
		
		@ClassName("create-button")
		String createButton();
		
		@ClassName("gwt-TabLayoutPanel")
		String tabLayoutPanel();
		
		@ClassName("language-image")
		String languageImage();

@ClassName("partyManagementView")
		String partyManagementView();

		
	}
	
	@Source("admin.gss")
	AdminStyle adminStye();
	
	@Source("vote-app.gss")
	VoteAppStyle voteAppStyle();
	
	@Source("en.png")
	ImageResource en();
	
	@Source("de.png")
	ImageResource de();
}
