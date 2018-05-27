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
import javax.swing.text.html.HTMLDocument.Iterator;


@SuppressWarnings("serial")
public class FilesReader extends JFrame implements ActionListener{
	
	String line;
	BufferedReader br;
	
	 JPanel panel = new JPanel();

	 JButton proceedBtn;
	 JButton cancelBtn;
	 String FileType;
	 
	private Set<String[]> allData = new HashSet<String[]> ();
	
	boolean correctFile = false;
	public boolean fileCheck (String FileType) throws IOException {
		
		FileType = FileType;
		
		//runFile (SelectedFile);
		
		
		
		
		if (FileType == "Item Properties") {
//			if (FileData[0].length > 4) {
//				correctFile = true;
//			}
			if (allData.iterator().next().length >= 4) {
		    	System.out.println("This fiele is properties");
		    	correctFile = true;
		    }
			
			
		}else if (FileType == "Manifests") {
//			if (FileData[0].length == 1) {
//				correctFile = true;
//			}
			if (allData.iterator().next().length == 1) {
		    	System.out.println("This file is Manifests");
		    	correctFile = true;
		    }
		}else if (FileType == "Sales Log"){
//			if (FileData[0].length == 2) {
//				correctFile = true;
//			}
			if (allData.iterator().next().length > 1) {
		    	System.out.println("This file is Sales log");
		    	correctFile = true;
		    }
		}else {
			// display error alert
			System.out.println("not iterator");
			correctFile = false;
		}
		return correctFile;
	}
     
	String FileData[][] = null;

	public void runFile(File selectedFile, String FileType) throws IOException{
		// TODO Auto-generated method stub
		
		try {
		    br = new BufferedReader (new FileReader(selectedFile));
	        int count = 0;
	        
		    while ((line = br.readLine()) != null) {
		    	String[] str = line.split(",");
		    	allData.add(str);
//		    	FileData[count] = null;
//		    	FileData[count] = str;
//		    	count ++;
	            	//String[] str = line.split(",");
	            	//Object data[] = new Object[str.length+2];
	            	
	            	//allData.add(str);
	            	
//	            	data[0] = Boolean.TRUE;
//	            	int i = 1;
//	            	while (i <= str.length) {
//	            		//model.addColumn(str[i]);
//	            		data [i] = str[i-1];
//	            		i ++;
//	            	}
	            	//model.addRow(data);
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
		if (fileCheck (FileType)) {
			run ();
		}
	}


	public void run () throws IOException {
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
	    
	    if (FileType == "Item Properties") {
	    	model.addColumn("Check"); 
		    model.addColumn("NAME"); 
		    model.addColumn("COST");
		    model.addColumn("PRICE");
		    model.addColumn("REORDER-POINT");
		    model.addColumn("REORDER-AMOUNT");
		    model.addColumn("TEMPERATURE");
		}else if (FileType == "Manifests") {
			model.addColumn("Check"); 
		    model.addColumn("NAME"); 
		    model.addColumn("Quantity");
		}else if (FileType == "Sales Log"){
			model.addColumn("Check"); 
		    model.addColumn("NAME"); 
		    model.addColumn("Quantity");
		}else {
			model.addColumn("Check"); 
		    model.addColumn("NAME"); 
		    model.addColumn("COST");
		    model.addColumn("PRICE");
		    model.addColumn("REORDER-POINT");
		    model.addColumn("REORDER-AMOUNT");
		    model.addColumn("TEMPERATURE");
		}
	    
	   
	    
	    
	    for (String[] s : allData) {
	        System.out.println(s);
	        Object data[] = new Object[s.length];
	        for (int i = 0 ; i < s.length; i ++) {
	        	data[i] = s[i];
	        }
	        model.addRow(data);
	    }
	    
//	    while (iter.hasNext()) {
//	    	int i = 0;
//	    	 
//	    	while (i <= FileData[count].length) {
//	    		Object data[] = new Object[FileData[count].length];
//	    		//model.addColumn(str[i]);
//				data [i] = FileData[count][i];
//				model.addRow(data);
//				i ++;
//	    	}
//	    	count ++;
//	    	System.out.println(iter.next());
//	    }
//    	
//    	allData.add(str);
//    	
////    	data[0] = Boolean.TRUE;
////    	int i = 1;
////    	while (i <= str.length) {
////    		//model.addColumn(str[i]);
////    		data [i] = str[i-1];
////    		i ++;
////    	}
////    	model.addRow(data);
	    
	    
	    
	    
        //this.pack();
//	    model.addColumn("Check"); 
//	    model.addColumn("NAME"); 
//	    model.addColumn("COST");
//	    model.addColumn("PRICE");
//	    model.addColumn("REORDER-POINT");
//	    model.addColumn("REORDER-AMOUNT");
//	    model.addColumn("TEMPERATURE");
//	    
//	    try {
//	    br = new BufferedReader (new FileReader(selected));
//        	while ((line = br.readLine()) != null) { 
//            	String[] str = line.split(",");
//            	//Object data[] = new Object[str.length+2];
//            	
//            	allData.add(str);
//            	
////            	data[0] = Boolean.TRUE;
////            	int i = 1;
////            	while (i <= str.length) {
////            		//model.addColumn(str[i]);
////            		data [i] = str[i-1];
////            		i ++;
////            	}
////            	model.addRow(data);
//        	}
//	    }catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
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
			
//			DataProcess sending = new DataProcess ();
//			sending.processing(allData);
//			this.dispose();
			
		}else if (e.getSource() == cancelBtn) {
			this.dispose();
		}
	
	}
	
	public Set<String []> getData (){
		return allData;
	}
	
}
