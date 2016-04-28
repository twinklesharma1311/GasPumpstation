package adapter.pump;

import domain.util.external.ExternalPumpTrigger;


public class PumpMechanism {
	
	ExternalPumpTrigger pumpTrigger = new ExternalPumpTrigger();

    public void arm() {
    	pumpTrigger.arm();
    }
    
    public void disarm() {
    	pumpTrigger.disarm();
    }

	public int getQuantity() {
		return pumpTrigger.getRunningTotal();
	}
}