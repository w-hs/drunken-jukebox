package de.whs.drunkenjukebox.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayList implements Serializable {

	private static final long serialVersionUID = 135198215138456449L;
	
	private List<PlayListEntry> entries = new ArrayList<PlayListEntry>();

	public List<PlayListEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<PlayListEntry> entries) {
		this.entries = entries;
	}	
}
