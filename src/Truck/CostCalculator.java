package Truck;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import Item.NormalItem;
import Item.TemperatureControlled;
import Stock.Stock;

public class CostCalculator {
	
	private int Ordinary_Item;
	private int Refgrited_Item;
	
	private Set<NormalItem> itemCollection = new HashSet<NormalItem> ();
	private Set<TemperatureControlled> RefItem = new HashSet<TemperatureControlled> ();
	private Set<Stock> quantityCollection = new HashSet<Stock> ();
	
	private ArrayList<Integer> temperature = new ArrayList<Integer> ();
	
	int temperatureItem;
	int normalItem;
	
	int RefTruck;
	int NormalTruck;
	int remainNormalItem;
	double costing;
	
	public void collector (Set<NormalItem> manifestsItem, Set<Stock> quantity) {
		quantityCollection = quantity;
		for (NormalItem item: manifestsItem) {
			if (item instanceof TemperatureControlled) {
				TemperatureControlled tempname = (TemperatureControlled) item;
				RefItem.add(tempname);
			}else {
				itemCollection.add(item);
			}
		}
		arrangement ();
	}
	
	
	
	
	//int temperature [];
	
	public void arrangement () {
		
		
		
		for (TemperatureControlled Temperature_item :RefItem) {
			int i = 0;
			for (Stock OrderingStock : quantityCollection) {
				if (OrderingStock.getItem() == Temperature_item.getName()) {
					temperatureItem += OrderingStock.getQuantity();
					// fill the truck
					temperature.add(Temperature_item.getTemperature());
				}
			}
			i ++;
		}
		
		
		RefTruck = (int) Math.ceil(temperatureItem/800);
		
		Optional<Integer>minTemperature = temperature.stream().reduce(Integer::min);
		
		System.out.println(minTemperature.get());
		
		for (int i = 0; i < RefTruck; i ++) {
			RefigeratedTruck newRefTruck = new RefigeratedTruck (minTemperature.get());
			costing = costing + newRefTruck.cost();
		}
		
		// normal item calculation ---------------------
		
		for (NormalItem item :itemCollection) {
			for (Stock OrderingStock : quantityCollection) {
				if (OrderingStock.getItem() == item.getName()) {
					normalItem += OrderingStock.getQuantity();
				}
			}
		}
		
		normalItem = normalItem - (800 - (temperatureItem % 800));
		
		NormalTruck = (int) normalItem / 1000;
		for (int i = 0; i < NormalTruck; i ++) {
			// create Truck and cost for full 
			NormalTruck fewNormalTruck = new NormalTruck (1000);
			costing = costing + fewNormalTruck.cost();
		}
		
		// create truck according to remaining item
		NormalTruck lastNormalTruck = new NormalTruck (normalItem % 1000);
		costing = costing + lastNormalTruck.cost();
		
	}
	
	
	
	
	public double getCost () {
		
		// count maximum cost times all the truck   * (capacityN / truck limit)
		// (capacityN % truck limit) = quantity
		return costing;
	}
	
}
