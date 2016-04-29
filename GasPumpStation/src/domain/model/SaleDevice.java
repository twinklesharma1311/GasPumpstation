package domain.model;

import ui.view.SaleDeviceDisplay;

public class SaleDevice {

    private ReceiptPrinter printer;
    private CardReader reader;
    private SaleDeviceDisplay display;
    
	public SaleDevice() {
		CardReader reader = new CardReader();
		SaleDeviceDisplay saleDisplay = new SaleDeviceDisplay();
		ReceiptPrinter printer = new ReceiptPrinter();
		
		setDisplay(saleDisplay);
		setPrinter(printer);
		setReader(reader);
	}
	
	public ReceiptPrinter getPrinter() {
		return printer;
	}
	public void setPrinter(ReceiptPrinter printer) {
		this.printer = printer;
	}
	public CardReader getReader() {
		return reader;
	}
	public void setReader(CardReader reader) {
		this.reader = reader;
	}
	public SaleDeviceDisplay getDisplay() {
		return display;
	}
	public void setDisplay(SaleDeviceDisplay display) {
		this.display = display;
	}
}