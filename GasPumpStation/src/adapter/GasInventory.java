package adapter;

import domain.model.FuelType;
import domain.model.Gasoline;
import domain.util.external.PriceSystem;

public class GasInventory {
	
	PriceSystem priceSystem = new PriceSystem();
	
    double availableGas = Double.MAX_VALUE;

    public double getDetails(FuelType fuel) {
    	double priceDetails = 0.0;
    	
    	if(fuel instanceof Gasoline) {
    		priceDetails = priceSystem.getCurrentGasolineValue(((Gasoline) fuel).getGrade().getQuality());
    	} else {
    		priceDetails = priceSystem.getCurrentDieselValue();
    	}
    	
    	return priceDetails;
    }

    public void update(double quantity) {
    	availableGas = availableGas - quantity;
    }
}
