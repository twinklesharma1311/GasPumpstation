package domain.model;

import domain.util.Console;

public class FuelSelector {

    FuelType selectedFuel;

	public FuelType selectFuel() {
		System.out.println("Select the fuel type - (1)Gasoline (2)Diesel:  ");
    	String fuelType = Console.getScanner().nextLine();
    	
    	if("1".equals(fuelType)) {
    		selectedFuel = new Gasoline();
    	} else if ("2".equals(fuelType)) {
    		selectedFuel = new Diesel();
    	}
    	
		return selectedFuel;
	}


}
