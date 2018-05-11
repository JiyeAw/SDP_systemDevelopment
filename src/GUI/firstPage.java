package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class firstPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
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
		
		File file = new File (directory);
		
		try {
			Scanner inputStream = new Scanner (file);
			while (inputStream.hasNext()) {
				
				// sepatate all properties by comma and save it into array
				
				if (Item_properties) {
					//send to item collection class
					
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
		
	}

}
