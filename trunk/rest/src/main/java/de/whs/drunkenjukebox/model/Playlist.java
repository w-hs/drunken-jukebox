package de.whs.drunkenjukebox.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Playlist {
	
	@Id
	@GeneratedValue
	private int id;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Collection<PlaylistEntry> entries = new ArrayList<PlaylistEntry>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<PlaylistEntry> getEntries() {
		return entries;
	}

	public void setEntries(Collection<PlaylistEntry> entries) {
		this.entries = entries;
	}

	public PlaylistEntry findSong(Song votedSong) {
		for (PlaylistEntry entry : entries)
		{
			if (entry.getSong().getId() == votedSong.getId())
				return entry;
		}
		return null;
	}
}
