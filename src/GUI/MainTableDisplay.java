package GUI;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainTableDisplay {

	public JScrollPane mainTable () {
		DefaultTableModel model = new DefaultTableModel(); 
	    JTable table = new JTable(model);
	    JScrollPane tableContainer = new JScrollPane(table);
	    
	    
	    
	    model.addColumn("NAME"); 
	    model.addColumn("COST");
	    model.addColumn("PRICE");
	    model.addColumn("REORDER-POINT");
	    model.addColumn("REORDER-AMOUNT");
	    model.addColumn("TEMPERATURE");
	    model.addColumn("QUANTITY"); 
	    
	    Object [] data = new Object[] {"sdfsd", 23,23,23,23,23,23};
	    model.addRow(data);
	    
	    
	    
	    return tableContainer;
	}
}
