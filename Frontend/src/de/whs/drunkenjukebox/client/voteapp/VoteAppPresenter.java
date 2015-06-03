package de.whs.drunkenjukebox.client.voteapp;

import java.util.Comparator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
	
	public VoteAppPresenter(final VoteAppView view,final VoteAppServiceAsync service)
	{
		this.view = view;
		this.service = service;
		
		view.setVoteListener(new VoteListener() {
			
			@Override
			public void onUpVote(PlayListEntryWidget entry) {
				service.sendVote(entry.playlistEntry, Vote.UP, new AsyncCallback<Void>() {	
					@Override
					public void onFailure(Throwable caught) {
						// TODO: Error handling
						
					}
		
					@Override
					public void onSuccess(Void result) {
						// TODO Auto-generated method stub
						
					}
				});
			}
			
			@Override
			public void onDownVote(PlayListEntryWidget entry) {
				service.sendVote(entry.playlistEntry, Vote.DOWN, new AsyncCallback<Void>() {	
					@Override
					public void onFailure(Throwable caught) {
						// TODO: Error handling
						
					}
		
					@Override
					public void onSuccess(Void result) {
						// TODO Auto-generated method stub
						
					}
				});
			}
		});
		
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
				view.getCurrentSong().setInterpreter(result.getInterpret());
				view.getCurrentSong().setSongName(result.getTitle());
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