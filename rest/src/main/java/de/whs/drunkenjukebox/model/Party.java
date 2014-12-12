package de.whs.drunkenjukebox.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.CascadeType;
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
	
	@OneToOne(cascade = { CascadeType.REFRESH })
	private Song currentSong;
	
	@OneToOne(cascade = { CascadeType.ALL })
	private Playlist playlist;
	
	@OneToMany(cascade = { CascadeType.ALL })
	private Collection<PartyPeople> guests = new ArrayList<PartyPeople>();
	
	@OneToMany(cascade = { CascadeType.ALL })
	private Collection<PlayedSong> playedSongs = new ArrayList<PlayedSong>();
	
	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public Collection<PartyPeople> getGuests() {
		return guests;
	}

	public void setGuests(Collection<PartyPeople> guests) {
		this.guests = guests;
	}

	public Collection<PlayedSong> getPlayedSongs() {
		return playedSongs;
	}

	public void setPlayedSongs(Collection<PlayedSong> playedSongs) {
		this.playedSongs = playedSongs;
	}

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

	public int getCurrentAverageDi() {
		int allDiValues = 0;
		if (getGuests().size() == 0)
			return 0; // Wenn die Party anfängt, ist man nüchtern
		for (PartyPeople p : getGuests())
			allDiValues += p.getCurrentDI();
		return allDiValues / getGuests().size();
	}
}
