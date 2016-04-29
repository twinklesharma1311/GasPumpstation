package domain.util.external;

import java.util.Date;

public class ExternalCCSystem {

	public void connect() {
		//external system
	}

	public boolean authorize(long num, Date expDate, int cvv) {
		//external system
		return true;
	}

	public void disconnect() {
		//external system
	}

	public void charge(long num, Date expDate, int cvv, double amount) {
		// external system
	}

}
