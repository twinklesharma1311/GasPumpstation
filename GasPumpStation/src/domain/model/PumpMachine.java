package domain.model;

import ui.view.PumpDisplay;
import adapter.pump.NozzleSystem;

public class PumpMachine {

	private double currentQuantity;
    private double currentAmount;
    private GradeSelector gradeSelector;
    private FuelSelector fuelSelector;
    private SaleDevice saledevice;
    private NozzleSystem nozzleSystem;
    private PumpDisplay display;
    
	public double getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(double currentQuantity) {
		this.currentQuantity = currentQuantity;
	}
	public double getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}
	public GradeSelector getGradeSelector() {
		return gradeSelector;
	}
	public void setGradeSelector(GradeSelector gradeSelector) {
		this.gradeSelector = gradeSelector;
	}
	public SaleDevice getSaledevice() {
		return saledevice;
	}
	public void setSaledevice(SaleDevice saledevice) {
		this.saledevice = saledevice;
	}
	public NozzleSystem getNozzleSystem() {
		return nozzleSystem;
	}
	public void setNozzleSystem(NozzleSystem nozzleSystem) {
		this.nozzleSystem = nozzleSystem;
	}
	public FuelSelector getFuelSelector() {
		return fuelSelector;
	}
	public void setFuelSelector(FuelSelector fuelSelector) {
		this.fuelSelector = fuelSelector;
	}
	public PumpDisplay getDisplay() {
		return display;
	}
	public void setDisplay(PumpDisplay display) {
		this.display = display;
	}
}
