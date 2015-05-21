package de.whs.drunkenjukebox.client.admin.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface PartyManagementView {
	
	HasClickHandlers getStartButton();
	HasClickHandlers getStopButton();
	
	void setButtonEnabled(boolean startButtonEnabled, boolean stoppButtonEnabled);
	
	
	Widget asWidget();
}
