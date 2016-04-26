package domain.core;

import java.util.Date;
import java.util.Scanner;

import ui.view.PumpDisplay;
import adapter.GasInventory;
import adapter.accounting.CardAuthorization;
import adapter.pump.NozzleSystem;
import adapter.pump.PumpMechanism;
import domain.model.CardReader;
import domain.model.CreditCard;
import domain.model.Diesel;
import domain.model.FuelSelector;
import domain.model.FuelType;
import domain.model.Gasoline;
import domain.model.GradeSelector;
import domain.model.ReceiptPrinter;
import domain.model.Sale;
import domain.util.Console;
import domain.util.Grade;

public class MainController {
	
	private CardAuthorization cardServices;
	private FuelSelector fuelSelector;
	private GradeSelector gradeSelector;
	
	private GasInventory gasInventory;
	private PumpMechanism pumpMechanism;
	private NozzleSystem nozzleSystem;
	
	private PumpDisplay display;
	private ReceiptPrinter printer;
	
	private Sale currentSale;
	private double currentPrice;
	
	private int qty;
	private double amt;
	
	protected MainController() {
		cardServices = new CardAuthorization();
		fuelSelector = new FuelSelector();
		gradeSelector = new GradeSelector();
		
		gasInventory = new GasInventory();
		pumpMechanism = new PumpMechanism();
		nozzleSystem = new NozzleSystem();
		
		display = new PumpDisplay();
		printer = new ReceiptPrinter();
	}
	
	private static MainController instance = null;

	public static MainController getInstance() {
      if(instance == null) {
         instance = new MainController();
      }
      return instance;
	}
	
	public static void main(String[] args) {
		CardReader reader = new CardReader();
		reader.waitSwipe();
	}
	
	public void swipeCC(int creditCardNo, Date expDate) {
		CreditCard creditCard = new CreditCard(creditCardNo, expDate);
		
		boolean isAuthorized = cardServices.authorize(creditCard);
		
		if(isAuthorized) {
			currentSale = new Sale();
			currentSale.setCreditCard(creditCard);
			
			selectFuel();
		}
	}

	private void selectFuel() {
		FuelType selectedFuel = fuelSelector.selectFuel();
		
		if(selectedFuel instanceof Gasoline) {
			gradeSelector.selectGrade();
			
		} else {
			Diesel gas = new Diesel();
			currentPrice = gasInventory.getDetails(gas);
			
			pumpMechanism.arm();
			
			waitTrigger();
		}
	}

	public void selectGrade(String gradeId) {
		Grade selectedGrade = null;
		
		switch (gradeId) {
		case "87": selectedGrade = Grade.EIGHTYSEVEN; break;
		case "89": selectedGrade = Grade.EIGHTYNINE; break;
		case "93": selectedGrade = Grade.NINETYTHREE; break;
		default:
			break;
		}
		
		Gasoline gas = new Gasoline(selectedGrade);
		
		currentPrice = gasInventory.getDetails(gas);
		
		pumpMechanism.arm();
		
		waitTrigger();
	}

	private void waitTrigger() {
		System.out.println("Enter desired quantity (0 - unlimited): ");
    	qty = Console.getScanner().nextInt();
    	
    	nozzleSystem.engageTrigger();

    	for (int quantity = 1; quantity <= qty; quantity++) {
    		
    		amt = quantity*currentPrice;
    		currentSale.setAmount(amt);
    		
    		pumpMechanism.getQuantity();
    		
    		display.update(amt, quantity);
    		
    		//Simulate 1/10 second
    		try {
    		    Thread.sleep(100);
    		} catch(InterruptedException ex) {
    		    Thread.currentThread().interrupt();
    		}
		}
    	
    	returnNozzle();
	}

	private void returnNozzle() {
		pumpMechanism.disarm();
		
		double amt = currentSale.getAmount();
		CreditCard cc = currentSale.getCreditCard();
		
		cardServices.charge(cc, amt);
		
		endSale();
	}

	private void endSale() {
		display.update(amt, qty);
		
		gasInventory.update(qty);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Would you like your receipt (y/n)?  ");
    	String print = scan.nextLine();
        
    	if("y".equalsIgnoreCase(print)) {
    		printer.setTotal(amt, qty);
    	}
    	
    	scan.close();
	}

}
