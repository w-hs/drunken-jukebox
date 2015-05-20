package de.whs.drunkenjukebox.client.admin.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class SongManagementViewImpl extends Composite implements SongManagementView {
	
	private final SongDetailView detailView = new SongDetailViewImpl();
	private final SongListView listView = new SongListViewImpl();

	public SongManagementViewImpl() {
		HorizontalPanel panel = new HorizontalPanel();
		panel.setSpacing(8);
		
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
