package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;

public class SongList extends Composite {
	private final FlexTable songTable = new FlexTable();
	
	public SongList() {
		for (int i = 0; i < 5; ++i) {
			int numRows = songTable.getRowCount();
			songTable.setWidget(numRows, 0, new SongListEntry());
		}
		
		initWidget(songTable);
	}
}
