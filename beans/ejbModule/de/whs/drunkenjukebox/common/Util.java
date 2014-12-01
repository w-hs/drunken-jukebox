package de.whs.drunkenjukebox.common;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import de.whs.drunkenjukebox.model.Party;

public final class Util {
	public static Party getCurrentParty(final EntityManager em) {
    	Query q = em.createQuery("from Party p where p.endTime is null");
    	List<?> resultList = q.getResultList();
    	
    	int size = resultList.size();    	
    	if (size == 0)
    		return null;    	
    	if (size == 1)
    		return (Party)resultList.get(0);
    	
    	throw new RuntimeException("Internal Server Error. More than one party!");
    }
}
