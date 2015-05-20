package de.whs.drunkenjukebox.client.admin.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

import de.whs.drunkenjukebox.shared.Song;

public interface SongDetailView {
	void setSong(Song song);
	
	Song getSong();
	
	void setFocusToInterpretBox();

	void clear();

	Widget asWidget();

	HasClickHandlers getRemoveButton();

	HasClickHandlers getSaveButton();
}
