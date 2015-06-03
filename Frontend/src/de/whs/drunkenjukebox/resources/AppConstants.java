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
	
	@DefaultStringValue("Save")
	String save();
	
	@DefaultStringValue("Remove")
	String remove();
	
	@DefaultStringValue("Source")
	String source();
	
	@DefaultStringValue("Local")
	String local();
	
	@DefaultStringValue("YouTube")
	String youtube();
	
	@DefaultStringValue("Genre")
	String genre();
	
	@DefaultStringValue("Length")
	String length();
	
	@DefaultStringValue("Create")
	String create();
	
	@DefaultStringValue("Search...")
	String searchDotDotDot();
}
