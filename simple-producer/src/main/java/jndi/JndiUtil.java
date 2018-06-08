package jndi;


import javax.naming.InitialContext;
import javax.naming.NamingException;


import java.util.logging.Logger;

/**
 * JndiUtil
 * Una semplice classe di utilita' per JNDI. 
 *
 * @author Luca Cabibbo
 */
public class JndiUtil {

	/* logger */
	private Logger logger = Logger.getLogger("asw.jndi");

	/* JndiUtil e' un singleton */ 
	private static JndiUtil instance; 
	
	private JndiUtil() {
		
	}
	
	public static synchronized JndiUtil getInstance() {
		if (instance==null) {
			instance = new JndiUtil(); 
		}
		return instance; 
	}
	
	private InitialContext context = null; 
	
	private synchronized InitialContext getContext() {
		if (context==null) {
			try {
				logger.info("Creazione InitialContext in corso");
				context = new InitialContext();
				logger.info("Creazione InitialContext riuscita");
				/*Properties props = new Properties();
				props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
				props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
				InitialContext context = new InitialContext(props);*/
			} catch (NamingException e) {
				logger.info("Creazione InitialContext fallita");
				e.printStackTrace();
				// System.exit(1);
			}
		}
		return context; 
	}
	
    /** Effettua il lookup di una risorsa JMS. */
    public Object jndiLookup(String resourceName) {
    	Object resource = null; 
		try {
			logger.info("Lookup della risorsa JNDI: " + resourceName);
    	    /* effettua il lookup della risorsa cercata */
    	    resource = getContext().lookup(resourceName);
    	    
        	logger.fine("Lookup di " + resourceName + " riuscito");
    	} catch (NamingException e) {
        	logger.info("Lookup di " + resourceName + " fallito");
        	e.printStackTrace();
        	// System.exit(1);
    	}
		return resource; 
    }		

}