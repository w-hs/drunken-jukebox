package de.whs.drunkenjukebox.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { 
		@UniqueConstraint(name = "SongTitle", columnNames = { "title", "interpret", "album" }) })
public class Song {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String interpret;
	
	@Column(nullable = false)
	private String album;
	
	private int durationInSecs;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REFRESH })
	private Collection<Genre> genres = new ArrayList<Genre>();
	
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL }, orphanRemoval = true)
	private SongSource source;
	
	public SongSource getSource() {
		return source;
	}

	public void setSource(SongSource source) {
		this.source = source;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDurationInSecs() {
		return durationInSecs;
	}

	public void setDurationInSecs(int durationInSecs) {
		this.durationInSecs = durationInSecs;
	}

	public String getInterpret() {
		return interpret;
	}

	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Collection<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Collection<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
