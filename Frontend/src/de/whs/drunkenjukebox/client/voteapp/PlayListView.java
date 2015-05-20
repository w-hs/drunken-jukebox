package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;

import de.whs.drunkenjukebox.shared.PlayList;
import de.whs.drunkenjukebox.shared.PlayListEntry;

public class PlayListView extends Composite implements VoteAppPresenter.Display {
	private final FlexTable songTable = new FlexTable();
	
	public PlayListView() {		
		initWidget(songTable);
	}
	
	public void setPlaylist(PlayList pl)
	{
		songTable.clear();
		for(PlayListEntry p : pl.getEntries())
		{
			int numRows = songTable.getRowCount();
			songTable.setWidget(numRows, 0, new PlayListEntryView(p));
		}
	}
}
