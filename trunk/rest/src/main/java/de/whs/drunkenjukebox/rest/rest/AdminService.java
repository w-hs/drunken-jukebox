package de.whs.drunkenjukebox.rest.rest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.whs.drunkenjukebox.beans.admin.IAdminLocal;
import de.whs.drunkenjukebox.model.Song;

@Path("/admin")
@Stateless
public class AdminService {
	@EJB
	private IAdminLocal bean;
	
	private Logger logger = Logger.getLogger(AdminService.class.getName());
	
	@GET
	@Path("/songs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Song> getSongs() {
		logger.log(Level.INFO, "bean: " + bean);
        return bean.getSongs();
    }
}
