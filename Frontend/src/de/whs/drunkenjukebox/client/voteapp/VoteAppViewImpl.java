package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.whs.drunkenjukebox.resources.AppConstants;
import de.whs.drunkenjukebox.resources.AppResources.VoteAppStyle;
import de.whs.drunkenjukebox.shared.PlayList;
import de.whs.drunkenjukebox.shared.PlayListEntry;

public class VoteAppViewImpl extends Composite implements VoteAppView {
	
	private AppConstants constants = GWT.create(AppConstants.class);
	
	private final FlexTable songTable = new FlexTable();
	private final Button diButton = new Button(constants.sendDI());
	private final VerticalPanel mainPanel = new VerticalPanel();
	private final DIDialogView diDialog;
	private final CurrentSongWidget currentSong;
	private final VoteAppStyle style;
	private VoteListener voteListener;
	
	public VoteAppViewImpl(VoteAppStyle style) {
		this.style = style;
		diButton.addStyleName(style.sendDi());
		mainPanel.add(diButton);
		currentSong = new CurrentSongWidget(style);
		currentSong.addStyleName(style.currentTrack());
		mainPanel.add(currentSong);
		mainPanel.add(songTable);
		
		songTable.addStyleName(style.fullWidth());
		mainPanel.addStyleName(style.fullWidth());
		
		diDialog = new DIDialogViewImpl(style);
		
		initWidget(mainPanel);
	}
	
	public void setPlaylist(PlayList pl)
	{
		songTable.clear();
		int rowCount = 0;
		for(PlayListEntry p : pl.getEntries())
		{
			PlayListEntryWidget entry = new PlayListEntryWidget(p, style);
			entry.setVoteListener(voteListener);
			songTable.setWidget(rowCount, 0, entry);
			++rowCount;
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

	@Override
	public CurrentSongWidget getCurrentSong() {
		return currentSong;
	}

	@Override
	public void setVoteListener(VoteListener listener) {
		voteListener = listener;
	}}
