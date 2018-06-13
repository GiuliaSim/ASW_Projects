package asw.jms.simpleasynchconsumerthread;

import asw.jms.simpleasynchconsumer.SimpleAsynchConsumer;

import asw.util.sleep.Sleeper;

public class SimpleAsynchConsumerThread extends Thread {
	
	private String name;
	private SimpleAsynchConsumer asynchConsumer;
	
	public SimpleAsynchConsumerThread(SimpleAsynchConsumer asynchConsumer, String name) {
		this.asynchConsumer=asynchConsumer;
		this.name=name;
		
    }

	@Override
	public void run() {
		super.run();
		  /* connessione */
    	asynchConsumer.connect();

    	/* ricezione messaggi */
    	asynchConsumer.receiveMessages();
    	/* disconnessione */
		 asynchConsumer.disconnect();
       
	}
	
	
	
}
