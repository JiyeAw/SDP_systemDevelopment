package Stock;

import java.util.HashSet;
import java.util.Set;

public class Inventory {
	// Collection of stock in set
	
	private static Set<Stock> inventory = new HashSet <Stock> ();
	
	
	public void setInventory (Stock stock) {
		// check and change the quantity of the item
		
		inventory.add(stock);
	}
	
	public Set<Stock> getInventory (){
		return inventory;
	}
}
