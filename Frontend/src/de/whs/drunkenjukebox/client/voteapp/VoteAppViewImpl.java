package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.whs.drunkenjukebox.shared.PlayList;
import de.whs.drunkenjukebox.shared.PlayListEntry;

public class VoteAppViewImpl extends Composite implements VoteAppView {
	private final FlexTable songTable = new FlexTable();
	private final Button diButton = new Button("Send DI");
	private final VerticalPanel mainPanel = new VerticalPanel();
	private final DIDialogView diDialog = new DIDialogViewImpl();
	
	public VoteAppViewImpl() {
		mainPanel.add(diButton);
		mainPanel.add(songTable);
		initWidget(mainPanel);
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

	@Override
	public HasClickHandlers getDIButton() {
		return diButton;
	}

	@Override
	public DIDialogView getDIDialog() {
		return diDialog;
	}
}
