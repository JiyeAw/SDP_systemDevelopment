package GUI;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileSelection {
	
	private File fileSelected = null;
	private FileNameExtensionFilter filter = new FileNameExtensionFilter(".csv file", "csv");
	
	public void selectedFile () {
		//JFrame selection = new JFrame ();
		//JPanel showMessage= new JPanel();
		JFileChooser filesave = new JFileChooser("System Set up!");
		filesave.setFileFilter(filter);
		
		filesave.setSize(520, 370);
		filesave.setVisible(true);
		
		
		filesave.setDialogTitle("Load In A File");
		filesave.setApproveButtonText("Load a CSV file");
		
		
		
		int result = filesave.showDialog(filesave, null);
		
		if (result == JFileChooser.APPROVE_OPTION) {
			fileSelected = filesave.getSelectedFile();
		} else if (result == JFileChooser.CANCEL_OPTION) {
		    System.out.println("Cancel was selected");
		    filesave.cancelSelection();
		}
		
	}
	
	public File getFile () {
		
		return fileSelected;
	}
}
