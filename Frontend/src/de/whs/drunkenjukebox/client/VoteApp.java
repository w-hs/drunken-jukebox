package de.whs.drunkenjukebox.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import de.whs.drunkenjukebox.client.voteapp.SongList;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VoteApp implements EntryPoint {
	

	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		Button diButton = new Button("Send DI");
		
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel root = RootPanel.get("root");
		root.add(diButton);
		
		SongList songs = new SongList();
		root.add(songs);
	}
}
