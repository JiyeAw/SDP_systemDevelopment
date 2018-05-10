package Item;

public class NormalItem {
	private String name;
	private double cost;
	private double price;
	private int reorderPoint;
	private int reorderAmount;
	
	public NormalItem (String name, double cost, double price, int reorderPoint, int reorderAmount) {
		this.name = name;
		this.cost = cost;
		this.price = price;
		this.reorderPoint = reorderPoint;
		this.reorderAmount = reorderAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getReorderPoint() {
		return reorderPoint;
	}

	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public int getReorderAmount() {
		return reorderAmount;
	}

	public void setReorderAmount(int reorderAmount) {
		this.reorderAmount = reorderAmount;
	}
	
}
