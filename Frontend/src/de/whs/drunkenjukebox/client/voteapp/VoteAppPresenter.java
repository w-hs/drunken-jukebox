package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import de.whs.drunkenjukebox.model.PlayList;
import de.whs.drunkenjukebox.shared.VoteAppService;
import de.whs.drunkenjukebox.shared.VoteAppServiceAsync;

public class VoteAppPresenter {

	private Display display;
	private VoteAppService service;
	
	public VoteAppPresenter(final Display display, VoteAppServiceAsync service)
	{
		this.display = display;
		service.getPlayList(new AsyncCallback<PlayList>() {	
			@Override
			public void onSuccess(PlayList result) {
				display.setPlaylist(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO: Error handling
			}
		});
	}
	
	public void go(HasWidgets container)
	{
		container.add(display.asWidget());
	}
	
	public interface Display
	{
		void setPlaylist(PlayList pl);
		Widget asWidget();
	}
	
}
