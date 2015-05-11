package de.whs.drunkenjukebox.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.whs.drunkenjukebox.client.admin.SongsService;
import de.whs.drunkenjukebox.shared.Song;

public class SongsServiceImpl extends RemoteServiceServlet implements SongsService {
	
	private static final long serialVersionUID = -8457486819910574309L;
	private final Map<Integer, Song> songs = new HashMap<Integer, Song>();
	
	public SongsServiceImpl() {
		songs.put(1, createSong(1, "Jingle Bells"));
		songs.put(2, createSong(2, "Last Christmas"));
		songs.put(3, createSong(3, "Wonderful Dream"));
	}	
	
	
	@Override
	public ArrayList<Song> getSongList() {
		return new ArrayList<>(songs.values());
	}

	private Song createSong(int id, String title) {
		List<String> genres = new ArrayList<String>();
		genres.add("Classic");
		genres.add("Pop");
		
		Song song = new Song();
		song.setId(id);
		song.setInterpret("Wham");
		song.setTitle(title);
		song.setGenres(genres);
		song.setSongSource("https://www.youtube.com/");
		song.setDurationInSecs(186);
	
		return song;
	}

	@Override
	public Song getSong(String id) {		
		return songs.containsKey(id) ? songs.get(id) : null;
	}

	@Override
	public Song updateSong(Song song) {
		songs.put(song.getId(), song);
		return songs.get(song.getId());
	}

}
