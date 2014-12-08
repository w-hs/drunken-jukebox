package de.whs.drunkenjukebox.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class YouTubeSource extends SongSource {
	
	@Column(unique = true)
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
