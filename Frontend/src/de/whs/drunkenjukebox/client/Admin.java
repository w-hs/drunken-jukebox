package de.whs.drunkenjukebox.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
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
import de.whs.drunkenjukebox.resources.AppConstants;
import de.whs.drunkenjukebox.resources.AppResources;

public class Admin implements EntryPoint {
	
	private AppConstants constants = GWT.create(AppConstants.class);
	
	private AdminServiceAsync rpcService;
	private SongManagementView songManagementView;
	private PartyManagementView partyManagementView;
	
	@Override
	public void onModuleLoad() {
		AppResources resources = GWT.create(AppResources.class);
		AppResources.AdminStyle style = resources.adminStye();
		style.ensureInjected();
		
		rpcService = GWT.create(AdminService.class);
		
		songManagementView = new SongManagementViewImpl(style);
		partyManagementView = new PartyManagementViewImpl(style);
		
		SongManagementPresenter songManagementPresenter = new SongManagementPresenter(rpcService, songManagementView);
		songManagementPresenter.go();
		
		PartyManagementPresenter partyManagementPresenter = new PartyManagementPresenter(rpcService, partyManagementView);
		partyManagementPresenter.go();
				
		TabLayoutPanel tabLayoutPanel = new TabLayoutPanel(2.5, Unit.EM);
		tabLayoutPanel.setAnimationDuration(1000);
	    tabLayoutPanel.getElement().getStyle().setMarginBottom(10.0, Unit.PX);
	       
		tabLayoutPanel.add(partyManagementView.asWidget(), constants.party());
		tabLayoutPanel.add(songManagementView.asWidget(), constants.songs());
		
		HorizontalPanel languagePanel = new HorizontalPanel();
		Image enImage = new Image(resources.en());
		enImage.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String newUrl = Window.Location.getPath() + "?locale=en";
				Window.Location.assign(newUrl);
			}
		});
		Image deImage = new Image(resources.de());
		deImage.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String newUrl = Window.Location.getPath() + "?locale=de";
				Window.Location.assign(newUrl);
			}
		});
		languagePanel.add(enImage);
		languagePanel.add(deImage);
		tabLayoutPanel.add(languagePanel, "Language");
		
		RootLayoutPanel rp = RootLayoutPanel.get();
		
		rp.add(tabLayoutPanel);	
	}
}
