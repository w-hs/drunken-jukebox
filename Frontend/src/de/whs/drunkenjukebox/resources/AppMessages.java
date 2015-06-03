package de.whs.drunkenjukebox.resources;

import java.util.Date;

import com.google.gwt.i18n.client.Messages;

public interface AppMessages extends Messages {
	@DefaultMessage("Start date: {0,date,medium} {0,time,medium}")
	String startDate(Date date);
	
	@DefaultMessage("Guest count: {0}")
	String guestCount(Integer count);
	
	@DefaultMessage("Drunken index: {0}")
	String drunkenIndex(Integer count);
}
