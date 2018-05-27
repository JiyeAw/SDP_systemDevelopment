package Stock;

import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

import Item.NormalItem;
import Item.TemperatureControlled;

public class Purchase {
	
	// buying
	
	private Set<Stock> N_Item = new HashSet<Stock> ();
	private Set<Stock> TC_Item = new HashSet<Stock> ();
	
	public void buy (/*get collection */ Set<NormalItem> items, Set<Stock> stocks) {
		// export a csv file 
		
		
		
		//create 2 collection
		for (NormalItem thisItem: items) {
			//System.out.println(gaga.getItem());
			for (Stock thisStock : stocks) {
			
				if (thisItem.getName() == thisStock.getItem() && thisStock.getQuantity() < thisItem.getReorderPoint()) {
					
					Stock orderItem = new Stock (thisItem.getName(), thisItem.getReorderAmount());
					
					if (thisItem instanceof TemperatureControlled ) {
						// send to tC item collection 
//						TemperatureControlled tempname = (TemperatureControlled) thisItem;
//						System.out.println("this is a temperature contorlled item"+tempname.getTemperature() );
							
						// Item Store into collection
						TC_Item.add(orderItem);
							
					}else {
						// Item Store into collection 
						N_Item.add(orderItem);
					}
					System.out.println(thisItem.getName() +","+ thisItem.getReorderAmount());
					
				}
			}
			
		}
		
		// Create CSV File 
		exportFile ();
		
	}
	
	public void exportFile () {
		try {
			
			// create file on location
			String currentUsersHomeDir = System.getProperty("user.home");
			FileWriter writeFile = new FileWriter (currentUsersHomeDir+"\\manifest.csv");
			
			writeFile.append(">Refgirated \n");
			for (Stock temp_item : TC_Item) {
				writeFile.append(temp_item.getItem() + "," + temp_item.getQuantity() + "\n");
			}
			writeFile.append(">Ordinary \n");
			for (Stock temp_item : N_Item) {
				writeFile.append(temp_item.getItem() + "," + temp_item.getQuantity() + "\n");
			}
			
			writeFile.flush();
			writeFile.close();
			
		}catch (Exception e) {
			System.out.println (e.getMessage());
		}
	}
	
	
	
	// update inventory
	public void cal () {
		
	}
	
	
	
}
