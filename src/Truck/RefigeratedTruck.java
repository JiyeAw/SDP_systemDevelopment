package Truck;

public class RefigeratedTruck implements Truck {

	private int temperature;
	
	public RefigeratedTruck (int temperature) {
		this.temperature = temperature;
	}
	
	
	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return 800;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		double calculation = 900 + (200*(Math.pow(0.7, temperature/5)));
		
		return calculation;
	}

}
 