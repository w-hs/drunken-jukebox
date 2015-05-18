package de.whs.drunkenjukebox.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import de.whs.drunkenjukebox.client.admin.SongsService;
import de.whs.drunkenjukebox.client.admin.SongsServiceAsync;
import de.whs.drunkenjukebox.client.admin.presenter.SongPresenter;
import de.whs.drunkenjukebox.client.admin.view.PartyTabPage;
import de.whs.drunkenjukebox.client.admin.view.SongDetailView;
import de.whs.drunkenjukebox.client.admin.view.SongListView;

public class Admin implements EntryPoint {
	
	private SongsServiceAsync rpcService;
	
	@Override
	public void onModuleLoad() {
		
		rpcService = GWT.create(SongsService.class);
		
		TabLayoutPanel tabLayoutPanel = new TabLayoutPanel(2.5, Unit.EM);
		tabLayoutPanel.setAnimationDuration(1000);
	    tabLayoutPanel.getElement().getStyle().setMarginBottom(10.0, Unit.PX);
	       
		tabLayoutPanel.add(new PartyTabPage(), "Party");
		tabLayoutPanel.add(getSongsTabPage(), "Songs");
		RootLayoutPanel rp = RootLayoutPanel.get();
		rp.add(tabLayoutPanel);	
	}
	
	private Widget getSongsTabPage() {
		HorizontalPanel panel = new HorizontalPanel();
		panel.setSpacing(8);
		
		SongPresenter presenter = new SongPresenter(rpcService, new SongListView(), new SongDetailView());
		presenter.go(panel);
		
		return panel;
	}
}
