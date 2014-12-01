package de.whs.drunkenjukebox.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PlayedSong {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(cascade = { CascadeType.REFRESH })
	private Song song;
	
	@Column(unique = true, nullable = false)
	private Calendar timestamp;
	
	@Column(nullable = false)
	private int voteCount;
	
	@Column(nullable = false)
	private float averageDI;

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

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public float getAverageDI() {
		return averageDI;
	}

	public void setAverageDI(float averageDI) {
		this.averageDI = averageDI;
	}
}
