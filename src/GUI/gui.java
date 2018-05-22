package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class gui extends JFrame implements ActionListener, Runnable {

	private static final ActionEvent ActionEvent = null;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 setTitle("Inventory System");
	     setSize(400, 400);
	     
	     JButton button = new JButton("Load Item Properties");
	     JPanel panel = new JPanel();

	     // Add button to JPanel
	     panel.add(button);
	     // Add button function
	     ActionEvent haha ;
	     //button.actionPerformed (haha);
	     
	     // And JPanel needs to be added to the JFrame itself!
	     this.getContentPane().add(panel);

	     setVisible(true);
	     setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//if (src == ) {
			FilesReader reading = new FilesReader ();
			reading.reader();
		//}
	}

}
