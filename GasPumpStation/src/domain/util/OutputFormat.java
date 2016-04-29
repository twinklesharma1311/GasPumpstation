package domain.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class OutputFormat {
	public static String format(double number) {
		DecimalFormat df = new DecimalFormat("#0.00");
		
    	DecimalFormatSymbols dfs = new DecimalFormatSymbols();
    	dfs.setDecimalSeparator('.');
    	df.setDecimalFormatSymbols(dfs);
    	
    	return df.format(number);
	}
}
