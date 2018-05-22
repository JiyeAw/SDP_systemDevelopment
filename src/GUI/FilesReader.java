package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Process.DataProcess;

public class FilesReader extends JFrame implements ActionListener{
	
	String line;
	BufferedReader br;
	
	 JPanel panel = new JPanel();

	 JButton proceedBtn;
	 JButton cancelBtn;
	 
	private Set<String[]> allData = new HashSet<String[]> ();
     

	public void run (File selected) throws IOException {
		setTitle("File Selected");
	    setSize(745, 600);
	    
	    proceedBtn = new JButton ("Load-In");
	    cancelBtn = new JButton ("Cancel");
	    
	    proceedBtn.addActionListener(this);
	    cancelBtn.addActionListener(this);
	    
	    
	    
	    DefaultTableModel model = new DefaultTableModel(); 
	    JTable table = new JTable(model);
	    JScrollPane tableContainer = new JScrollPane(table);
	    
	    panel.setLayout(new BorderLayout());
	    
	    
	    
        //this.pack();
	    model.addColumn("Check"); 
	    model.addColumn("NAME"); 
	    model.addColumn("COST");
	    model.addColumn("PRICE");
	    model.addColumn("REORDER-POINT");
	    model.addColumn("REORDER-AMOUNT");
	    model.addColumn("TEMPERATURE");
	    
        
        
	    
	    try {
	    br = new BufferedReader (new FileReader(selected));
        	while ((line = br.readLine()) != null) { 
        		System.out.println(line);
            	String[] str = line.split(",");
            	Object data[] = new Object[8];
            	
            	allData.add(str);
            	
            	data[0] = Boolean.TRUE;
            	int i = 1;
            	while (i <= str.length) {
            		//model.addColumn(str[i]);
            		data [i] = str[i-1];
            		i ++;
            	}
            	model.addRow(data);
        	}
	    }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	    
	    // table display
	    
	    panel.add(tableContainer, BorderLayout.CENTER);
	    panel.add(cancelBtn, BorderLayout.AFTER_LAST_LINE);
	    panel.add(proceedBtn, BorderLayout.AFTER_LINE_ENDS);
        this.getContentPane().add(panel);
	    
	    
	    // add 2 button 
	    // Load In 
	    // cancel
	    
	    
	    setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == proceedBtn) {
			System.out.println ("Load In");
			
			DataProcess sending = new DataProcess ();
			sending.processing(allData);
			
		}else if (e.getSource() == cancelBtn) {
			System.out.println ("Cancel");
		}
	
	}
	
	public Set<String []> getData (){
		return allData;
	}
	
}
