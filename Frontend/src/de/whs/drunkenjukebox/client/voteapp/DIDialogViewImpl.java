package de.whs.drunkenjukebox.client.voteapp;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DIDialogViewImpl extends DialogBox implements DIDialogView {
	
	private Button acceptButton = new Button("OK");
	private Button cancelButton = new Button("Schlieﬂen");
	private DISlider diSlider = new DISlider(20,"100%");
	
	public DIDialogViewImpl() {
		setText("Bitte ihren DI einsliden");	    
		
		VerticalPanel mainPanel = new VerticalPanel();
		mainPanel.setWidth("300px");
		mainPanel.setHeight("200px");
		
		HorizontalPanel titles = new HorizontalPanel();
		titles.setWidth("100%");
		Label startLabel = new Label("Sober");
		Label middleLabel = new Label("Funny");
		Label endLabel = new Label("Drunk");
		titles.add(startLabel);
		titles.add(middleLabel);
		titles.add(endLabel);
		
		titles.setCellHorizontalAlignment(middleLabel, HasHorizontalAlignment.ALIGN_CENTER);
		titles.setCellHorizontalAlignment(endLabel, HasHorizontalAlignment.ALIGN_RIGHT);
		
		HorizontalPanel buttonBar = new HorizontalPanel();
		buttonBar.setWidth("100%");
		buttonBar.add(acceptButton);
		buttonBar.add(cancelButton);
		
		buttonBar.setCellHorizontalAlignment(cancelButton, HasHorizontalAlignment.ALIGN_RIGHT);
		
		mainPanel.add(titles);
		mainPanel.add(diSlider);
		mainPanel.add(buttonBar);

		setGlassEnabled(true);
		setAnimationEnabled(true);
		
	    setWidget(mainPanel);
	}

	@Override
	public HasClickHandlers getAcceptButton() {
		return acceptButton;
	}

	@Override
	public HasClickHandlers getCancelButton() {
		return cancelButton;
	}

	@Override
	public DialogBox asDialogBox() {
		return this;
	}

}
