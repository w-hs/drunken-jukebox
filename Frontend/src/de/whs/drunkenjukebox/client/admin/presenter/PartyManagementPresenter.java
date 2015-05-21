package de.whs.drunkenjukebox.client.admin.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import de.whs.drunkenjukebox.client.admin.AdminServiceAsync;
import de.whs.drunkenjukebox.client.admin.view.PartyManagementView;

public class PartyManagementPresenter  {
	
	private final PartyManagementView view;
	private final AdminServiceAsync service;
	
	public PartyManagementPresenter(AdminServiceAsync service, PartyManagementView view) {
		this.view = view;
		this.service = service;
	}

	public void bind() {
		view.getStartButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onStartClick();	
			}
		});
		view.getStopButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				onStopClick();
			}
		});
	}

	protected void onStopClick() {
		view.setButtonEnabled(true, false);
	}

	protected void onStartClick() {
		view.setButtonEnabled(false, true);
	}

	public void go() {
		bind();
		view.setButtonEnabled(true, false);
	}
}
