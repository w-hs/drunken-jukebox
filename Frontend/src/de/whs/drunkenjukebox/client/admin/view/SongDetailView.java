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
import de.whs.drunkenjukebox.client.admin.presenter.SongPresenter.SongDetailDisplay;

public class SongDetailView extends Composite implements SongDetailDisplay {

	private final Button buttonSave = new Button("Speichern");

	public SongDetailView() {
		VerticalPanel panel = new VerticalPanel();
		panel.setSpacing(8);

		panel.add(new InputBox("Interpret"));
		panel.add(new InputBox("Titel"));
		panel.add(new InputBox("Genre"));
		panel.add(new InputBox("Länge"));

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
}