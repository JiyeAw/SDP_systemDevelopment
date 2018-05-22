package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
//import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Item.Item;
import Item.NormalItem;
import Item.TemperatureControlled;
import Stock.Inventory;
import Stock.Stock;

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
    
    private JLabel capital = new JLabel (cash.toString());
    Toolkit tools = Toolkit.getDefaultToolkit();
    Dimension screen = tools.getScreenSize();
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		// take if else case to set-up the system
		 setTitle("System Initialising");
	     setSize(745, 600);
	     //setLayout (border);
	     
	     initialPanel.setPreferredSize(new Dimension (700,400));
	     buttonPanel.setPreferredSize(new Dimension (347,145));
	     capPanel.setPreferredSize(new Dimension (347,145));

	     buttonPanel.setLayout(new GridLayout (2, 2, 10, 10));
	     //buttonPanel.setPreferredSize(new Dimension(100, 600));
	     //buttonPanel.setMaximumSize(new Dimension(100, 600));
	     //buttonPanel.setPreferredSize(new Dimension(10, 10));
	     buttonPanel.setBackground(Color.GREEN);
	     
	     //initialPanel.setMinimumSize(new Dimension (40, 400));
	     initialPanel.setBackground(Color.BLACK);
	     
	     capPanel.setBackground(Color.BLUE);
	     
	     
	     setUpButton.addActionListener(this);
	     exportManifests.addActionListener(this);
	     importSales.addActionListener(this);
	     
	     
	     
	     //setLayout(new FlowLayout()); 
	     //add(capital = new JLabel("add JLabel"));
	     
	     //buttonPanel.setLayout(new GridLayout (3, 10, 5, 5));
	     
	     buttonPanel.add(setUpButton);
	     buttonPanel.add(exportManifests);
	     buttonPanel.add(importSales);
	     
	     capPanel.add(capital);
	     // realocate 
	     
	     this.getContentPane().add(initialPanel);
	     this.getContentPane().add(buttonPanel);
	     this.getContentPane().add(capPanel);
	     
	     setLocation(screen.width/4, screen.height/10);
	     //pack ();
	     setVisible(true);
	     setDefaultCloseOperation(EXIT_ON_CLOSE);
	     
	     this.getContentPane().setLayout(new FlowLayout ());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == setUpButton) {
			FileSelection FileSelection = new FileSelection ();
			//String testing = FileSelection.selectedFile();
			//System.out.println(testing);
			FileSelection.selectedFile();
			
			
			if (FileSelection.getFile() != null) {
				System.out.println(FileSelection.getFile().toString());
			
				//change_display ();
				FilesReader check = new FilesReader ();
				try {
					// use the other class to run and read the selected file
					check.run(FileSelection.getFile());
					// get the return of all datas in a set<string []>
					PropertiesProcess(check.getData());
					// send it to somewhere to process it and get a return of 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	        //filesave.showOpenDialog(null);
		}else if (e.getSource() == exportManifests) {
			System.out.println("hahahhaha");
		}else if (e.getSource() == importSales) {
			FileSelection FileSelection = new FileSelection ();
			FileSelection.selectedFile();
			
			if (FileSelection.getFile() != null) {
				System.out.println(FileSelection.getFile().toString());
			 
				change_display ();
			}
		}

	}
	
	
	

	public void change_display () {
		// sened the 2 collection to another class and take a table data as input
		//mainTable ();
		MainTableDisplay tdp = new MainTableDisplay();
		initialPanel.add(tdp.mainTable());
		repaint ();
		setVisible(true);
	}

	
	
	private void PropertiesProcess(Set<String[]> data) {
		// TODO Auto-generated method stub
		for(String[] Titem : data){
			if (Titem.length > 5) {
				   TemperatureControlled itme = new TemperatureControlled (Titem[0], Double.parseDouble(Titem[1]), Double.parseDouble(Titem[2]), Integer.parseUnsignedInt(Titem[3]), Integer.parseUnsignedInt(Titem[4]), Integer.parseInt(Titem[5]));
				   item_collection.create_item(itme);
			   }else {
				   NormalItem iteme = new NormalItem (Titem[0], Double.parseDouble(Titem[1]), Double.parseDouble(Titem[2]), Integer.parseUnsignedInt(Titem[3]), Integer.parseUnsignedInt(Titem[4]));
				   item_collection.create_item(iteme);
			   }
		}
		
		InventoryProcess("SetUp");
		
	}
	
	private void InventoryProcess (String action) {
		if (action == "SetUp") {
			for (NormalItem temp : item_collection.getItems() ) {
				Stock updateQuantity = new Stock (temp.getName(),0);
				stock_collection.addInventory(updateQuantity);
				//System.out.println(temp.getName());
				System.out.println (updateQuantity.getItem() + updateQuantity.getQuantity());
			}
			change_display ();
		}else {
			
		}
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
