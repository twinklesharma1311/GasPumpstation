package domain.core;

import java.util.Date;
import java.util.Scanner;

import ui.view.PumpDisplay;
import ui.view.SaleDeviceDisplay;
import adapter.accounting.AccountingSystem;
import adapter.accounting.CardAuthorization;
import adapter.accounting.GasInventory;
import adapter.pump.NozzleSystem;
import adapter.pump.PumpMechanism;
import domain.model.CardReader;
import domain.model.CreditCard;
import domain.model.Diesel;
import domain.model.FuelSelector;
import domain.model.FuelType;
import domain.model.Gasoline;
import domain.model.GradeSelector;
import domain.model.PumpMachine;
import domain.model.ReceiptPrinter;
import domain.model.Sale;
import domain.model.SaleDevice;
import domain.util.Console;
import domain.util.Grade;

public class MainController {
	
	public static void main(String[] args) {
		MainController controller = init();
		
		controller.getPumpMachine().getSaledevice().getReader().waitSwipe();
	}
	
	private static MainController instance = null;

	public static MainController getInstance() {
      if(instance == null) {
         instance = init();
      }
      return instance;
	}
	
	private AccountingSystem accSystem = new AccountingSystem();
	private CardAuthorization cardServices = new CardAuthorization();
	private GasInventory gasInventory = new GasInventory();
	private PumpMechanism pumpMechanism = new PumpMechanism();
	private PumpMachine pumpMachine = new PumpMachine();
	
	private Sale currentSale;
	private double currentPrice;
	
	private int qty;
	private double amt;
	
	public MainController(AccountingSystem accSystem,
			CardAuthorization cardAuthorization, GasInventory gasInventory,
			PumpMechanism pumpMechanism, PumpMachine pumpMachine) {
		this.accSystem = accSystem;
		this.cardServices = cardAuthorization;
		this.gasInventory = gasInventory;
		this.pumpMechanism = pumpMechanism;
		this.pumpMachine = pumpMachine;
	}

	public void swipeCC(long creditCardNo, Date expDate) {
		CreditCard creditCard = new CreditCard(creditCardNo, expDate);
		
		boolean isAuthorized = cardServices.authorize(creditCard);
		
		if(isAuthorized) {
			currentSale = new Sale();
			currentSale.setCreditCard(creditCard);
			
			selectFuel();
		}
	}

	private void selectFuel() {
		FuelType selectedFuel = pumpMachine.getFuelSelector().selectFuel();
		
		if(selectedFuel instanceof Gasoline) {
			pumpMachine.getGradeSelector().selectGrade();
			
		} else {
			Diesel gas = new Diesel();
			currentPrice = gasInventory.getPriceDetails(gas);
			
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
		
		currentPrice = gasInventory.getPriceDetails(gas);
		
		pumpMechanism.arm();
		
		waitTrigger();
	}

	private void waitTrigger() {
		pumpMachine.getDisplay().update("Enter desired quantity (L): ");
    	qty = Console.getScanner().nextInt();
    	
    	pumpMachine.getNozzleSystem().engageTrigger();

    	for (int quantity = 1; quantity <= qty; quantity++) {
    		
    		amt = quantity*currentPrice;
    		currentSale.setAmount(amt);
    		
    		pumpMechanism.getQuantity();
    		
    		pumpMachine.getDisplay().update(amt, quantity);
    		
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
		pumpMachine.getDisplay().update(amt, qty);
		
		gasInventory.update(qty);
		
		Scanner scan = new Scanner(System.in);
		
		pumpMachine.getDisplay().update("Would you like your receipt (y/n)?  ");
    	String print = scan.nextLine();
        
    	if("y".equalsIgnoreCase(print)) {
    		pumpMachine.getSaledevice().getPrinter().printTotal(amt, qty);
    	}
    	
    	scan.close();
	}
	
	public AccountingSystem getAccSystem() {
		return accSystem;
	}

	public void setAccSystem(AccountingSystem accSystem) {
		this.accSystem = accSystem;
	}

	public CardAuthorization getCardAuthorization() {
		return cardServices;
	}

	public void setCardAuthorization(CardAuthorization cardAuthorization) {
		this.cardServices = cardAuthorization;
	}

	public GasInventory getGasInventory() {
		return gasInventory;
	}

	public void setGasInventory(GasInventory gasInventory) {
		this.gasInventory = gasInventory;
	}

	public PumpMechanism getPumpMechanism() {
		return pumpMechanism;
	}

	public void setPumpMechanism(PumpMechanism pumpMechanism) {
		this.pumpMechanism = pumpMechanism;
	}

	public PumpMachine getPumpMachine() {
		return pumpMachine;
	}

	public void setPumpMachine(PumpMachine pumpMachine) {
		this.pumpMachine = pumpMachine;
	}

	private static MainController init() {
		CardReader reader = new CardReader();
		SaleDeviceDisplay saleDisplay = new SaleDeviceDisplay();
		ReceiptPrinter printer = new ReceiptPrinter();
		
		SaleDevice saleDevice = new SaleDevice();
		saleDevice.setDisplay(saleDisplay);
		saleDevice.setPrinter(printer);
		saleDevice.setReader(reader);
		
		FuelSelector fuelSelector = new FuelSelector();
		GradeSelector gradeSelector = new GradeSelector();
		NozzleSystem nozzleSystem = new NozzleSystem();
		PumpDisplay pumpDisplay = new PumpDisplay();
		
		PumpMachine pumpMachine = new PumpMachine();
		pumpMachine.setSaledevice(saleDevice);
		pumpMachine.setFuelSelector(fuelSelector);
		pumpMachine.setGradeSelector(gradeSelector);
		pumpMachine.setNozzleSystem(nozzleSystem);
		pumpMachine.setDisplay(pumpDisplay);
		
		AccountingSystem accSystem = new AccountingSystem();
		CardAuthorization cardAuthorization = new CardAuthorization();
		GasInventory gasInventory = new GasInventory();
		PumpMechanism pumpMechanism = new PumpMechanism();
		
		return new MainController(accSystem, cardAuthorization, gasInventory, pumpMechanism, pumpMachine);
	}

}
