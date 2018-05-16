package GUI;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Scanner;

import Item.Item; 
import Stock.Inventory;

public class firstPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		gui frame = new gui ();
		frame.run();
		
		
		// run Gui
		
		
		// function import item properties
		
		
		
		
		// function import sales log 
		
		
		// function import manifests
		
		
		// function export manifests
		
		
	}
	
	private Boolean Sales_log = false;
	private Boolean Item_properties = false;
	private Boolean Manifests = false;
	
	public void readFiles (String directory) {
		// create a function to read all the files and store everything into ArrayList <ArrayList<String>>
		String line = "hgahah";
		String [] item = line.split(",");
		
		
		// at first
		// declare 1 inventory 
		// declare 1 item
		Item name = new Item ();
		Inventory inventory = new Inventory ();
		
		//name.create_item(item);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		File file = new File (directory);
		
		try {
			Scanner inputStream = new Scanner (file);
			while (inputStream.hasNext()) {
				
				// sepatate all properties by comma and save it into array
				
				if (Item_properties) {
					//send to item collection class first
					
					
					// send to inventory and save to collection class to save inventory
					
					// 
					
				}else if (Sales_log) {
					// send to sales class 
				}else if (Manifests) {
					// send to purchase class
				}else {
					throw new Error ();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
	}

}
