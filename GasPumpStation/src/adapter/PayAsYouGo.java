package adapter;

public class PayAsYouGo implements FuelStrategy{

	@Override
	public double getFuelPrice(double price) {
		return price;
	}
}
