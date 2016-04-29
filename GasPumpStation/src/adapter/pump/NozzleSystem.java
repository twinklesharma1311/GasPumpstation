package adapter.pump;

import domain.util.external.ExternalNozzleTrigger;

public class NozzleSystem {
	
	private ExternalNozzleTrigger nozzleTrigger = new ExternalNozzleTrigger();
	
    public void returnNozzle() {
    	boolean active = nozzleTrigger.getState();
    	
    	if(active) {
    		nozzleTrigger.deactivate();
    	}
    	
    	nozzleTrigger.reset();
    }

    public void engageTrigger() {
    	nozzleTrigger.activate();
    }

    public void disengageTrigger() {
    	nozzleTrigger.deactivate();
    }
}
