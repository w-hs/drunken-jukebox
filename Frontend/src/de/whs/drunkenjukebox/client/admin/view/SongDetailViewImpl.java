package de.whs.drunkenjukebox.client.admin.view;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import de.whs.drunkenjukebox.client.admin.InputBox;
import de.whs.drunkenjukebox.shared.Song;

public class SongDetailViewImpl extends Composite implements SongDetailView {

	private final InputBox interpret = new InputBox("Interpret");
	private final InputBox title = new InputBox("Titel");
	private final InputBox genre = new InputBox("Genre");
	private final InputBox length = new InputBox("Länge");
	
	private final Button buttonSave = new Button("Speichern");

	public SongDetailViewImpl() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(8);

		panel.add(interpret);
		panel.add(title);
		panel.add(genre);
		panel.add(length);

		panel.add(getSourcePanel());

		panel.add(buttonSave);
		panel.setCellHorizontalAlignment(buttonSave,
				HasHorizontalAlignment.ALIGN_RIGHT);

		// Wrap the content in a DecoratorPanel
		DecoratorPanel decPanel = new DecoratorPanel();
		decPanel.setWidget(panel);
		initWidget(decPanel);
	}

	public Widget getSourcePanel() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(8);
		
		panel.add(new Label("Quelle"));

		HorizontalPanel radioButtons = new HorizontalPanel();
		radioButtons.add(new RadioButton("YouTube", "YouTube"));
		radioButtons.add(new RadioButton("Lokal", "Lokal"));
		panel.add(radioButtons);

		panel.add(new TextBox());

		// Wrap the content in a DecoratorPanel
		DecoratorPanel decPanel = new DecoratorPanel();
		decPanel.setWidth("100%");
		decPanel.setWidget(panel);
		return decPanel;
	}

	@Override
	public void setSong(Song song) {
		title.setText(song.getTitle());
		interpret.setText(song.getTitle());
		
		String genres = "";
		for (String s : song.getGenres())
			genres += s + ", ";
		genres = genres.substring(0, genres.length() - 2);
		
		genre.setText(genres);
		length.setText(new Integer(song.getDurationInSecs()).toString());
	}

	@Override
	public void clear() {
		title.clear();
		interpret.clear();
		genre.clear();
		length.clear();
	}
}