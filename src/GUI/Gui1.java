package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Scrollbar;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Button;

public class Gui1 {
	

	private JFrame frame;
	private JTable Livestock_table;
	private JTable Saleslog_table;
	private JTable Manifest_table;
	private JTable Item_properties_table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui1 window = new Gui1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("QUT SuperMart v1.0");
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 1368, 995);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		double total_balance = 1000000.00;
		
		Livestock_table = new JTable();
		Livestock_table.setBounds(12, 80, 651, 302);
		frame.getContentPane().add(Livestock_table);
		
		Saleslog_table = new JTable();
		Saleslog_table.setBounds(12, 447, 651, 302);
		frame.getContentPane().add(Saleslog_table);
		
		Manifest_table = new JTable();
		Manifest_table.setBounds(687, 80, 651, 302);
		frame.getContentPane().add(Manifest_table);
		
		Item_properties_table = new JTable();
		Item_properties_table.setBounds(687, 447, 651, 302);
		frame.getContentPane().add(Item_properties_table);
		
		JLabel lblHeader = new JLabel("QUT SuperMart v1.0");
		lblHeader.setForeground(new Color(220, 20, 60));
		lblHeader.setLabelFor(frame);
		lblHeader.setFont(new Font("Bahnschrift", Font.BOLD, 29));
		lblHeader.setBounds(537, 0, 349, 54);
		frame.getContentPane().add(lblHeader);
		
		JLabel lblSalesLog = new JLabel("Sales Log");
		lblSalesLog.setFont(new Font("Arial", Font.BOLD, 19));
		lblSalesLog.setBounds(12, 416, 198, 33);
		frame.getContentPane().add(lblSalesLog);
		
		JLabel lblLiveStock = new JLabel("Live Stock");
		lblLiveStock.setFont(new Font("Arial", Font.BOLD, 19));
		lblLiveStock.setBounds(12, 51, 198, 33);
		frame.getContentPane().add(lblLiveStock);
		
		JLabel lblManifest = new JLabel("Manifest");
		lblManifest.setFont(new Font("Arial", Font.BOLD, 19));
		lblManifest.setBounds(685, 55, 87, 25);
		frame.getContentPane().add(lblManifest);
		
		JLabel lblAccount = new JLabel("Account $");
		lblAccount.setFont(new Font("Arial", Font.BOLD, 17));
		lblAccount.setBounds(1082, 34, 87, 25);
		frame.getContentPane().add(lblAccount);
		
		JButton btnReset = new JButton("Resest");
		btnReset.setBackground(Color.RED);
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Arial", Font.BOLD, 17));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lnlTotalMoney = new JLabel();
		lnlTotalMoney.setForeground(new Color(178, 34, 34));
		lnlTotalMoney.setBackground(SystemColor.text);
		lnlTotalMoney.setFont(new Font("Arial", Font.BOLD, 21));
		lnlTotalMoney.setText(String.valueOf(total_balance));
		lnlTotalMoney.setBounds(1180, 17, 158, 54);
		frame.getContentPane().add(lnlTotalMoney);
		
		JLabel lblItemProperties = new JLabel("Item Properties");
		lblItemProperties.setFont(new Font("Arial", Font.BOLD, 19));
		lblItemProperties.setBounds(688, 419, 158, 26);
		frame.getContentPane().add(lblItemProperties);
		btnReset.setBounds(592, 826, 180, 63);
		frame.getContentPane().add(btnReset);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOrder.setFont(new Font("Arial", Font.BOLD, 15));
		btnOrder.setBounds(993, 862, 153, 44);
		frame.getContentPane().add(btnOrder);
		
		JButton btnSell = new JButton("Sell");
		btnSell.setFont(new Font("Arial", Font.BOLD, 17));
		btnSell.setBounds(993, 805, 153, 44);
		frame.getContentPane().add(btnSell);
		
		Button button = new Button("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(70, 805, 79, 24);
		frame.getContentPane().add(button);
	}
}
