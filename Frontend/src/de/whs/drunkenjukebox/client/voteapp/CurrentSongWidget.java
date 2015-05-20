package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CurrentSongWidget extends Composite {
	
	private Label songLabel = new Label("Dummy");
	private Label interpreterLabel = new Label("Bla Blubb");
	
	public CurrentSongWidget() {
		VerticalPanel panel = new VerticalPanel();
		panel.add(songLabel);
		panel.add(interpreterLabel);
		
		initWidget(panel);
	}
	
	public void setSongName(String name)
	{
		songLabel.setText(name);
	}
	
	public void setInterpreter(String name)
	{
		interpreterLabel.setText(name);
	}

}
