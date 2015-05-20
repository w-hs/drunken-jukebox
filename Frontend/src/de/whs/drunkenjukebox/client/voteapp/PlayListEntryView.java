package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.whs.drunkenjukebox.shared.PlayListEntry;

public class PlayListEntryView extends Composite {
	
	PlayListEntry playlistEntry;
	
	public PlayListEntryView(PlayListEntry p) {
		playlistEntry = p;
		HorizontalPanel mainPanel = new HorizontalPanel();
		
		VerticalPanel namePanel = new VerticalPanel();
		Label songName = new Label(p.getSongName());
		Label interpreterName = new Label(p.getInterpreter());
		namePanel.add(songName);
		namePanel.add(interpreterName);
		
		Button upButton = new Button("Up");
		Button downButton = new Button("Down");
		
		mainPanel.add(namePanel);
		mainPanel.add(upButton);
		mainPanel.add(downButton);
		
		initWidget(mainPanel);
	}
	
	
}
