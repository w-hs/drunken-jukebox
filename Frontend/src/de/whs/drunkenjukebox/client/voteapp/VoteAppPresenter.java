package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasWidgets;

import de.whs.drunkenjukebox.shared.PlayList;
import de.whs.drunkenjukebox.shared.Song;
import de.whs.drunkenjukebox.shared.VoteAppServiceAsync;

public class VoteAppPresenter {

	private VoteAppView view;
	private VoteAppServiceAsync service;
	
	public VoteAppPresenter(final VoteAppView view, VoteAppServiceAsync service)
	{
		this.view = view;
		this.service = service;
		this.service.getPlayList(new AsyncCallback<PlayList>() {	
			@Override
			public void onSuccess(PlayList result) {
				view.setPlaylist(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO: Error handling
				
			}
		});
		
		this.service.getCurrentSong(new AsyncCallback<Song>() {	
			@Override
			public void onSuccess(Song result) {
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
	}
	
	public void bind() 
	{
		final DialogBox dialog = view.getDIDialog().asDialogBox(); 
		
		view.getDIButton().addClickHandler(new ClickHandler() { public void onClick(ClickEvent sender) {
			dialog.center();
			dialog.show();
	    }});
		
		view.getDIDialog().getAcceptButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// TODO: DI senden
				dialog.hide();
			}
		});
		
		view.getDIDialog().getCancelButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				dialog.hide();
			}
		});
	}
	
	public void go(HasWidgets container)
	{
		container.add(view.asWidget());
	}
	
}