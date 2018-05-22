package Item;

import java.util.HashSet;
import java.util.Set;

public class Item {
	
	// Collection of all item and need to be initialize when running the code;
	private static Set<NormalItem> Items = new HashSet<NormalItem> ();
	
	//private ArrayList <String double double int int> product
	private String [] item_info;
	
//	public Item(String[] item) {
//		// TODO Auto-generated constructor stub
//		this.item_info = item;
//		
//	}
	
	
	public void  create_item (NormalItem item1) {
		
		// generic variables so that it can accept either normal or temperature controlled collection
		Items.add(item1);
	}
	
	public Set<NormalItem> getItems (){
		return Items;
	}
	
}
