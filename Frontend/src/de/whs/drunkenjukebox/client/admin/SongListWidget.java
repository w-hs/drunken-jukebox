package de.whs.drunkenjukebox.client.admin;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SongListWidget extends Composite {

	private final TextBox textBoxSearch = new TextBox();
	private final ListBox listBoxSongs = new ListBox(false);
	private final Button buttonCreate = new Button("Erstellen");
	private final Button buttonRemove = new Button("Entfernen");
	
	public SongListWidget() {	  
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(8);
		
		textBoxSearch.setText("Suche...");
		panel.add(textBoxSearch);
		
		listBoxSongs.addItem("Jingle Bells");
		listBoxSongs.addItem("Last Christmas");
		listBoxSongs.addItem("Wonderful Dream");	
		listBoxSongs.setVisibleItemCount(10);
		listBoxSongs.setWidth("100%");
		panel.add(listBoxSongs);
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.add(buttonCreate);
		buttonPanel.add(buttonRemove);
		buttonPanel.setCellHorizontalAlignment(buttonRemove, HasHorizontalAlignment.ALIGN_RIGHT);
		buttonPanel.setWidth("100%");
		panel.add(buttonPanel);
		
	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidget(panel);
		initWidget(decPanel);
	}	
}
