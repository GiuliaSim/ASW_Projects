package asw.jms.simpleproducerthread;

import java.util.logging.Logger;

import asw.jms.simpleproducer.SimpleProducer;
import asw.util.sleep.Sleeper;


public class SimpleProducerThread extends Thread {
	private static Logger logger = Logger.getLogger("asw.jms.simplesynchconsumerythread");
	private String name;
	private SimpleProducer simpleProducer;
	private int numMsgs;
	
	public SimpleProducerThread(SimpleProducer simpleProducer, String name, int numMsgs) {
		this.simpleProducer=simpleProducer;
		this.name=name;
		this.numMsgs=numMsgs;
    }
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		 /* connessione */
        simpleProducer.connect();

    	
    	/* ricezione messaggi */
    	 /* invio di nomMsgs messaggi */
        for (int i=1; i<=numMsgs; i++) {
        	simpleProducer.sendMessage("Message #" + i + " from thread " + name);
        }
	}


	
}
