package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.whs.drunkenjukebox.resources.AppResources.VoteAppStyle;

public class CurrentSongWidget extends Composite {
	
	private Label songLabel = new Label("Dummy");
	private Label interpreterLabel = new Label("Bla Blubb");
	private VoteAppStyle style;
	
	public CurrentSongWidget(VoteAppStyle style) {
		this.style = style;
		VerticalPanel panel = new VerticalPanel();
		panel.add(songLabel);
		panel.add(interpreterLabel);
		
		songLabel.addStyleName(style.title());
		interpreterLabel.addStyleName(style.artist());
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
