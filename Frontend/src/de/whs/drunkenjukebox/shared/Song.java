package de.whs.drunkenjukebox.shared;

import java.io.Serializable;

public class Song implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String interpret;
	private int durationInSecs;
	private String genres;
	private String songSource;
	private SongSourceType songSourceType;

	public Song() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getSongSource() {
		return songSource;
	}

	public void setSongSource(String songSource) {
		this.songSource = songSource;
	}
	
	public SongSourceType getSongSourceType() {
		return songSourceType;
	}

	public void setSongSourceType(SongSourceType songSourceType) {
		this.songSourceType = songSourceType;
	}
	
	public void setSongSourceType(int type) {
		if (type == 0) {
			this.songSourceType = SongSourceType.local;
		}
		else if (type == 1) {
			this.songSourceType = SongSourceType.youtube;
		}
		else
			throw new RuntimeException(
				"songSourceType must be local (0) or youtube (1)");
	}
	
	public int getSongSourceTypeInt() {
		if (this.songSourceType == SongSourceType.local) {
			return 0;
		}
		else if (this.songSourceType == SongSourceType.youtube) {
			return 1;
		}
		else
			throw new IllegalStateException("SongSourceType must be youtube or local!");
	}
	
	@Override
	public String toString() {
		return "Id: " + id + " Title: " + title + " Interpret: " + interpret;
	}
}
