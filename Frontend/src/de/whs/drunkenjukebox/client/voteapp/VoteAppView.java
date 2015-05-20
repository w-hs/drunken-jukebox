package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

import de.whs.drunkenjukebox.shared.PlayList;

public interface VoteAppView {
	void setPlaylist(PlayList pl);
	
	HasClickHandlers getDIButton();
	
	DIDialogView getDIDialog();
	
	CurrentSongWidget getCurrentSong();
	
	Widget asWidget();
}
