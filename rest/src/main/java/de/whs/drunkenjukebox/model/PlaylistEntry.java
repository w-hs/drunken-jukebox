package de.whs.drunkenjukebox.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PlaylistEntry {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	private Song song;
	
	// Info ist doppelt enthalten �ber die Tabelle Vote
	private int voteCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	
	
}
