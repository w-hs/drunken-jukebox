package de.whs.drunkenjukebox.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Admin implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		Label label = new Label("Admin");
		RootPanel.get().add(label);
	}

}
