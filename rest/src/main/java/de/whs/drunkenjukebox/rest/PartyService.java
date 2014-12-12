package de.whs.drunkenjukebox.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.whs.drunkenjukebox.beans.party.IPartyLocal;
import de.whs.drunkenjukebox.model.DIValue;
import de.whs.drunkenjukebox.model.PartyPeople;
import de.whs.drunkenjukebox.model.Playlist;
import de.whs.drunkenjukebox.model.Song;
import de.whs.drunkenjukebox.model.Vote;
import de.whs.drunkenjukebox.rest.roles.IRoles;

@DeclareRoles({IRoles.PartyPeople})
@RolesAllowed({IRoles.PartyPeople})
@Path("/party")
@Stateless
public class PartyService {
	@EJB
	private IPartyLocal service;
	
	@GET
	@Path("/playlist")
	@Produces(MediaType.APPLICATION_JSON)
	public Playlist getPlaylist() {
		return service.getPlaylist();
	}
	
	@GET
	@Path("/currentSong")
	@Produces(MediaType.APPLICATION_JSON)
	public Song getCurrentSong() {
		return service.getCurrentSong();
	}
	
	@GET
	@Path("/diValues")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DIValue> getDiValues(int partyPeopleId) {
		return new ArrayList<DIValue>(service.getDiValues(partyPeopleId));
	}
	
	@GET
	@Path("/votes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vote> getVotes(int partyPeopleId) {
		return new ArrayList<Vote>(service.getVotes(partyPeopleId));
	}
	
	@POST
	@Path("/peoples")
	public PartyPeople registerPartyPeople() {
		return service.registerPartyPeople();
	}
	
	@POST
	@Path("/party/songs/{songId}/votes/{up}/")
	public void vote(@PathParam("songId") int songId, @PathParam("up") boolean up, int partyPeopleId) {
		service.vote(partyPeopleId, songId, up);
	}
	
	@POST
	@Path("/peoples/{partyPeopleId}/")
	public void sendDi(@PathParam("partyPeopleId") int partyPeopleId, int di) {
		service.sendDi(partyPeopleId, di);
	}	
}
