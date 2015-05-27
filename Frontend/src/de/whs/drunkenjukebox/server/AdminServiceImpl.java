package de.whs.drunkenjukebox.server;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.whs.drunkenjukebox.client.admin.AdminService;
import de.whs.drunkenjukebox.shared.GlobalPlaylistEntry;
import de.whs.drunkenjukebox.shared.Party;
import de.whs.drunkenjukebox.shared.Song;

public class AdminServiceImpl extends RemoteServiceServlet implements AdminService {
	
	private static final long serialVersionUID = -8457486819910574309L;
	private static int lastInsertId;
	private final Map<Integer, Song> songs = new HashMap<Integer, Song>();
	
	public AdminServiceImpl() {
		songs.put(getId(), createSong(1, "Jingle Bells"));
		songs.put(getId(), createSong(2, "Last Christmas"));
		songs.put(getId(), createSong(3, "Wonderful Dream"));
	}	
	
	static int getId() {
		return ++lastInsertId;
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
		return songs.put(song.getId(), song);
	}

	@Override
	public void removeSong(int songId) {
		songs.remove(songId);
	}

	@Override
	public Song addSong(Song song) {
		song.setId(getId());
		songs.put(song.getId(), song);
		return song;
	}

	@Override
	public Party startParty() {
		return new Party(0, 0, LocalDateTime.now());
	}

	@Override
	public Party stoppParty(Party p) {
		return p;
	}

	@Override
	public List<GlobalPlaylistEntry> getPlaylist() {
		List<GlobalPlaylistEntry> entries = new ArrayList<GlobalPlaylistEntry>();
		entries.add(new GlobalPlaylistEntry(1, "Last Christmas", 15));
		entries.add(new GlobalPlaylistEntry(2, "Jingle Bells", -5));
		entries.add(new GlobalPlaylistEntry(3, "Daniels Test", 0));
		
		return entries;
	}
}
