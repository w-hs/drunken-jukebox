package de.whs.drunkenjukebox.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.whs.drunkenjukebox.beans.admin.IAdminLocal;
import de.whs.drunkenjukebox.model.LocalFileSource;
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
    public List<SongDTO> getSongs() {
		List<SongDTO> songs = new ArrayList<SongDTO>();
        for (Song song : service.getSongs())
        {
        	SongDTO dto = new SongDTO();
        	dto.setSong(song);
        	if (song.getSource() instanceof YouTubeSource)
        		dto.setYoutube((YouTubeSource)song.getSource());
        	else if (song.getSource() instanceof LocalFileSource)
        		dto.setLocalFile((LocalFileSource)song.getSource());
        	songs.add(dto);
        }
        return songs;
    }
	
	@POST
	@Path("/songs")
    public void createSong(SongDTO newSong) {
		List<Song> newSongs = new ArrayList<Song>();
		if (newSong.getYoutube() != null)
			newSong.getSong().setSource(newSong.getYoutube());
		else if (newSong.getLocalFile() != null)
			newSong.getSong().setSource(newSong.getLocalFile());
		newSongs.add(newSong.getSong());
		service.addSongs(newSongs);
    }
	
	@PUT
	@Path("/songs/{id}")
    public void updateSong(@PathParam("id") int id, SongDTO updatedDTO) {
		Song updatedSong = updatedDTO.getSong();
		updatedSong.setId(id);
		if (updatedDTO.getYoutube() != null)
			updatedSong.setSource(updatedDTO.getYoutube());
		else if (updatedDTO.getLocalFile() != null)
			updatedSong.setSource(updatedDTO.getLocalFile());
		service.updateSong(updatedSong);
    }
	
	@DELETE
	@Path("/songs/{id}")
    public void deleteSong(@PathParam("id") int id) {
		Song songToDelete = new Song();
		songToDelete.setId(id);
		service.deleteSong(songToDelete);
    }
}
