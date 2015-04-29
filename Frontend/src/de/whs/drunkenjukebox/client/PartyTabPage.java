package de.whs.drunkenjukebox.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HTML;

public class PartyTabPage extends Composite {

	private final SongWidget songWidget = new SongWidget();

	public PartyTabPage() {

		HorizontalPanel panel = new HorizontalPanel();
		panel.add(songWidget);
		panel.add(new HTML("TODO"));

		initWidget(panel);
	}

}
