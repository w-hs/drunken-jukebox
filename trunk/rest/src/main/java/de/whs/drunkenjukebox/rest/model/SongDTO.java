package de.whs.drunkenjukebox.rest.model;

import de.whs.drunkenjukebox.model.LocalFileSource;
import de.whs.drunkenjukebox.model.Song;
import de.whs.drunkenjukebox.model.YouTubeSource;

public class SongDTO {
	private Song song;
	private YouTubeSource youtube;
	private LocalFileSource localFile;
	public Song getSong() {
		return song;
	}
	public void setSong(Song song) {
		this.song = song;
	}
	public YouTubeSource getYoutube() {
		return youtube;
	}
	public void setYoutube(YouTubeSource youtube) {
		this.youtube = youtube;
	}
	public LocalFileSource getLocalFile() {
		return localFile;
	}
	public void setLocalFile(LocalFileSource localFile) {
		this.localFile = localFile;
	}
	
	
}
