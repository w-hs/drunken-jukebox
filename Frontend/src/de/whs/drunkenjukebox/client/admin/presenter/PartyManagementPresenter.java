package de.whs.drunkenjukebox.client.admin.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.whs.drunkenjukebox.client.admin.AdminServiceAsync;
import de.whs.drunkenjukebox.client.admin.view.PartyManagementView;
import de.whs.drunkenjukebox.shared.GlobalPlaylist;
import de.whs.drunkenjukebox.shared.Party;

public class PartyManagementPresenter {

	private final PartyManagementView view;
	private final AdminServiceAsync service;
	private Party currentParty;

	public PartyManagementPresenter(AdminServiceAsync service,
			PartyManagementView view) {
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
		if (currentParty == null)
			return;

		service.stoppParty(currentParty, new AsyncCallback<Party>() {
			@Override
			public void onSuccess(Party result) {
				view.setButtonEnabled(true, false);
				view.clear();
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Fehler beim Stopen der Party: " + caught);
			}
		});
	}

	protected void onStartClick() {
		service.startParty(new AsyncCallback<Party>() {
			@Override
			public void onSuccess(Party result) {
				currentParty = result;
				view.setButtonEnabled(false, true);
				view.setParty(currentParty);
				fetchPlaylistEntries();
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Fehler beim Starten der Party: " + caught);
			}
		});
	}

	public void go() {
		bind();
		view.clear();
		view.setButtonEnabled(true, false);
	}

	private void fetchPlaylistEntries() {
		service.getPlaylist(new AsyncCallback<GlobalPlaylist>() {
			@Override
			public void onSuccess(GlobalPlaylist result) {
				view.setPlaylist(result.getEntries());
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Die Playlist konnte nicht abgerufen werden: "
						+ caught);
			}
		});
	}
}
