package de.whs.drunkenjukebox.client.admin.view;

import com.google.gwt.user.client.ui.Widget;

public interface SongManagementView {
	SongDetailView getDetailView();
	SongListView getListView();
	Widget asWidget();
}
