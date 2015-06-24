package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasWidgets;

import de.whs.drunkenjukebox.shared.PlayList;
import de.whs.drunkenjukebox.shared.PlayListEntry;
import de.whs.drunkenjukebox.shared.Song;
import de.whs.drunkenjukebox.shared.Vote;
import de.whs.drunkenjukebox.shared.VoteAppServiceAsync;

public class VoteAppPresenter {

	private VoteAppView view;
	private VoteAppServiceAsync service;
	
	private AsyncCallback<Void> voteCallback = new AsyncCallback<Void>() {
		@Override
		public void onSuccess(Void result) {
			updatePlayList();
		}
		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Voting failed: " + caught);
		}
	};
	
	public VoteAppPresenter(final VoteAppView view,final VoteAppServiceAsync service)
	{
		this.view = view;
		this.service = service;
		
		view.setVoteListener(new VoteListener() {
			@Override
			public void onUpVote(PlayListEntry entry) {
				service.sendVote(entry, Vote.UP, voteCallback);
			}
			@Override
			public void onDownVote(PlayListEntry entry) {
				service.sendVote(entry, Vote.DOWN, voteCallback);
			}
		});
		
		updatePlayList();
		
		this.service.getCurrentSong(new AsyncCallback<Song>() {	
			@Override
			public void onSuccess(Song result) {
				view.getCurrentSong().setInterpreter(result.getInterpret());
				view.getCurrentSong().setSongName(result.getTitle());
			}
			
			@Override
			public void onFailure(Throwable caught) {
				
			}
		});
		
		Timer timer = new Timer() {	
			@Override
			public void run() {
				updatePlayList();
			}
		};
		
		timer.scheduleRepeating(5000);
	}
	
	private void updatePlayList()
	{
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