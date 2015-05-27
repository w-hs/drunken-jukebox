package de.whs.drunkenjukebox.client.admin;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

import de.whs.drunkenjukebox.resources.AppResources;

public class InputBox extends Composite {

	private final TextBox textBox = new TextBox();
	
	public void setText(String text) {
		textBox.setText(text);
	}
	
	public String getText() { 
		return textBox.getText(); 
	}
	
	public void clear() {
		textBox.setText("");
	}
	
	public void setFocus(boolean focused) {
		textBox.setFocus(focused);
	}
	
	public InputBox(String caption, AppResources.AdminStyle style) {
		HorizontalPanel panel = new HorizontalPanel();
		panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		panel.setWidth("100%");

		Label label = new Label(caption);
		label.addStyleName(style.inputBoxLabel());
		panel.setCellVerticalAlignment(label, HasVerticalAlignment.ALIGN_MIDDLE);
		panel.add(label);
		
		panel.add(textBox);
		panel.setCellHorizontalAlignment(textBox, HasHorizontalAlignment.ALIGN_RIGHT);
		textBox.addStyleName(style.inputBoxText());
		
		initWidget(panel);
	}
	
}
