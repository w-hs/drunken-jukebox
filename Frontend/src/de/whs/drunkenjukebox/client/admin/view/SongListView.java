package de.whs.drunkenjukebox.client.admin.view;

import java.util.List;

import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public interface SongListView {
	void setSongs(List<String> songs);

	HasChangeHandlers getSongsListBox();

	HasKeyUpHandlers getSearchTextBox();

	HasClickHandlers getRemoveButton();

	HasValue<String> getSearchText();

	int getSelectedIndex();

	Widget asWidget();
}
