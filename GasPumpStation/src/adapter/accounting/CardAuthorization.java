package adapter.accounting;

import domain.model.CreditCard;
import domain.util.external.ExternalCCSystem;

public class CardAuthorization {
	
	private ExternalCCSystem externalCCAuth = new ExternalCCSystem();

    public boolean authorize(CreditCard cc) {
    	boolean authorized = false;
    	externalCCAuth.connect();
    	
    	authorized = externalCCAuth.authorize(cc.getNum(), cc.getExpDate(), cc.getCvv());
    	
    	externalCCAuth.disconnect();
        return authorized;
    }
    
    public void charge(CreditCard cc, double amount) {
    	externalCCAuth.connect();
    	
    	externalCCAuth.charge(cc.getNum(), cc.getExpDate(), cc.getCvv(), amount);
    	
    	externalCCAuth.disconnect();
    }
}
