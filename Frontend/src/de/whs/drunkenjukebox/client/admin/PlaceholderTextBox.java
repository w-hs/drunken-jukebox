package de.whs.drunkenjukebox.client.admin;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.TextBox;

public class PlaceholderTextBox extends TextBox implements FocusHandler, BlurHandler {

	private final String placeholderText;
	
	public PlaceholderTextBox(String placeholderText) {
		this.placeholderText = placeholderText;
		setText(placeholderText);
		addFocusHandler(this);
		addBlurHandler(this);
	}

	@Override
	public void onBlur(BlurEvent event) {
		if (getText().equals(""))
			setValue(placeholderText);
	}

	@Override
	public void onFocus(FocusEvent event) {
		if (getText().equals(placeholderText))
			setValue("");
	}
}
