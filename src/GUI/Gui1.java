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
import javax.swing.JList;
import java.awt.ScrollPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Insets;

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
		frame.setBounds(100, 100, 1368, 913);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		double total_balance = 1000000.00;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{214, 97, 206, 126, 0, 201, 107, 176, 158, 0};
		gridBagLayout.rowHeights = new int[]{54, 25, 0, 302, 34, 29, 302, 56, 0, 54, 44, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblHeader = new JLabel("QUT SuperMart v1.0");
		lblHeader.setForeground(new Color(220, 20, 60));
		lblHeader.setLabelFor(frame);
		lblHeader.setFont(new Font("Bahnschrift", Font.BOLD, 29));
		GridBagConstraints gbc_lblHeader = new GridBagConstraints();
		gbc_lblHeader.fill = GridBagConstraints.BOTH;
		gbc_lblHeader.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeader.gridwidth = 3;
		gbc_lblHeader.gridx = 3;
		gbc_lblHeader.gridy = 1;
		frame.getContentPane().add(lblHeader, gbc_lblHeader);
		
		JLabel lblAccount = new JLabel("Account $");
		lblAccount.setFont(new Font("Arial", Font.BOLD, 17));
		GridBagConstraints gbc_lblAccount = new GridBagConstraints();
		gbc_lblAccount.fill = GridBagConstraints.BOTH;
		gbc_lblAccount.insets = new Insets(0, 0, 5, 5);
		gbc_lblAccount.gridx = 7;
		gbc_lblAccount.gridy = 1;
		frame.getContentPane().add(lblAccount, gbc_lblAccount);
		
		JLabel lnlTotalMoney = new JLabel();
		lnlTotalMoney.setForeground(new Color(178, 34, 34));
		lnlTotalMoney.setBackground(SystemColor.text);
		lnlTotalMoney.setFont(new Font("Arial", Font.BOLD, 21));
		lnlTotalMoney.setText(String.valueOf(total_balance));
		GridBagConstraints gbc_lnlTotalMoney = new GridBagConstraints();
		gbc_lnlTotalMoney.fill = GridBagConstraints.BOTH;
		gbc_lnlTotalMoney.insets = new Insets(0, 0, 5, 0);
		gbc_lnlTotalMoney.gridx = 8;
		gbc_lnlTotalMoney.gridy = 1;
		frame.getContentPane().add(lnlTotalMoney, gbc_lnlTotalMoney);
		
		JLabel lblLiveStock = new JLabel("Live Stock");
		lblLiveStock.setFont(new Font("Arial", Font.BOLD, 19));
		GridBagConstraints gbc_lblLiveStock = new GridBagConstraints();
		gbc_lblLiveStock.fill = GridBagConstraints.BOTH;
		gbc_lblLiveStock.insets = new Insets(0, 0, 5, 5);
		gbc_lblLiveStock.gridx = 0;
		gbc_lblLiveStock.gridy = 2;
		frame.getContentPane().add(lblLiveStock, gbc_lblLiveStock);
		
		JLabel lblManifest = new JLabel("Manifest");
		lblManifest.setFont(new Font("Arial", Font.BOLD, 19));
		GridBagConstraints gbc_lblManifest = new GridBagConstraints();
		gbc_lblManifest.fill = GridBagConstraints.BOTH;
		gbc_lblManifest.insets = new Insets(0, 0, 5, 5);
		gbc_lblManifest.gridx = 5;
		gbc_lblManifest.gridy = 2;
		frame.getContentPane().add(lblManifest, gbc_lblManifest);
		
		Livestock_table = new JTable();
		GridBagConstraints gbc_Livestock_table = new GridBagConstraints();
		gbc_Livestock_table.fill = GridBagConstraints.BOTH;
		gbc_Livestock_table.insets = new Insets(0, 0, 5, 5);
		gbc_Livestock_table.gridwidth = 4;
		gbc_Livestock_table.gridx = 0;
		gbc_Livestock_table.gridy = 3;
		frame.getContentPane().add(Livestock_table, gbc_Livestock_table);
		
		Manifest_table = new JTable();
		GridBagConstraints gbc_Manifest_table = new GridBagConstraints();
		gbc_Manifest_table.fill = GridBagConstraints.BOTH;
		gbc_Manifest_table.insets = new Insets(0, 0, 5, 0);
		gbc_Manifest_table.gridwidth = 4;
		gbc_Manifest_table.gridx = 5;
		gbc_Manifest_table.gridy = 3;
		frame.getContentPane().add(Manifest_table, gbc_Manifest_table);
		
		JLabel lblSalesLog = new JLabel("Sales Log");
		lblSalesLog.setFont(new Font("Arial", Font.BOLD, 19));
		GridBagConstraints gbc_lblSalesLog = new GridBagConstraints();
		gbc_lblSalesLog.fill = GridBagConstraints.BOTH;
		gbc_lblSalesLog.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalesLog.gridx = 0;
		gbc_lblSalesLog.gridy = 5;
		frame.getContentPane().add(lblSalesLog, gbc_lblSalesLog);
		
		JLabel lblItemProperties = new JLabel("Item Properties");
		lblItemProperties.setFont(new Font("Arial", Font.BOLD, 19));
		GridBagConstraints gbc_lblItemProperties = new GridBagConstraints();
		gbc_lblItemProperties.fill = GridBagConstraints.BOTH;
		gbc_lblItemProperties.insets = new Insets(0, 0, 5, 5);
		gbc_lblItemProperties.gridx = 5;
		gbc_lblItemProperties.gridy = 5;
		frame.getContentPane().add(lblItemProperties, gbc_lblItemProperties);
		
		Saleslog_table = new JTable();
		GridBagConstraints gbc_Saleslog_table = new GridBagConstraints();
		gbc_Saleslog_table.fill = GridBagConstraints.BOTH;
		gbc_Saleslog_table.insets = new Insets(0, 0, 5, 5);
		gbc_Saleslog_table.gridwidth = 4;
		gbc_Saleslog_table.gridx = 0;
		gbc_Saleslog_table.gridy = 6;
		frame.getContentPane().add(Saleslog_table, gbc_Saleslog_table);
		
		Item_properties_table = new JTable();
		GridBagConstraints gbc_Item_properties_table = new GridBagConstraints();
		gbc_Item_properties_table.fill = GridBagConstraints.BOTH;
		gbc_Item_properties_table.insets = new Insets(0, 0, 5, 0);
		gbc_Item_properties_table.gridwidth = 4;
		gbc_Item_properties_table.gridx = 5;
		gbc_Item_properties_table.gridy = 6;
		frame.getContentPane().add(Item_properties_table, gbc_Item_properties_table);
		
		JLabel lblSearchItemPropertiescsv = new JLabel("Search Item properties(.csv)");
		GridBagConstraints gbc_lblSearchItemPropertiescsv = new GridBagConstraints();
		gbc_lblSearchItemPropertiescsv.anchor = GridBagConstraints.EAST;
		gbc_lblSearchItemPropertiescsv.fill = GridBagConstraints.VERTICAL;
		gbc_lblSearchItemPropertiescsv.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchItemPropertiescsv.gridx = 0;
		gbc_lblSearchItemPropertiescsv.gridy = 7;
		frame.getContentPane().add(lblSearchItemPropertiescsv, gbc_lblSearchItemPropertiescsv);
		
		JButton btnSearch = new JButton("Search...");
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.anchor = GridBagConstraints.WEST;
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 7;
		frame.getContentPane().add(btnSearch, gbc_btnSearch);
		
		JLabel lblSearchManifestcsv = new JLabel("Search Manifest(.csv)");
		GridBagConstraints gbc_lblSearchManifestcsv = new GridBagConstraints();
		gbc_lblSearchManifestcsv.anchor = GridBagConstraints.EAST;
		gbc_lblSearchManifestcsv.fill = GridBagConstraints.VERTICAL;
		gbc_lblSearchManifestcsv.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchManifestcsv.gridx = 2;
		gbc_lblSearchManifestcsv.gridy = 7;
		frame.getContentPane().add(lblSearchManifestcsv, gbc_lblSearchManifestcsv);
		
		JButton btnSearch_1 = new JButton("Search...");
		GridBagConstraints gbc_btnSearch_1 = new GridBagConstraints();
		gbc_btnSearch_1.anchor = GridBagConstraints.WEST;
		gbc_btnSearch_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch_1.gridx = 3;
		gbc_btnSearch_1.gridy = 7;
		frame.getContentPane().add(btnSearch_1, gbc_btnSearch_1);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOrder.setFont(new Font("Arial", Font.BOLD, 15));
		GridBagConstraints gbc_btnOrder = new GridBagConstraints();
		gbc_btnOrder.fill = GridBagConstraints.BOTH;
		gbc_btnOrder.insets = new Insets(0, 0, 5, 5);
		gbc_btnOrder.gridx = 5;
		gbc_btnOrder.gridy = 7;
		frame.getContentPane().add(btnOrder, gbc_btnOrder);
		
		JButton btnSell = new JButton("Sell");
		btnSell.setFont(new Font("Arial", Font.BOLD, 17));
		GridBagConstraints gbc_btnSell = new GridBagConstraints();
		gbc_btnSell.fill = GridBagConstraints.BOTH;
		gbc_btnSell.insets = new Insets(0, 0, 5, 5);
		gbc_btnSell.gridx = 7;
		gbc_btnSell.gridy = 7;
		frame.getContentPane().add(btnSell, gbc_btnSell);
		
		JButton btnReset = new JButton("Resest");
		btnReset.setBackground(Color.RED);
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Arial", Font.BOLD, 17));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.insets = new Insets(0, 0, 5, 0);
		gbc_btnReset.gridx = 8;
		gbc_btnReset.gridy = 7;
		frame.getContentPane().add(btnReset, gbc_btnReset);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
