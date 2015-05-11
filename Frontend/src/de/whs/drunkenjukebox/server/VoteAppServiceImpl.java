package de.whs.drunkenjukebox.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.whs.drunkenjukebox.model.PlayList;
import de.whs.drunkenjukebox.model.PlayListEntry;
import de.whs.drunkenjukebox.model.VoteResult;
import de.whs.drunkenjukebox.shared.Song;
import de.whs.drunkenjukebox.shared.Vote;
import de.whs.drunkenjukebox.shared.VoteAppService;

public class VoteAppServiceImpl extends RemoteServiceServlet implements VoteAppService {

	private static final long serialVersionUID = 88682179774253373L;

	@Override
	public Song getCurrentSong() {
		// TODO: Wirklich implementieren
		
		List<String> genres = new ArrayList<String>();
		genres.add("Classic");
		genres.add("Pop");
		
		Song song = new Song();
		song.setInterpret("Wham");
		song.setTitle("Last Christmas");
		song.setGenres(genres);
		song.setSongSource("https://www.youtube.com/");
		song.setDurationInSecs(186);
	
		return song;
	}

	@Override
	public PlayList getPlayList() {
		// TODO: Wirklich implementieren
		
		PlayList pl = new PlayList();
		PlayListEntry entry = new PlayListEntry();
		entry.setSongName("Last Christmas");
		entry.setInterpreter("WHAMMMMMM");
		entry.setVoteResult(VoteResult.DOWN_VOTED);
		pl.getEntries().add(entry);
		pl.getEntries().add(entry);
		pl.getEntries().add(entry);
		pl.getEntries().add(entry);
		pl.getEntries().add(entry);
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
