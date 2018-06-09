package asw.jms.simpleafilterthread;

import java.util.logging.Logger;

import asw.jms.simplefilter.SimpleFilter;
import asw.util.sleep.Sleeper;

public class SimpleFilterThread extends Thread {
	private static Logger logger = Logger.getLogger("asw.jms.simplesynchconsumerythread");
	private String name;
	private SimpleFilter simpleFilter;
	
	public SimpleFilterThread(SimpleFilter simpleFilter, String name) {
		this.simpleFilter=simpleFilter;
		this.name=name;
		
    }
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		 /* connessione */
    	simpleFilter.connect();

    	/* filtraggio messaggi */
    	simpleFilter.filterMessages();
    	
    	/* disconnessione */
        simpleFilter.disconnect();

	}

}
