package ui.view;

public class SaleDeviceDisplay {
	
	private String message = "Please swipe card.";

    public void update(String newMessage) {
    	message = newMessage;
    	
    	System.out.println(message);
    }
}