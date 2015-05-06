package de.whs.drunkenjukebox.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class VoteApp implements EntryPoint {
	

	

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("root").add(nameField);
	

		

	

	}
}
