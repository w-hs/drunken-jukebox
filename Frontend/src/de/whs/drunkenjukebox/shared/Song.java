package de.whs.drunkenjukebox.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Song implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String interpret;
	private int durationInSecs;
	private List<String> genres = new ArrayList<String>();
	private String songSource;

	public Song() {

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

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public String getSongSource() {
		return songSource;
	}

	public void setSongSource(String songSource) {
		this.songSource = songSource;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + " Title: " + title + " Interpret: " + interpret;
	}
}
