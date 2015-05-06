package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SongListEntry extends Composite {
	
	public SongListEntry() {
		HorizontalPanel mainPanel = new HorizontalPanel();
		
		VerticalPanel namePanel = new VerticalPanel();
		Label songName = new Label("Last Christmas");
		Label interpreterName = new Label("Wham");
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
