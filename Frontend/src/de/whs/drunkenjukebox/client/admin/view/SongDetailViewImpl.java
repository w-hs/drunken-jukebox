package de.whs.drunkenjukebox.client.admin.view;

import java.util.Arrays;

import com.google.gwt.event.dom.client.HasClickHandlers;
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
	private final TextBox songSource = new TextBox();
	
	private final Button buttonSave = new Button("Speichern");
	private final Button buttonRemove = new Button("Entfernen");

	public SongDetailViewImpl() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(8);

		panel.add(interpret);
		panel.add(title);
		panel.add(genre);
		panel.add(length);

		panel.add(getSourcePanel());

		HorizontalPanel buttonPanel = new HorizontalPanel();		
		buttonPanel.add(buttonSave);
		buttonPanel.add(buttonRemove);
		buttonPanel.setCellHorizontalAlignment(buttonRemove, HasHorizontalAlignment.ALIGN_RIGHT);
		buttonPanel.setWidth("100%");
		panel.add(buttonPanel);
		
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
		radioButtons.add(new RadioButton("SongSource", "YouTube"));
		radioButtons.add(new RadioButton("SongSource", "Lokal"));
		panel.add(radioButtons);

		panel.add(songSource);

		// Wrap the content in a DecoratorPanel
		DecoratorPanel decPanel = new DecoratorPanel();
		decPanel.setWidth("100%");
		decPanel.setWidget(panel);
		return decPanel;
	}

	@Override
	public void setSong(Song song) {
		title.setText(song.getTitle());
		interpret.setText(song.getInterpret());
		
		String genres = "";
		for (String s : song.getGenres())
			genres += s + ", ";
		genres = genres.substring(0, genres.length() - 2);
		
		genre.setText(genres);
		length.setText(new Integer(song.getDurationInSecs()).toString());
		songSource.setText(song.getSongSource());
	}

	@Override
	public void clear() {
		title.clear();
		interpret.clear();
		genre.clear();
		length.clear();
		songSource.setText("");
	}
	
	@Override
	public HasClickHandlers getRemoveButton() {
		return buttonRemove;
	}

	@Override
	public Song getSong() {
		Song song = new Song();
		song.setDurationInSecs(Integer.parseInt(length.getText()));
		String[] genres = genre.getText().split(", ");		
		song.setGenres(Arrays.asList(genres));
		song.setInterpret(interpret.getText());
		song.setTitle(title.getText());
		song.setSongSource(songSource.getText());
		
		return song;
	}

	@Override
	public void setFocusToInterpretBox() {
		interpret.setFocus(true);
	}

	@Override
	public HasClickHandlers getSaveButton() {
		return buttonSave;
	}
}