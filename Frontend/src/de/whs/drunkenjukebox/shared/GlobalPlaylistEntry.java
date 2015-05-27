package de.whs.drunkenjukebox.shared;

import java.io.Serializable;

public class GlobalPlaylistEntry implements Serializable {
	
	private static final long serialVersionUID = -5246711876414629328L;
	
	private int index;
	private String title;
	private int voteCount;
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public GlobalPlaylistEntry() {
		super();
	}

	public GlobalPlaylistEntry(int index, String title, int voteCount) {
		super();
		this.index = index;
		this.title = title;
		this.voteCount = voteCount;
	}
}
