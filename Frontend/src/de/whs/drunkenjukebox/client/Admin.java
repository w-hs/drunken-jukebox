package de.whs.drunkenjukebox.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

import de.whs.drunkenjukebox.client.admin.PartyTabPage;

public class Admin implements EntryPoint {

	@Override
	public void onModuleLoad() {
		TabLayoutPanel tabLayoutPanel = new TabLayoutPanel(2.5, Unit.EM);
		tabLayoutPanel.setAnimationDuration(1000);
	    tabLayoutPanel.getElement().getStyle().setMarginBottom(10.0, Unit.PX);
		tabLayoutPanel.add(new PartyTabPage(), "Party");
		tabLayoutPanel.add(new HTML("Songs"), "Songs");
		tabLayoutPanel.add(new HTML("Über"), "Über");
		RootLayoutPanel rp = RootLayoutPanel.get();
		rp.add(tabLayoutPanel);
	}

}
