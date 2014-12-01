package de.whs.drunkenjukebox.rest.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.whs.drunkenjukebox.beans.admin.IAdminLocal;
import de.whs.drunkenjukebox.model.Song;

@Path("/admin")
@RequestScoped
public class AdminService {
	@EJB
	private IAdminLocal bean;
	
	@GET
	@Path("/songs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> getSongs() {
        return bean.getSongs();
    }
}
