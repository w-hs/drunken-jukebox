package de.whs.drunkenjukebox.beans.party;

import java.util.Calendar;
import java.util.Collection;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.ejb3.annotation.SecurityDomain;

import de.whs.drunkenjukebox.common.Util;
import de.whs.drunkenjukebox.model.DIValue;
import de.whs.drunkenjukebox.model.Party;
import de.whs.drunkenjukebox.model.PartyPeople;
import de.whs.drunkenjukebox.model.Playlist;
import de.whs.drunkenjukebox.model.PlaylistEntry;
import de.whs.drunkenjukebox.model.Song;
import de.whs.drunkenjukebox.model.Vote;
import de.whs.drunkenjukebox.rest.roles.IRoles;

/**
 * Session Bean implementation class PartyBean
 */
@SecurityDomain("DjDomain")
@DeclareRoles({IRoles.PartyPeople})	
@RolesAllowed({IRoles.PartyPeople})
@Stateless
public class PartyBean implements IPartyRemote, IPartyLocal {
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public PartyBean() {
    }

	@Override
	public Playlist getPlaylist() {
		Party currentParty = Util.getCurrentParty(em);
		if (currentParty == null)
			throw new RuntimeException("No current party");
		return currentParty.getPlaylist();
	}

	@Override
	public Song getCurrentSong() {
		Party currentParty = Util.getCurrentParty(em);
		if (currentParty == null)
			throw new RuntimeException("No current party");
		return currentParty.getCurrentSong();
	}

	@Override
	public PartyPeople registerPartyPeople() {
		PartyPeople people = new PartyPeople();
		em.persist(people);
		return people;
	}

	@Override
	public Collection<Vote> getVotes(int partyPeopleId) {
		PartyPeople people = em.find(PartyPeople.class, partyPeopleId);
		if (people == null)
			throw new RuntimeException("No guest with ID " + partyPeopleId + " found");
		return people.getVotes();
	}

	@Override
	public Collection<DIValue> getDiValues(int partyPeopleId) {
		PartyPeople people = em.find(PartyPeople.class, partyPeopleId);
		if (people == null)
			throw new RuntimeException("No guest with ID " + partyPeopleId + " found");
		return people.getDiValues();
	}

	@Override
	public void vote(int partyPeopleId, int songId, boolean up) {
		PartyPeople people = em.find(PartyPeople.class, partyPeopleId);
		if (people == null)
			throw new RuntimeException("No guest with ID " + partyPeopleId + " found");
		Song votedSong = em.find(Song.class, songId);
		if (votedSong == null)
			throw new RuntimeException("No song with ID " + songId + " found");
		
		Party current = Util.getCurrentParty(em);
		PlaylistEntry entry = current.getPlaylist().findSong(votedSong);
		if (entry == null)
			throw new RuntimeException("Voted for song which is not in playlist");
		entry.setVoteCount(entry.getVoteCount() + (up ? 1 : -1));
		
		Vote vote = new Vote();
		vote.setTimestamp(Calendar.getInstance());
		vote.setUpOrDown(up);
		vote.setSong(votedSong);
		people.getVotes().add(vote);
	}

	@Override
	public void sendDi(int partyPeopleId, int di) {
		PartyPeople people = em.find(PartyPeople.class, partyPeopleId);
		if (people == null)
			throw new RuntimeException("No guest with ID " + partyPeopleId + " found");
		DIValue diValue = new DIValue();
		diValue.setDiValue(di);
		diValue.setTimestamp(Calendar.getInstance());
		
		people.setCurrentDI(di);
		people.getDiValues().add(diValue);
	}

}
