package de.whs.drunkenjukebox.resources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

public interface AppResources extends ClientBundle {
	public interface VoteAppStyle extends CssResource {
		
	}
	
	@Source("vote-app.gss")
	VoteAppStyle voteAppStyle();
}
