package de.whs.drunkenjukebox.resources;

import com.google.gwt.i18n.client.Constants;

public interface AppConstants extends Constants {
	@DefaultStringValue("Start")
	String startParty();
	
	@DefaultStringValue("Stop")
	String stopParty();
	
	@DefaultStringValue("Position")
	String position();
	
	@DefaultStringValue("Title")
	String title();
	
	@DefaultStringValue("Artist")
	String artist();

	@DefaultStringValue("Vote")
	String vote();
}
