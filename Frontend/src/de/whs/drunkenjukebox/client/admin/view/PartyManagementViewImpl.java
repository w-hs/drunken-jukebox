package de.whs.drunkenjukebox.client.admin.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.whs.drunkenjukebox.resources.AppConstants;
import de.whs.drunkenjukebox.resources.AppMessages;
import de.whs.drunkenjukebox.resources.AppResources.AdminStyle;
import de.whs.drunkenjukebox.shared.GlobalPlaylistEntry;
import de.whs.drunkenjukebox.shared.Party;

public class PartyManagementViewImpl extends Composite implements PartyManagementView {

	private AppConstants constants = GWT.create(AppConstants.class);
	private AppMessages messages = GWT.create(AppMessages.class);
	
	private final Button buttonStart = new Button(constants.startParty());
	private final Button buttonStop = new Button(constants.stopParty());
	private final CellTable<GlobalPlaylistEntry> table = new CellTable<>();
	
	private final Label labelStart = new Label("");
	
	private final Label labelPartyPeopleCount = new Label("");
	
	private final Label labelDrunkenIndex = new Label("");

	public PartyManagementViewImpl(AdminStyle style) {
		//two panels due to styling issues
		HorizontalPanel outerPanel = new HorizontalPanel();
		HorizontalPanel panel = new HorizontalPanel();		
		outerPanel.add(panel);		
		panel.addStyleName(style.partyManagementView());
		
		initLeftSide(panel, style);
		initRightSide(panel, style);

		initWidget(outerPanel);
	}

	private void initRightSide(HorizontalPanel panel, AdminStyle style) {
		initTableColumns();
		panel.add(table);
	}

	private void initTableColumns() {
		NumberCell numberCell = new NumberCell();
		Column<GlobalPlaylistEntry, Number> indexColumn = new Column<GlobalPlaylistEntry, Number>(
				numberCell) {
			@Override
			public Integer getValue(GlobalPlaylistEntry object) {
				return object.getIndex();
			}
		};
		table.addColumn(indexColumn, constants.position());

		Column<GlobalPlaylistEntry, String> titleColumn = new Column<GlobalPlaylistEntry, String>(
				new TextCell()) {
			@Override
			public String getValue(GlobalPlaylistEntry object) {
				return object.getTitle();
			}
		};
		table.addColumn(titleColumn, constants.title());

		Column<GlobalPlaylistEntry, Number> voteCountCell = new Column<GlobalPlaylistEntry, Number>(
				new NumberCell(NumberFormat.getFormat("+#;-#"))) {
			@Override
			public Number getValue(GlobalPlaylistEntry object) {
				return object.getVoteCount();
			}
		};
		table.addColumn(voteCountCell, constants.vote());
	}

	private void initLeftSide(CellPanel layout, AdminStyle style) {
		VerticalPanel panel = new VerticalPanel();
		layout.add(panel);
		
		HorizontalPanel panelButtons = new HorizontalPanel();
		buttonStart.addStyleName(style.greenButton());
		panelButtons.add(buttonStart);
		buttonStop.addStyleName(style.redButton());
		panelButtons.add(buttonStop);
		panel.add(panelButtons);
				
		panel.add(labelStart);
		labelStart.addStyleName(style.partyManagementViewDetails());
		panel.add(labelPartyPeopleCount);
		labelPartyPeopleCount.addStyleName(style.partyManagementViewDetails());
		panel.add(labelDrunkenIndex);
		labelDrunkenIndex.addStyleName(style.partyManagementViewDetails());
	}

	@Override
	public HasClickHandlers getStartButton() {
		return buttonStart;
	}

	@Override
	public HasClickHandlers getStopButton() {
		return buttonStop;
	}

	@Override
	public void setButtonEnabled(boolean startButtonEnabled,
			boolean stoppButtonEnabled) {
		buttonStart.setEnabled(startButtonEnabled);
		buttonStop.setEnabled(stoppButtonEnabled);
	}

	@Override
	public void setParty(Party p) {
		labelStart.setText(messages.startDate(p.getPartyStart()));
		labelDrunkenIndex.setText(messages.drunkenIndex(p.getDrunkenIndex()));
		labelPartyPeopleCount.setText(messages.guestCount(p.getPartyPeopleCount()));
	}

	@Override
	public void setPlaylist(List<GlobalPlaylistEntry> entries) {
		table.setRowData(entries);
	}

	@Override
	public void clear() {
		table.setRowData(new ArrayList<GlobalPlaylistEntry>());
		
		labelStart.setText("");
		labelDrunkenIndex.setText("");
		labelPartyPeopleCount.setText("");
	}
}
