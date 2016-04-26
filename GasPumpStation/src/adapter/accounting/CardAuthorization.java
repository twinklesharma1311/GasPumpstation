package adapter.accounting;

import domain.model.CreditCard;

public class CardAuthorization {

    public boolean authorize(CreditCard cc) {
    	//connect to authorization external system
        return true;
    }
    
    public void charge(CreditCard cc, double amount) {
    	//charge the person!
    }
}
