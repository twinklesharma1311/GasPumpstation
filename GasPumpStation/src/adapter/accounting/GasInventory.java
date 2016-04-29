package adapter.accounting;

import adapter.DoubleDiesel;
import adapter.FuelStrategy;
import adapter.PayAsYouGo;
import domain.model.FuelType;
import domain.model.Gasoline;
import domain.util.external.PriceSystem;

public class GasInventory {
	
	private double availableGas = Double.MAX_VALUE;

	private FuelStrategy fuelStrategy;

	private PriceSystem priceSystem = new PriceSystem();
	
    public double getPriceDetails(FuelType fuel) {
    	double price = 0.0;
    	
    	if(fuel instanceof Gasoline) {
    		setStrategy(new PayAsYouGo());
    		price = priceSystem.getCurrentGasolinePrice(((Gasoline) fuel).getGrade().getQuality());
    	} else {
    		setStrategy(new DoubleDiesel());
    		price = priceSystem.getCurrentDieselPrice();
    	}
    	
    	return fuelStrategy.getFuelPrice(price);
    }

    public void update(double quantity) {
    	availableGas = availableGas - quantity;
    }
    
    public void setStrategy(FuelStrategy strategy) {
		this.fuelStrategy = strategy;
	}
}
