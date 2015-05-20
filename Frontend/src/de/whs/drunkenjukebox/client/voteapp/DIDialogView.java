package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.DialogBox;

public interface DIDialogView {
	HasClickHandlers getAcceptButton();
	
	HasClickHandlers getCancelButton();
	
	DialogBox asDialogBox();
}
