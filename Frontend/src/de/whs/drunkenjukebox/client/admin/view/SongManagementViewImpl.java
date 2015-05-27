package de.whs.drunkenjukebox.client.admin.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

import de.whs.drunkenjukebox.resources.AppResources;

public class SongManagementViewImpl extends Composite implements SongManagementView {
	
	private final SongDetailView detailView;
	private final SongListView listView;

	public SongManagementViewImpl(AppResources.AdminStyle style) {
		detailView = new SongDetailViewImpl(style);
		listView = new SongListViewImpl(style);
		
		HorizontalPanel panel = new HorizontalPanel();
		panel.addStyleName(style.managementView());
		
		panel.add(listView.asWidget());
		panel.add(detailView.asWidget());
		
		initWidget(panel);
	}
	
	@Override
	public SongDetailView getDetailView() {
		return detailView;
	}

	@Override
	public SongListView getListView() {
		return listView;
	}
}
