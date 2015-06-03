package de.whs.drunkenjukebox.server;

import java.util.Comparator;

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
		JSONArray currentSongArray = Snippets.getJsonArray(ServerURL+"curentsong");
		if(currentSongArray != null)
		{
			
			try {
				String songID = currentSongArray.getJSONObject(0).getString("songID");
				song = Snippets.getSongFromID(songID, ServerURL);
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return song;
	}

	@Override
	public PlayList getPlayList() {
		// TODO: Wirklich implementieren

		PlayList pl = new PlayList();
		JSONArray playlistArray = Snippets.getJsonArray(ServerURL+"playlist");
		if(playlistArray != null)
		{
			
			try {
				
				for(int i = 0 ; i< playlistArray.length(); i++ )
				{
					JSONObject playlistEntry = playlistArray.getJSONObject(i);
					Song song = Snippets.getSongFromID(playlistEntry.getString("songID"), ServerURL);
					PlayListEntry entry = new PlayListEntry();
					entry.setId(playlistEntry.getString("id"));
					entry.setSongID(playlistEntry.getString("songID"));
					entry.setSongName(song.getTitle());
					entry.setInterpreter(song.getInterpret());
					entry.setVoteResult(VoteResult.NOT_VOTED);
					entry.setVotes(playlistEntry.getInt("votes"));
					pl.getEntries().add(entry);
					
				}
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		pl.getEntries().sort(new Comparator<PlayListEntry>() {

			@Override
			public int compare(PlayListEntry o1, PlayListEntry o2) {
				return o1.getVotes() - o2.getVotes();
			}
		});
		
		return pl;
	}

	@Override
	public void sendDi(int value) {
		// TODO: Wirklich implementieren
		
	}

	@Override
	public void sendVote(PlayListEntry entry, Vote vote) {
		// TODO: Wirklich implementieren
		System.out.println("voteUP");
		
		if(vote == Vote.UP)
		{
			entry.setVoteResult(VoteResult.UP_VOTED);
		}
		else
		{
			entry.setVoteResult(VoteResult.DOWN_VOTED);
		}
			
		JSONObject jsonEntry = new JSONObject();
		try {
			
			jsonEntry.put("id", entry.getId());
			jsonEntry.put("songID", entry.getSongID());
			jsonEntry.put("position", 0);
			jsonEntry.put("votes",entry.getVotes());
			
			System.out.println(ServerURL+"playlist/"+entry.getId());
			System.out.println(jsonEntry.toString());
			
			Snippets.put(ServerURL+"playlist/"+entry.getId(), jsonEntry);
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
