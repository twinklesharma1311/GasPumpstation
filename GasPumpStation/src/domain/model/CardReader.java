package domain.model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import domain.core.MainController;
import domain.util.Console;

public class CardReader {
	
	public void waitSwipe() {
		
    	System.out.println("Swipe your credit card to start: ");
    	long creditCardNo = Long.parseLong(Console.getScanner().nextLine());
    	
    	System.out.println("Type the expiration date (mm/yyyy): ");
    	String date = Console.getScanner().nextLine();
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
    	Date expDate = null;
		try {
			expDate = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	MainController.getInstance().swipeCC(creditCardNo, expDate);
    }

}
