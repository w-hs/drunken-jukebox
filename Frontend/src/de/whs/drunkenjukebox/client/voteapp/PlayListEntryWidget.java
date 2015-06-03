package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.whs.drunkenjukebox.resources.AppConstants;
import de.whs.drunkenjukebox.resources.AppResources.VoteAppStyle;
import de.whs.drunkenjukebox.shared.PlayListEntry;

public class PlayListEntryWidget extends Composite {
	
	private AppConstants constants = GWT.create(AppConstants.class);
	
	PlayListEntry playlistEntry;
	
	public PlayListEntryWidget(PlayListEntry p, VoteAppStyle style) {
		playlistEntry = p;
		HorizontalPanel mainPanel = new HorizontalPanel();
		
		VerticalPanel namePanel = new VerticalPanel();
		Label songName = new Label(p.getSongName());
		songName.addStyleName(style.title());
		Label artistName = new Label(p.getInterpreter());
		artistName.addStyleName(style.artist());
		namePanel.add(songName);
		namePanel.add(artistName);
		
		Button upButton = new Button(constants.upVote());
		upButton.addStyleName(style.upVote());
		Button downButton = new Button(constants.downVote());
		downButton.addStyleName(style.downVote());
		
		FlowPanel buttonsPannel = new FlowPanel();
		
		
		buttonsPannel.add(upButton);
		buttonsPannel.add(downButton);
		
		mainPanel.add(namePanel);
		mainPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		mainPanel.add(buttonsPannel);
		mainPanel.addStyleName(style.playlistEntry());
		
		initWidget(mainPanel);
	}
	
	
}
