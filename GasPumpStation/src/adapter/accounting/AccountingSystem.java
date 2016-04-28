package adapter.accounting;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import domain.model.Sale;
import domain.util.external.LoggingSystem;

public class AccountingSystem {

	private LoggingSystem loggingSystem = new LoggingSystem();
	
    public List<Sale> searchSale(Date date) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	
    	return loggingSystem.searchSale(calendar);
    }
}
