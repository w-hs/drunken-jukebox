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
	
	@DefaultStringValue("Send")
	String send();
	
	@DefaultStringValue("Cancel")
	String cancel();
	
	@DefaultStringValue("Please slide in your DI")
	String pleaseSlideInDI();
	
	@DefaultStringValue("Sober")
	String sober();
	
	@DefaultStringValue("Funny")
	String funny();
	
	@DefaultStringValue("Drunk")
	String drunk();
	
	@DefaultStringValue("Send DI")
	String sendDI();
	
	@DefaultStringValue("Up")
	String upVote();
	
	@DefaultStringValue("Down")
	String downVote();
	
	@DefaultStringValue("Party")
	String party();
	
	@DefaultStringValue("Songs")
	String songs();
	
	@DefaultStringValue("Language")
	String language();
}
