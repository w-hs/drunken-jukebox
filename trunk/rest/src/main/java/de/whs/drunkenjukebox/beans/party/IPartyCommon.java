package de.whs.drunkenjukebox.beans.party;

import java.util.Collection;

import de.whs.drunkenjukebox.model.DIValue;
import de.whs.drunkenjukebox.model.PartyPeople;
import de.whs.drunkenjukebox.model.Playlist;
import de.whs.drunkenjukebox.model.Song;
import de.whs.drunkenjukebox.model.Vote;

public interface IPartyCommon {
	Playlist getPlaylist();
	
	Song getCurrentSong();
	
	PartyPeople registerPartyPeople();
	
	Collection<Vote> getVotes(int partyPeopleId);
	
	Collection<DIValue> getDiValues(int partyPeopleId);
	
	void vote(int partyPeopleId, int songId, boolean up);
	
	void sendDi(int partyPeopleId, int di);
}
