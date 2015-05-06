package de.whs.drunkenjukebox.client.admin;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class InputBox extends Composite {

	private final TextBox textBox = new TextBox();
	
	public void setText(String text) {
		textBox.setText(text);
	}
	
	public String getText() { 
		return textBox.getText(); 
	}
	
	public InputBox(String caption) {
		HorizontalPanel panel = new HorizontalPanel();
		panel.setWidth("100%");

		Label label = new Label(caption);
		panel.add(label);
		
		panel.add(textBox);
		panel.setCellHorizontalAlignment(textBox, HasHorizontalAlignment.ALIGN_RIGHT);
		
		initWidget(panel);
	}
	
}
