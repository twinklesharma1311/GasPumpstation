package ui.view;

public class SaleDeviceDisplay {
	String message = "Please swipe card.";

    public void update(String newMessage) {
    	message = newMessage;
    	
    	System.out.println(message);
    }
}