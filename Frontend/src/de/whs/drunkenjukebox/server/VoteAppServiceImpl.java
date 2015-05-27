package de.whs.drunkenjukebox.server;

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

	@Override
	public void sendDi(int value) {
		// TODO: Wirklich implementieren
	}

	@Override
	public void sendVote(PlayListEntry entry, Vote vote) {
		// TODO: Wirklich implementieren
	}

}
