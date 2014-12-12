package de.whs.drunkenjukebox.beans.player;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;

import org.jboss.ejb3.annotation.SecurityDomain;

import de.whs.drunkenjukebox.model.SongSource;
import de.whs.drunkenjukebox.rest.roles.IRoles;


/**
 * Session Bean implementation class PartyBean
 */
@SecurityDomain("DjDomain")
@DeclareRoles({IRoles.Player})	
@RolesAllowed({IRoles.Player})
@Stateful
public class PlayerBean implements IPlayerRemote {

    /**
     * Default constructor. 
     */
    public PlayerBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void play(SongSource songSource) {
		System.out.println("Java ist klasse :-)!");		
	}

}
