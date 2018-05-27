package GUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
//import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Item.Item;
import Item.NormalItem;
import Item.TemperatureControlled;
import Stock.Inventory;
import Stock.Purchase;
import Stock.Stock;
import Truck.CostCalculator;

@SuppressWarnings("serial")
public class FirstPageGUI extends JFrame implements ActionListener, Runnable {

	private Double cash= 100000.00;
	private Item item_collection = new Item ();
	private Inventory stock_collection = new Inventory ();
	
	
    //private String cashConvert = Double.toString(cash);
    private JPanel initialPanel = new JPanel();
    private JPanel buttonPanel = new JPanel ();
    private JPanel capPanel = new JPanel ();
    
    
    private JButton setUpButton = new JButton("Set-Up");
    private JButton exportManifests = new JButton ("Export Manifests");
    private JButton importSales = new JButton ("Import Sales_log");
    private JButton importManifests = new JButton ("Import Manifests");
    
    private JLabel capital = new JLabel (cash.toString());
    Toolkit tools = Toolkit.getDefaultToolkit();
    Dimension screen = tools.getScreenSize();
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// take if else case to set-up the system
		 setTitle("System Initialising");
	     setSize(745, 610);
	     
	     initialPanel.setPreferredSize(new Dimension (700,410));
	     buttonPanel.setPreferredSize(new Dimension (347,145));
	     capPanel.setPreferredSize(new Dimension (347,145));

	     buttonPanel.setLayout(new GridLayout (2, 2, 10, 10));
	     buttonPanel.setBackground(Color.GREEN);
	     
	     
	     initialPanel.setBackground(Color.BLACK);
	     
	     capPanel.setBackground(Color.BLUE);
	     
	     
	     setUpButton.addActionListener(this);
	     exportManifests.addActionListener(this);
	     importSales.addActionListener(this);
	     importManifests.addActionListener(this);
	     
	     
	     
	     
	     buttonPanel.add(setUpButton);
	     buttonPanel.add(exportManifests);
	     buttonPanel.add(importSales);
	     buttonPanel.add(importManifests);
	     
	     capPanel.add(capital);
	     
	     this.getContentPane().add(initialPanel);
	     this.getContentPane().add(buttonPanel);
	     this.getContentPane().add(capPanel);
	     
	     setLocation(screen.width/4, screen.height/10);
	     setVisible(true);
	     setDefaultCloseOperation(EXIT_ON_CLOSE);
	     
