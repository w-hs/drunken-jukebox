package de.whs.drunkenjukebox.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.whs.drunkenjukebox.client.admin.AdminService;
import de.whs.drunkenjukebox.shared.GlobalPlaylist;
import de.whs.drunkenjukebox.shared.GlobalPlaylistEntry;
import de.whs.drunkenjukebox.shared.Party;
import de.whs.drunkenjukebox.shared.Song;

public class AdminServiceImpl extends RemoteServiceServlet implements
		AdminService {

	private static final long serialVersionUID = -8457486819910574309L;
	private static final String ServerURL = "http://localhost:2403/";

	@Override
	public ArrayList<Song> getSongList() {
		ArrayList<Song> result = new ArrayList<Song>();
		JSONArray songs = Snippets.getJsonArray(ServerURL + "songs");

		for (int i = 0; i < songs.length(); i++) {
			try {
				JSONObject song = songs.getJSONObject(i);
				result.add(Snippets.getSongFromJsonObject(song));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public Song getSong(String id) {
		return Snippets.getSongFromID(id, ServerURL);
	}

	@Override
	public Song updateSong(Song song) {
		try {
			JSONObject jsonSong = Snippets.getJsonObjectFrom(song);
			JSONObject result = Snippets.put(ServerURL + "songs", jsonSong);
			return Snippets.getSongFromJsonObject(result);
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void removeSong(String songId) {
		Snippets.delete(ServerURL + "songs/" + songId);
	}

	@Override
	public Song addSong(Song song) {
		try {
			JSONObject jsonSong = Snippets.getJsonObjectFrom(song);
			JSONObject result = Snippets.post(ServerURL + "songs", jsonSong);
			return Snippets.getSongFromJsonObject(result);

		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Party startParty() {
		Party p = new Party();
		JSONObject object = Snippets.post(ServerURL + "party");

		try {
			p.setPartyId(object.getString("id"));
			p.setDrunkenIndex(object.getInt("avgDI"));
			p.setPartyPeopleCount(object.getInt("guestCount"));

			String format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			p.setPartyStart(sdf.parse(object.getString("start")));
		} catch (JSONException | ParseException e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public Party stoppParty(Party p) {
		return p;
	}

	@Override
	public GlobalPlaylist getPlaylist() {
		GlobalPlaylist playlist = new GlobalPlaylist();
		JSONArray array = Snippets.getJsonArray(ServerURL + "playlist");

		if (array == null)
			return playlist;

		for (int i = 0; i < array.length(); i++) {
			try {
				JSONObject entry = array.getJSONObject(i);

				int index = entry.getInt("position");
				int votes = entry.getInt("votes");
				String songId = entry.getString("songID");
				Song song = Snippets.getSongFromID(songId, ServerURL);

				playlist.addEntry(new GlobalPlaylistEntry(index, song
						.getTitle(), votes));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		playlist.getEntries().sort(new Comparator<GlobalPlaylistEntry>() {
			@Override
			public int compare(GlobalPlaylistEntry arg0, GlobalPlaylistEntry arg1) {
				return arg1.getVoteCount() - arg0.getVoteCount();
			}
		});

		return playlist;
	}

}
