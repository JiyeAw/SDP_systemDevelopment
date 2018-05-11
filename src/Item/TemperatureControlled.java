package Item;

public class TemperatureControlled extends NormalItem {

	private int temperature;
	
	public TemperatureControlled(String name, double cost, double price, int reorderPoint, int reorderAmount, int temperature) {
		super(name, cost, price, reorderPoint, reorderAmount);
		// TODO Auto-generated constructor stub
		this.temperature = temperature;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	

}
