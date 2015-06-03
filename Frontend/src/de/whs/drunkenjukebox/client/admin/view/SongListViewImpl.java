package de.whs.drunkenjukebox.client.admin.view;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.whs.drunkenjukebox.resources.AppConstants;
import de.whs.drunkenjukebox.resources.AppResources;

public class SongListViewImpl extends Composite implements SongListView {
	
	private AppConstants constants = GWT.create(AppConstants.class);

	private final TextBox textBoxSearch = new TextBox();
	private final ListBox listBoxSongs = new ListBox();
	private final Button buttonCreate = new Button(constants.create());

	public SongListViewImpl(AppResources.AdminStyle style) {
		VerticalPanel panel = new VerticalPanel();
		panel.addStyleName(style.songListView());

		textBoxSearch.getElement().setPropertyString("placeholder", constants.searchDotDotDot());
		panel.add(textBoxSearch);
		
		listBoxSongs.setVisibleItemCount(2);
		listBoxSongs.addStyleName(style.listBoxSongs());
		panel.add(listBoxSongs);

		buttonCreate.addStyleName(style.createButton());
		panel.add(buttonCreate);
		panel.setCellHorizontalAlignment(buttonCreate,
				HasHorizontalAlignment.ALIGN_RIGHT);
		panel.setCellVerticalAlignment(buttonCreate, HasVerticalAlignment.ALIGN_BOTTOM);
		

		initWidget(panel);
	}

	@Override
	public void setSongs(List<String> songs) {
		listBoxSongs.clear();
		for (String s : songs)
			listBoxSongs.addItem(s);
		 
		if (songs.size() > 0)
			setSelectedIndex(0);
	}

	@Override
	public HasChangeHandlers getSongsListBox() {
		return listBoxSongs;
	}

	@Override
	public int getSelectedIndex() {
		return listBoxSongs.getSelectedIndex();
	}

	@Override
	public HasKeyUpHandlers getSearchTextBox() {
		return textBoxSearch;
	}

	@Override
	public HasValue<String> getSearchText() {
		return textBoxSearch;
	}

	@Override
	public HasClickHandlers getCreateButton() {
		return buttonCreate;
	}

	@Override
	public void setSelectedIndex(int index) {
		listBoxSongs.setSelectedIndex(index);
		DomEvent.fireNativeEvent(Document.get().createChangeEvent(), listBoxSongs);
	}

	@Override
	public void setFocusToTextBoxSearch(boolean focused) {
		textBoxSearch.setFocus(focused);		
	}
}
