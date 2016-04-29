package domain.model;

public class ReceiptPrinter {

    public void printTotal(double amount, double quantity) {
    	System.out.println("----------------------------------------");
    	System.out.println("  Thank you for using Twinkle Station!");
    	System.out.println("             Barbara Inc.");
    	System.out.println("----------------------------------------");
    	System.out.println("Transaction Number: RAM00001");
    	System.out.println("Ronaldson, TX");
    	System.out.println("----------------------------------------");
    	System.out.println("Fuel:\t\t\t\t"+quantity+" L");
    	System.out.println("Price:\t\t\t\t$ "+amount);
    }
    
}
