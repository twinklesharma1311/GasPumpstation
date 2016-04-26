package domain.model;

public class ReceiptPrinter {

    public void setTotal(double amount, double quantity) {
    	System.out.println("----------------------------------------");
    	System.out.println("Thank you for using our Pump Station!");
    	System.out.println("GAS MAX");
    	System.out.println("Richardson, TX");
    	System.out.println("----------------------------------------");
    	System.out.println("Fuel:\t\t\t\t"+quantity+" L");
    	System.out.println("Price:\t\t\t\t$ "+amount);
    }
}
