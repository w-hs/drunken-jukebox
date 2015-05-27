package de.whs.drunkenjukebox.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.whs.drunkenjukebox.shared.PlayList;
import de.whs.drunkenjukebox.shared.PlayListEntry;
import de.whs.drunkenjukebox.shared.Song;
import de.whs.drunkenjukebox.shared.Vote;
import de.whs.drunkenjukebox.shared.VoteAppService;
import de.whs.drunkenjukebox.shared.VoteResult;

public class VoteAppServiceImpl extends RemoteServiceServlet implements
		VoteAppService {

	private static final long serialVersionUID = 88682179774253373L;
	private static final String ServerURL = "http://localhost:2403/";
	
	@Override
	public Song getCurrentSong() {
		// TODO: Wirklich implementieren
		Song song = new Song(); 
		JSONArray currentSongArray = getJsonArray(ServerURL+"curentsong");
		if(currentSongArray != null)
		{
			
			try {
				String songID = currentSongArray.getJSONObject(0).getString("songID");
				song = getSongFromID(songID);
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return song;
	}

	private JSONObject getJsonObject(String url) {
		try {
			@SuppressWarnings({ "deprecation", "resource" })
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			String JsonString = "";
			while ((line = rd.readLine()) != null) {
				//System.out.println(line);
				JsonString+=line;
			}
			
			return new JSONObject(JsonString);
			
			
		} catch (Exception e) {
			return null;
		}
	}
	
	private JSONArray getJsonArray(String url) {
		try {
			@SuppressWarnings({ "deprecation", "resource" })
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			String line = "";
			String JsonString = "";
			while ((line = rd.readLine()) != null) {
				//System.out.println(line);
				JsonString+=line;
			}
			
			return new JSONArray(JsonString);
			
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public PlayList getPlayList() {
		// TODO: Wirklich implementieren

		PlayList pl = new PlayList();
		JSONArray playlistArray = getJsonArray(ServerURL+"playlist");
		if(playlistArray != null)
		{
			
			try {
				
				for(int i = 0 ; i< playlistArray.length(); i++ )
				{
					JSONObject playlistEntry = playlistArray.getJSONObject(i);
					Song song = getSongFromID(playlistEntry.getString("songID"));
					PlayListEntry entry = new PlayListEntry();
					entry.setSongName(song.getTitle());
					entry.setInterpreter(song.getInterpret());
					entry.setVoteResult(VoteResult.NOT_VOTED);
					pl.getEntries().add(entry);
					
				}
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return pl;
	}

	private Song getSongFromID(String songID) {
		Song song = new Song();
		
		JSONObject currentSong = getJsonObject(ServerURL+"songs/"+songID);
		
		
		try {
			song.setInterpret(currentSong.getString("artist"));
			song.setTitle(currentSong.getString("title"));
			song.setDurationInSecs(Integer.parseInt(currentSong.getString("length")));
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return song;
	}

	@Override
	public void sendDi(int value) {
		// TODO: Wirklich implementieren
	}

	@Override
	public void sendVote(PlayListEntry entry, Vote vote) {
		// TODO: Wirklich implementieren
	}

}
