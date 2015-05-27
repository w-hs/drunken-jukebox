package de.whs.drunkenjukebox.client.admin.view;

import java.util.List;

import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public interface SongListView {
	void setSongs(List<String> songs);
	
	void setSelectedIndex(int index);
	
	void setFocusToTextBoxSearch(boolean focused);

	HasClickHandlers getCreateButton();
	
	HasChangeHandlers getSongsListBox();

	HasKeyUpHandlers getSearchTextBox();

	HasValue<String> getSearchText();

	int getSelectedIndex();

	Widget asWidget();
}
