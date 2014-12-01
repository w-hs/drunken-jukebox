package de.whs.drunkenjukebox.beans.player;

import javax.ejb.Stateful;

import de.whs.drunkenjukebox.model.SongSource;

/**
 * Session Bean implementation class PartyBean
 */
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
		// TODO Auto-generated method stub
		
	}

}
