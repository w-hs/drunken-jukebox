package de.whs.drunkenjukebox.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LocalFileSource extends SongSource {
	
	@Column(unique = true, nullable = false)
	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