	     this.getContentPane().setLayout(new FlowLayout ());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == setUpButton) {
			
			FileSelection FileSelection = new FileSelection ();
			FileSelection.selectedFile();
			
			
			if (FileSelection.getFile() != null) {
				System.out.println(FileSelection.getFile().toString());
			

				FilesReader check = new FilesReader ();
				try {
					// use the other class to run and read the selected file
// check check.run
		// --> need to provide type of file as well
					check.runFile(FileSelection.getFile(), "Item Properties");
					// get the return of all data in a set<string []>
					PropertiesProcess(check.getData());
					// send it to somewhere to process it and get a return of 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			/*----------------------------------------------------------------------another Button ------------------------------------*/
		}else if (e.getSource() == exportManifests) {
			System.out.println("hahahhaha");
			
			Purchase expManifests = new Purchase ();
			expManifests.buy(item_collection.getItems(), stock_collection.getInventory());
			
			
			/*----------------------------------------------------------------------another Button ------------------------------------*/
		}else if (e.getSource() == importSales) {
			FileSelection FileSelection = new FileSelection ();
			FileSelection.selectedFile();
			
			if (FileSelection.getFile() != null) {
				FilesReader check = new FilesReader ();
				try {
					// use the other class to run and read the selected file
					check.runFile(FileSelection.getFile(), "Sales Log");
					// get the return of all data in a set<string []>
					//PropertiesProcess(check.getData());
					InventoryProcess ("importSales", check.getData());
					
					
					// send it to somewhere to process it and get a return of 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			/*----------------------------------------------------------------------another Button ------------------------------------*/
		}else if (e.getSource() == importManifests) {
			FileSelection FileSelection = new FileSelection ();
			FileSelection.selectedFile();
			
			if (FileSelection.getFile() != null) {
				FilesReader check = new FilesReader ();
				try {
					// use the other class to run and read the selected file
					check.runFile(FileSelection.getFile(), "Manifests");
					// get the return of all data in a set<string []>
					//PropertiesProcess(check.getData());
					
					InventoryProcess ("manifestsImport", check.getData());
					
					
					
					// send it to somewhere to process it and get a return of 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
	
	
	

	

	
	
	private void PropertiesProcess(Set<String[]> data) {
		// TODO Auto-generated method stub
		
		// have to save it with generic so that we can call both of the normal and temperature itme
		for(String[] Titem : data){
			if (Titem.length > 5) {
				   NormalItem itme = new TemperatureControlled (Titem[0], Double.parseDouble(Titem[1]), Double.parseDouble(Titem[2]), Integer.parseUnsignedInt(Titem[3]), Integer.parseUnsignedInt(Titem[4]), Integer.parseInt(Titem[5]));
				   item_collection.create_item(itme);
			   }else {
				   NormalItem iteme = new NormalItem (Titem[0], Double.parseDouble(Titem[1]), Double.parseDouble(Titem[2]), Integer.parseUnsignedInt(Titem[3]), Integer.parseUnsignedInt(Titem[4]));
				   item_collection.create_item(iteme);
			   }
		}
		//change_display ();
		InventoryProcess("SetUp", null);
		
	}
	Set<NormalItem> manifestsItem = new HashSet<NormalItem> ();
	Set<Stock> manifestsStock = new HashSet<Stock> ();
	private void InventoryProcess (String action, Set<String []> datas) {
		initialPanel.removeAll();
		capPanel.removeAll();
		if (action == "SetUp") {
			for (NormalItem temp : item_collection.getItems() ) {
				Stock updateQuantity = new Stock (temp.getName(),0);
				stock_collection.addInventory(updateQuantity);
				//System.out.println(temp.getName());
				System.out.println (updateQuantity.getItem() + updateQuantity.getQuantity());
			}
			change_display ();
		}else if (action == "manifestsImport"){
			
			//double itemCost = 0;
			for (String [] one : datas) {
				if (one.length == 1) {
					continue;
				}else {
					
					for (Stock ssone : stock_collection.getInventory()) {
						
						//if (one[0] == ssone.getItem()) {
						if (one[0].equals(ssone.getItem())) {
							ssone.setQuantity(ssone.getQuantity()+Integer.parseInt(one[1]));
							System.out.println(ssone.getQuantity());
							manifestsStock.add(ssone);
							// calculate base cost 
							for (NormalItem hahatwo : item_collection.getItems()) {
								if (hahatwo.getName() == ssone.getItem()) {
									//itemCost = itemCost + (ssone.getQuantity() * hahatwo.getCost());
									manifestsItem.add(hahatwo);
									cash = cash - (ssone.getQuantity() * hahatwo.getCost());
								}
							}
						}
					}
				}
			}
			CostCalculator calculateCost = new CostCalculator ();
			calculateCost.collector(manifestsItem, manifestsStock);
			System.out.println();
			cash = cash - calculateCost.getCost();
			
			
		}else if (action == "importSales") {
			for (String [] one : datas) {
				
					for (Stock ssone : stock_collection.getInventory()) {
						
						//if (one[0] == ssone.getItem()) {
						if (one[0].equals(ssone.getItem())) {
							for (NormalItem sstwo : item_collection.getItems ()) {
								if (sstwo.getName() == ssone.getItem()) {
									cash = cash + (ssone.getQuantity() * sstwo.getCost());
									arrangeTruck (sstwo, ssone.getQuantity());
									
									if (sstwo instanceof TemperatureControlled) {
										TemperatureControlled tempname = (TemperatureControlled) sstwo;
										tempname.getTemperature();
									}
									
								}
							}
							
							//System.out.println(ssone.getItem()+"asbdfuygasduyfaysudgfysdfgysadfgsdgfuysgdfyugsdyfgds");
							ssone.setQuantity(ssone.getQuantity()-Integer.parseInt(one[1]));
							System.out.println(ssone.getQuantity());
						}
					}
			}
		}
		
		change_display ();
	}
	
	private void arrangeTruck(NormalItem sstwo, int quantity) {
		// TODO Auto-generated method stub
		
	}

	public void change_display () {
		// sened the 2 collection to another class and take a table data as input
		//mainTable ();
		//initialPanel.remove(tableContainer);
		MainTableDisplay tdp = new MainTableDisplay();
		JScrollPane tableContainer = new JScrollPane(tdp.mainTable(item_collection.getItems(), stock_collection.getInventory()));
		tableContainer.setPreferredSize(new Dimension (700,410));
		initialPanel.add(tableContainer);
		//cash = cash String.format( "%.2f", dub
		capital = new JLabel (String.format( "%.2f", cash));
		capPanel.add(capital);
		//this.getPreferredSize();
		//initialPanel.setPreferredSize(new Dimension (700,410));
		//this.getContentPane().add(initialPanel);
		
		repaint ();
		setVisible(true);
	}
	
	
	/*
	private Item getItemCollection () {
		return item_collection;
	}
	
	private Inventory getStockCollection () {
		return stock_collection;
	}
	
	*/
	
	
	
}
