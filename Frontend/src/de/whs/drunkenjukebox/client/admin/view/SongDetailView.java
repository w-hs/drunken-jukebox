package de.whs.drunkenjukebox.client.admin.view;

import com.google.gwt.user.client.ui.Widget;

import de.whs.drunkenjukebox.shared.Song;

public interface SongDetailView {
	void setSong(Song song);

	void clear();

	Widget asWidget();
}
