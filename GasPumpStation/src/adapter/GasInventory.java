package adapter;

import domain.model.FuelType;
import domain.model.Gasoline;

public class GasInventory {
	
	public static final double GASOLINE_REGULAR = 1.75;
	public static final double GASOLINE_MIDGRADE = 1.89;
	public static final double GASOLINE_PREMIUM = 1.98;
	public static final double DIESEL = 1.71;

    double availableGas = Double.MAX_VALUE;

    public double getDetails(FuelType fuel) {
    	double priceDetails = 0.0;
    	
    	if(fuel instanceof Gasoline) {
    		switch (((Gasoline)fuel).getGrade()) {
    		case EIGHTYSEVEN: priceDetails = GASOLINE_REGULAR; break;
    		case EIGHTYNINE: priceDetails = GASOLINE_MIDGRADE; break;
    		case NINETYTHREE: priceDetails = GASOLINE_PREMIUM; break;
    		default:
    			break;
    		}
    	} else {
    		priceDetails = DIESEL;
    	}
    	
    	return priceDetails;
    }

    public void update(double quantity) {
    	availableGas = availableGas - quantity;
    }
}
