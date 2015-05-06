package de.whs.drunkenjukebox.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.whs.drunkenjukebox.client.admin.SongsService;
import de.whs.drunkenjukebox.shared.Song;

public class SongsServiceImpl extends RemoteServiceServlet implements SongsService {

	@Override
	public ArrayList<Song> getSongList() {
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(getLastChristmas());
		
		return songs;
	}

	private Song getLastChristmas() {
		List<String> genres = new ArrayList<String>();
		genres.add("Classic");
		genres.add("Pop");
		
		Song song = new Song();
		song.setId(1);
		song.setInterpret("Wham");
		song.setTitle("Last Christmas");
		song.setGenres(genres);
		song.setSongSource("https://www.youtube.com/");
		song.setDurationInSecs(186);
	
		return song;
	}

	@Override
	public Song getSong(String id) {
		return getLastChristmas();
	}

	@Override
	public Song updateSong(Song song) {
		return getLastChristmas();
	}

}
