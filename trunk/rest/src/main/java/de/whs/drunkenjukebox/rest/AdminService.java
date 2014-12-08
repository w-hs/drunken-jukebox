package de.whs.drunkenjukebox.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.whs.drunkenjukebox.beans.admin.IAdminLocal;
import de.whs.drunkenjukebox.model.Song;
import de.whs.drunkenjukebox.model.YouTubeSource;
import de.whs.drunkenjukebox.rest.model.SongDTO;

@Path("/admin")
@Stateless
public class AdminService {
	@EJB
	private IAdminLocal service;
	
	@GET
	@Path("/songs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> getSongs() {
        return service.getSongs();
    }
	
	@POST
	@Path("/songs")
    @Produces(MediaType.APPLICATION_JSON)
    public void createSong(SongDTO newSong) {
		List<Song> newSongs = new ArrayList<Song>();
		if (newSong.getYoutube() != null)
			newSong.getSong().setSource(newSong.getYoutube());
		else if (newSong.getLocalFile() != null)
			newSong.getSong().setSource(newSong.getLocalFile());
		newSongs.add(newSong.getSong());
		service.addSongs(newSongs);
    }
}
