package Process;

import java.util.Set;

import Item.Item;
import Item.NormalItem;
import Item.TemperatureControlled;

public class DataProcess {
	
	private String name;
	private double cost;
	private double price;
	private int re_point;
	private int re_amount;
	private int temp;
	
	public void processing (Set<String[]> to_be_process) {
		
		Item allItem = new Item ();
		
		for(String[] stock : to_be_process){
			   name = stock[0];
			   cost = Double.parseDouble(stock[1]);
			   price = Double.parseDouble(stock[2]);
			   re_point = Integer.parseUnsignedInt(stock[3]);
			   re_amount = Integer.parseUnsignedInt(stock[4]);
			   System.out.print (stock[0]);
			   System.out.print (stock[1]);
			   System.out.print (stock[2]);
			   System.out.print (stock[3]);
			   
			   if (stock.length > 5) {
				   System.out.print (stock[4]);
				   System.out.println (stock[5]);
				   temp = Integer.parseInt(stock[5]);
				   TemperatureControlled itme = new TemperatureControlled (name, cost, price, re_point, re_amount, temp);
				   allItem.create_item(itme);
			   }else {
				   System.out.println (stock[4]);
				   NormalItem iteme = new NormalItem (name, cost, price, re_point, re_amount);
				   allItem.create_item(iteme);
			   }
		}
	}
}
