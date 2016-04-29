package adapter;

public class DoubleDiesel implements FuelStrategy{

	@Override
	public double getFuelPrice(double price) {
		return price*0.5;
	}
}
