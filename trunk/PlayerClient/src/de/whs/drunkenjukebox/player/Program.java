package de.whs.drunkenjukebox.player;

import java.util.Properties;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Program implements MessageListener {
	
	    private static final String DEFAULT_MESSAGE = "Hello, World!";
	    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	    private static final String DEFAULT_DESTINATION = "java:/jms/topic/DjTopic";
	    private static final String DEFAULT_MESSAGE_COUNT = "1";
	    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	    private static final String PROVIDER_URL = "http-remoting://localhost:8080";

	public static void main(String[] args) {
		Program p = new Program();
		p.run();
	}

	public void run() {
		try {
			startListening();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void startListening() throws Exception {
		Context ctx = getInitialContext();

		TopicConnectionFactory tConFactory = (TopicConnectionFactory) ctx
				.lookup("weblogic.jms.ConnectionFactory");

		Topic messageTopic = (Topic) ctx.lookup("MessageTopic");

		TopicConnection tCon = tConFactory.createTopicConnection();
		TopicSession session = tCon.createTopicSession(
				false, /* not a transacted session */
				Session.AUTO_ACKNOWLEDGE);

		TopicSubscriber subscriber = session.createSubscriber(messageTopic);
		subscriber.setMessageListener(this);

		tCon.start();
	}

	// private IPlayerRemote doLookup() throws NamingException {
	// final Hashtable jndiProperties = new Hashtable<>();
	// jndiProperties.put(Context.URL_PKG_PREFIXES,
	// "org.jboss.ejb.client.naming");
	//
	// final Context context = new InitialContext(jndiProperties);
	//
	// final String appName = "";
	// final String moduleName = "rest";
	// final String distinctName = "";
	// final String beanName = PlayerBean.class.getSimpleName();
	// final String viewClassName = IPlayerRemote.class.getName();
	// String lookupName = "ejb:" + appName + "/" + moduleName + "/" +
	// distinctName + "/" + beanName + "!" + viewClassName + "?stateful";
	//
	// System.out.println(lookupName);
	// return (IPlayerRemote) context.lookup(lookupName);
	// }

	private Context getInitialContext() {
		try {
            // Set up the context for the JNDI lookup
            final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
            Context context = new InitialContext(env);
            return context;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub

	}

}
