package de.whs.drunkenjukebox.client.admin.view;

import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

import de.whs.drunkenjukebox.shared.GlobalPlaylistEntry;
import de.whs.drunkenjukebox.shared.Party;

public interface PartyManagementView {
	HasClickHandlers getStartButton();
	HasClickHandlers getStopButton();
	
	void setParty(Party p);
	void setPlaylist(List<GlobalPlaylistEntry> entries);
	void setButtonEnabled(boolean startButtonEnabled, boolean stoppButtonEnabled);
	
	Widget asWidget();
}
