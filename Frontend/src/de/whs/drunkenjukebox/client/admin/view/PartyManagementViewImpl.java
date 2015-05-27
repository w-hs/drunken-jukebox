package de.whs.drunkenjukebox.client.admin.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
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

import de.whs.drunkenjukebox.resources.AppResources.AdminStyle;
import de.whs.drunkenjukebox.shared.GlobalPlaylistEntry;
import de.whs.drunkenjukebox.shared.Party;

public class PartyManagementViewImpl extends Composite implements PartyManagementView {

	private final Button buttonStart = new Button("Start");
	private final Button buttonStop = new Button("Stopp");
	private final CellTable<GlobalPlaylistEntry> table = new CellTable<>();
	
	private final String startText = "Start: ";
	private final Label labelStart = new Label(startText);
	
	private final String partyPeopleText = "Gäste: ";
	private final Label labelPartyPeopleCount = new Label(partyPeopleText);
	
	private final String drunkenIndexText = "Drunken-Index: ";
	private final Label labelDrunkenIndex = new Label(drunkenIndexText);

	public PartyManagementViewImpl(AdminStyle style) {
		HorizontalPanel panel = new HorizontalPanel();
		initLeftSide(panel);
		initRightSide(panel);

		initWidget(panel);
	}

	private void initRightSide(HorizontalPanel panel) {
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
		table.addColumn(indexColumn, "Index");

		Column<GlobalPlaylistEntry, String> titleColumn = new Column<GlobalPlaylistEntry, String>(
				new TextCell()) {
			@Override
			public String getValue(GlobalPlaylistEntry object) {
				return object.getTitle();
			}
		};
		table.addColumn(titleColumn, "Titel");

		Column<GlobalPlaylistEntry, Number> voteCountCell = new Column<GlobalPlaylistEntry, Number>(
				new NumberCell(NumberFormat.getFormat("+#;-#"))) {
			@Override
			public Number getValue(GlobalPlaylistEntry object) {
				return object.getVoteCount();
			}
		};
		table.addColumn(voteCountCell, "Vote");
	}

	private void initLeftSide(CellPanel layout) {
		VerticalPanel panel = new VerticalPanel();
		layout.add(panel);
		
		panel.add(labelStart);
		panel.add(labelPartyPeopleCount);
		panel.add(labelDrunkenIndex);
		
		HorizontalPanel panelButtons = new HorizontalPanel();
		panelButtons.add(buttonStart);
		panelButtons.add(buttonStop);
		panel.add(panelButtons);
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
		labelStart.setText(startText + p.getPartyStart());
		labelDrunkenIndex.setText(drunkenIndexText + p.getDrunkenIndex());
		labelPartyPeopleCount.setText(partyPeopleText + p.getPartyPeopleCount());
	}

	@Override
	public void setPlaylist(List<GlobalPlaylistEntry> entries) {
		table.setRowData(entries);
	}

	@Override
	public void clear() {
		table.setRowData(new ArrayList<GlobalPlaylistEntry>());
		
		labelStart.setText(startText);
		labelDrunkenIndex.setText(drunkenIndexText);
		labelPartyPeopleCount.setText(partyPeopleText);
	}
}
