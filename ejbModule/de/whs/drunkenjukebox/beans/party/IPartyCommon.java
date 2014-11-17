package de.whs.drunkenjukebox.beans.party;

import java.util.List;

import de.whs.drunkenjukebox.model.DIValue;
import de.whs.drunkenjukebox.model.PartyPeople;
import de.whs.drunkenjukebox.model.Playlist;
import de.whs.drunkenjukebox.model.Song;
import de.whs.drunkenjukebox.model.Vote;

public interface IPartyCommon {
	Playlist getPlaylist();
	
	Song getCurrentSong();
	
	PartyPeople registerPartyPeople();
	
	List<Vote> getVotes();
	
	List<DIValue> getDiValues();
	
	void vote(int partyPeopleId, int songId);
	
	void sendDi(int partyPeopleId, int di);
}
