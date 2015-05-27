package de.whs.drunkenjukebox.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

import de.whs.drunkenjukebox.client.admin.AdminService;
import de.whs.drunkenjukebox.client.admin.AdminServiceAsync;
import de.whs.drunkenjukebox.client.admin.presenter.PartyManagementPresenter;
import de.whs.drunkenjukebox.client.admin.presenter.SongManagementPresenter;
import de.whs.drunkenjukebox.client.admin.view.PartyManagementView;
import de.whs.drunkenjukebox.client.admin.view.PartyManagementViewImpl;
import de.whs.drunkenjukebox.client.admin.view.SongManagementView;
import de.whs.drunkenjukebox.client.admin.view.SongManagementViewImpl;
import de.whs.drunkenjukebox.resources.AppResources;

public class Admin implements EntryPoint {
	
	private AdminServiceAsync rpcService;
	private final SongManagementView songManagementView = new SongManagementViewImpl();
	private final PartyManagementView partyManagementView = new PartyManagementViewImpl();
	
	@Override
	public void onModuleLoad() {
		AppResources resources = GWT.create(AppResources.class);
		AppResources.AdminStyle style = resources.adminStye();
		style.ensureInjected();
		
		rpcService = GWT.create(AdminService.class);
		
		SongManagementPresenter songManagementPresenter = new SongManagementPresenter(rpcService, songManagementView);
		songManagementPresenter.go();
		
		PartyManagementPresenter partyManagementPresenter = new PartyManagementPresenter(rpcService, partyManagementView);
		partyManagementPresenter.go();
				
		TabLayoutPanel tabLayoutPanel = new TabLayoutPanel(2.5, Unit.EM);
		tabLayoutPanel.setAnimationDuration(1000);
	    tabLayoutPanel.getElement().getStyle().setMarginBottom(10.0, Unit.PX);
	       
		tabLayoutPanel.add(partyManagementView.asWidget(), "Party");
		tabLayoutPanel.add(songManagementView.asWidget(), "Songs");
		RootLayoutPanel rp = RootLayoutPanel.get();
		
		rp.add(tabLayoutPanel);	
	}
}
