package GUI;

import java.awt.Dimension;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Item.NormalItem;
import Item.TemperatureControlled;
import Stock.Stock;

public class MainTableDisplay {

	public JTable mainTable (Set<NormalItem> itemData, Set<Stock> stockData) {
		DefaultTableModel model = new DefaultTableModel(); 
	    JTable table = new JTable(model);
	    //JScrollPane tableContainer = new JScrollPane(table);
	    
	    //table.setSize(700, 400);
	    //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    //table
	    //table.setPreferredSize(new Dimension (700, 400));
	    //tableContainer.setSize(700, 400);
	    //tableContainer.setAutoscrolls(false);
	    
	    
	    model.addColumn("NAME"); 
	    model.addColumn("COST");
	    model.addColumn("PRICE");
	    model.addColumn("REORDER-POINT");
	    model.addColumn("REORDER-AMOUNT");
	    model.addColumn("TEMPERATURE");
	    model.addColumn("QUANTITY"); 
	    
	    for (NormalItem temp: itemData) {
	    	Object [] data;
	    	if (temp instanceof TemperatureControlled) {
	    	
	    		for (Stock temporar : stockData) {
	    			if (temporar.getItem() == temp.getName()) {	    			
	    				TemperatureControlled tempname = (TemperatureControlled) temp;
	    				data = new Object[] {tempname.getName(), tempname.getCost(), tempname.getPrice(), tempname.getReorderPoint(), tempname.getReorderAmount(), tempname.getTemperature(),temporar.getQuantity()};
	    				model.addRow(data);
	    			}
	    		}
	    	}else {
	    		for (Stock temporar : stockData) {
	    			if (temporar.getItem() == temp.getName()) {
	    				data = new Object[] {temp.getName(), temp.getCost(), temp.getPrice(), temp.getReorderPoint(), temp.getReorderAmount(), "N/A",temporar.getQuantity()};
	    				model.addRow(data);
	    			}
	    		}
			}
	    }
	    
	    
	    
	    
	    
	    return table;
	}
}
