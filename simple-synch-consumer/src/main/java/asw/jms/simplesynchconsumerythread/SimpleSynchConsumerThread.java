package asw.jms.simplesynchconsumerythread;

import java.util.logging.Logger;

import asw.jms.simplesynchconsumer.SimpleSynchConsumer;

public class SimpleSynchConsumerThread extends Thread {
	private static Logger logger = Logger.getLogger("asw.jms.simplesynchconsumerythread");
	private String name;
	private SimpleSynchConsumer simpleConsumer;

	public SimpleSynchConsumerThread(SimpleSynchConsumer simpleConsumer, String name) {
		this.simpleConsumer = simpleConsumer;
		this.name = name;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		simpleConsumer.connect();
		simpleConsumer.start();
		int numMsgs = 7;
		/* ricezione messaggi */
		for (int i = 0; i < numMsgs; i++) {
			String message = simpleConsumer.receiveMessage();
			logger.info("ConsumerThread: " + name + ": Received message: " + message);
			/*
			 * se il consumatore e' stato cancellato, allora interrompe la ricezione di
			 * messaggi
			 */
			if (simpleConsumer.isCancelled()) {
				break;
			}
		}
		simpleConsumer.stop();
        simpleConsumer.disconnect();
	}
	
	
	

}
