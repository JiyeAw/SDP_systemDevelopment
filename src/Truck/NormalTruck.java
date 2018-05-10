package Truck;

public class NormalTruck implements Truck{
	
	private int quantity;
	
	public NormalTruck (int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return 1000;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		double calculation = 750 + (0.25*quantity);
		
		return calculation;
	}
	
}
