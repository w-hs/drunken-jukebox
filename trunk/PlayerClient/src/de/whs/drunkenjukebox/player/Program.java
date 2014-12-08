package de.whs.drunkenjukebox.player;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.whs.drunkenjukebox.beans.player.IPlayerRemote;
import de.whs.drunkenjukebox.beans.player.PlayerBean;

public class Program {

	public static void main(String[] args) {
		Program p = new Program();
		p.run();
	}
	
	public void run() {
		try {
			IPlayerRemote player = doLookup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private IPlayerRemote doLookup() throws NamingException {
		final Hashtable jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		
		final Context context = new InitialContext(jndiProperties);
		
		final String appName = "";
		final String moduleName = "rest";
		final String distinctName = "";
		final String beanName = PlayerBean.class.getSimpleName();
		final String viewClassName = IPlayerRemote.class.getName();
		String lookupName = "ejb:" + appName + "/" + moduleName + "/" + 
		distinctName + "/" + beanName + "!" + viewClassName;
		
		//lookupName = "java:module/PlayerBean!de.whs.drunkenjukebox.beans.player.IPlayerRemote";
		//lookupName = "java:module/" + PlayerBean.class.getSimpleName();
		lookupName = "java:global/rest/PlayerBean!de.whs.drunkenjukebox.beans.player.IPlayerRemote";
		System.out.println(lookupName);
		//java:module/PlayerBean!de.whs.drunkenjukebox.beans.player.IPlayerRemote
		//java:global/rest/PlayerBean!de.whs.drunkenjukebox.beans.player.IPlayerRemote
		return (IPlayerRemote) context.lookup(lookupName);
	}

}
