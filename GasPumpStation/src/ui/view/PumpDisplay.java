package ui.view;

import java.text.DecimalFormat;

public class PumpDisplay {

    private String message;

    public void update(double amount, double quantity) {
    	System.out.println("Price($): "+new DecimalFormat("#.##").format(amount));
    	System.out.println("Fuel(L): "+quantity);
    	System.out.println();
    	
    }
    
    public void update(String newMessage) {
    	message = newMessage;
    	
    	System.out.println(message);
    }
}