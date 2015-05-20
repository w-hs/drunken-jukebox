package de.whs.drunkenjukebox.client.admin.view;

import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasKeyUpHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SongListViewImpl extends Composite implements SongListView {

	private final TextBox textBoxSearch = new TextBox();
	private final ListBox listBoxSongs = new ListBox(false);
	private final Button buttonCreate = new Button("Erstellen");
	private final Button buttonRemove = new Button("Entfernen");
	
	public SongListViewImpl() {	  
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(8);
		
		textBoxSearch.getElement().setPropertyString("placeholder", "Suche...");
		panel.add(textBoxSearch);
		
		listBoxSongs.setVisibleItemCount(10);
		listBoxSongs.setWidth("100%");
		panel.add(listBoxSongs);
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.add(buttonCreate);
		buttonPanel.add(buttonRemove);
		buttonPanel.setCellHorizontalAlignment(buttonRemove, HasHorizontalAlignment.ALIGN_RIGHT);
		buttonPanel.setWidth("100%");
		panel.add(buttonPanel);
		
	    // Wrap the content in a DecoratorPanel
	    DecoratorPanel decPanel = new DecoratorPanel();
	    decPanel.setWidget(panel);
		initWidget(decPanel);
	}

	@Override
	public void setSongs(List<String> songs) {
		listBoxSongs.clear();
		for (String s : songs)
			listBoxSongs.addItem(s);
		 
		if (songs.size() > 0) {
			listBoxSongs.setSelectedIndex(0);
			DomEvent.fireNativeEvent(Document.get().createChangeEvent(), listBoxSongs);
		}
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
	public HasClickHandlers getRemoveButton() {
		return buttonRemove;
	}
}
