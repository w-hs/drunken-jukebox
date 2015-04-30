package de.whs.drunkenjukebox.client.admin;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class PartyTabPage extends Composite {

	private final SongListWidget songWidget = new SongListWidget();
	private final SongDetailWidget detailWidget = new SongDetailWidget();

	public PartyTabPage() {

		HorizontalPanel panel = new HorizontalPanel();
		panel.setSpacing(8);
		panel.add(songWidget);
		panel.add(detailWidget);

		initWidget(panel);
	}

}
