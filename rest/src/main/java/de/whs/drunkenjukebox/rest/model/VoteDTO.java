package de.whs.drunkenjukebox.rest.model;

public class VoteDTO {
	private boolean up;
	private int songId;
	
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
}
