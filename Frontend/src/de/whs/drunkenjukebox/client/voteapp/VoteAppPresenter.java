package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import de.whs.drunkenjukebox.model.PlayList;
import de.whs.drunkenjukebox.model.PlayListEntry;
import de.whs.drunkenjukebox.model.VoteResult;

public class VoteAppPresenter {

	private Display display;
	
	public VoteAppPresenter(Display display)
	{
		this.display = display;
		display.setPlaylist(getPlaylist());
	}
	
	public void go(HasWidgets container)
	{
		container.add(display.asWidget());
	}
	
	
	private PlayList getPlaylist()
	{
		PlayList pl = new PlayList();
		PlayListEntry entry = new PlayListEntry();
		entry.setSongName("Last Christmas");
		entry.setInterpreter("WHAMMMMMM");
		entry.setVoteResult(VoteResult.DOWN_VOTED);
		pl.getEntries().add(entry);
		pl.getEntries().add(entry);
		pl.getEntries().add(entry);
		pl.getEntries().add(entry);
		pl.getEntries().add(entry);
		return pl;
	}
	
	public interface Display
	{
		void setPlaylist(PlayList pl);
		Widget asWidget();
	}
	
}
