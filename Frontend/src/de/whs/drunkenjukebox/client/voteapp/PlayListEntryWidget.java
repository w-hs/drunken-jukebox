package de.whs.drunkenjukebox.client.voteapp;

import javafx.scene.layout.FlowPane;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.whs.drunkenjukebox.resources.AppResources.VoteAppStyle;
import de.whs.drunkenjukebox.shared.PlayListEntry;

public class PlayListEntryWidget extends Composite {
	
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
		
		Button upButton = new Button("Up");
		upButton.addStyleName(style.upVote());
		Button downButton = new Button("Down");
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
