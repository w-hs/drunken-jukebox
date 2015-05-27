package de.whs.drunkenjukebox.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GlobalPlaylist implements Serializable {
	private static final long serialVersionUID = -8661363586997406371L;
	
	private List<GlobalPlaylistEntry> entries = new ArrayList<GlobalPlaylistEntry>();
	
	public List<GlobalPlaylistEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<GlobalPlaylistEntry> entries) {
		this.entries = entries;
	}
}
