package de.whs.drunkenjukebox.beans.party;

import java.util.List;

import javax.ejb.Stateless;

import de.whs.drunkenjukebox.model.DIValue;
import de.whs.drunkenjukebox.model.PartyPeople;
import de.whs.drunkenjukebox.model.Playlist;
import de.whs.drunkenjukebox.model.Song;
import de.whs.drunkenjukebox.model.Vote;

/**
 * Session Bean implementation class PartyBean
 */
@Stateless
public class PartyBean implements IPartyRemote {

    /**
     * Default constructor. 
     */
    public PartyBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Playlist getPlaylist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song getCurrentSong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartyPeople registerPartyPeople() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vote> getVotes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DIValue> getDiValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vote(int partyPeopleId, int songId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendDi(int partyPeopleId, int di) {
		// TODO Auto-generated method stub
		
	}

}
