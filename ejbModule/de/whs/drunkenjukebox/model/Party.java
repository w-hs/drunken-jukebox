package de.whs.drunkenjukebox.model;

import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Party {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private Calendar startTime;
	
	private Calendar endTime;
	
	@OneToOne
	private Song currentSong;
	
	@OneToOne
	private Playlist playlist;
	
	@OneToMany
	private Collection<PartyPeople> guests;
	
	@OneToMany
	private Collection<PlayedSong> playedSongs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public Song getCurrentSong() {
		return currentSong;
	}

	public void setCurrentSong(Song currentSong) {
		this.currentSong = currentSong;
	}
}
