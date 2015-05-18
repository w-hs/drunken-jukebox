package de.whs.drunkenjukebox.client.admin.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.whs.drunkenjukebox.model.GlobalPlaylistEntry;

public class PartyTabPage extends Composite {

	private final Button buttonStart = new Button("Start");
	private final Button buttonStop = new Button("Stopp");
	private final Label labelStart = new Label("Start: ");
	private final Label labelPartyPeopleCount = new Label("PartyPeople: ");
	private final Label labelDrunkenIndex = new Label("Drunken-Index: ");
	private final CellTable<GlobalPlaylistEntry> table = new CellTable<>();

	public PartyTabPage() {
		HorizontalPanel panel = new HorizontalPanel();
		
		initLeftSide(panel);
		initRightSide(panel);

		initWidget(panel);
	}

	private void initRightSide(HorizontalPanel panel) {
		initTableColumns();
		panel.add(table);
		
		List<GlobalPlaylistEntry> entries = new ArrayList<GlobalPlaylistEntry>();
		entries.add(new GlobalPlaylistEntry(1, "Last Christmas", 15));
		entries.add(new GlobalPlaylistEntry(2, "Jingle Bells", -5));
		entries.add(new GlobalPlaylistEntry(3, "Daniels Test", 0));
		table.setRowData(entries);
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

}
