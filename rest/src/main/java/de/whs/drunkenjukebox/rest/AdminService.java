package de.whs.drunkenjukebox.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.whs.drunkenjukebox.beans.admin.IAdminLocal;
import de.whs.drunkenjukebox.model.Song;

@Path("/admin")
@Stateless
public class AdminService {
	@EJB
	private IAdminLocal service;
	
	private Logger logger = Logger.getLogger(AdminService.class.getName());
	
	@GET
	@Path("/songs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> getSongs() {
        return service.getSongs();
    }
	
	@POST
	@Path("/songs")
    @Produces(MediaType.APPLICATION_JSON)
    public void createSong(Song newSong) {
		List<Song> newSongs = new ArrayList<Song>();
		newSongs.add(newSong);
		service.addSongs(newSongs);
    }
}
