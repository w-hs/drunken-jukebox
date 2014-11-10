package de.whs.drunkenjukebox.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vote {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@Column(nullable = false)
	private PartyPeople voter;
	
	@ManyToOne
	@Column(nullable = false)
	private Song song;
	
	@Column(nullable = false)
	private Calendar timestamp;
	
	@Column(nullable = false)
	private boolean upOrDown;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PartyPeople getVoter() {
		return voter;
	}

	public void setVoter(PartyPeople voter) {
		this.voter = voter;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isUpOrDown() {
		return upOrDown;
	}

	public void setUpOrDown(boolean upOrDown) {
		this.upOrDown = upOrDown;
	}
}
