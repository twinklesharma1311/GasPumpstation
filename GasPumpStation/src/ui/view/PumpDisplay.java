package ui.view;

import domain.util.OutputFormat;

public class PumpDisplay {

    private String message;

    public void update(double amount, double quantity) {
    	System.out.println("Price($): "+ OutputFormat.format(amount));
    	System.out.println("Fuel(L): "+quantity);
    	System.out.println();
    	
    }
    
    public void update(String newMessage) {
    	message = newMessage;
    	
    	System.out.println(message);
    }
}