package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.DataIO_Cust;
import data.DataIO_Prod;
import data.DataIO_Prov;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AppMainWindow() {
		setResizable(false);
		setTitle("Customers &  Products Data Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 326);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCreate = new JMenu("Create");
		mnCreate.setMnemonic(KeyEvent.VK_R);
		menuBar.add(mnCreate);
		
		JMenuItem mntmCrtCust = new JMenuItem("Customers");
		mntmCrtCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// customers table
				DataIO_Cust dbIOcust;
				try {
					dbIOcust = new DataIO_Cust();
					dbIOcust.createCusTable();
					JOptionPane.showMessageDialog(null, "Customers table has been created.");
				} catch (ClassNotFoundException | SQLException e1) {
					
					JOptionPane.showMessageDialog(null, "Customers table already exists in database!!", "ERROR", JOptionPane.ERROR_MESSAGE);
					//e1.printStackTrace();
				}
			}
		});
		mntmCrtCust.setMnemonic(KeyEvent.VK_C);
		mnCreate.add(mntmCrtCust);
		
		JMenuItem mntmCrtProd = new JMenuItem("Products");
		mntmCrtProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// products table
				DataIO_Prod dbIOprod;
				try {
					dbIOprod = new DataIO_Prod();
					dbIOprod.createProdTable();
					JOptionPane.showMessageDialog(null, "Products table has been created.");
				} catch (ClassNotFoundException | SQLException e1) {
					
					JOptionPane.showMessageDialog(null, "Products table already exists in database!!", "ERROR", JOptionPane.ERROR_MESSAGE);
					//e1.printStackTrace();
				}
			}
		});
		mntmCrtProd.setMnemonic(KeyEvent.VK_D);
		mnCreate.add(mntmCrtProd);
		
		JMenuItem mntmCrtPron = new JMenuItem("Provinces");
		mntmCrtPron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create and initialize the province table
				DataIO_Prov dbIOprov;
				try {
					dbIOprov = new DataIO_Prov();
					dbIOprov.createProvinceTable();
					dbIOprov.insertProvinceList();
					JOptionPane.showMessageDialog(null, "Provinces table has been created and inserted with needed value.");
				} catch (ClassNotFoundException | SQLException e1) {
					
					JOptionPane.showMessageDialog(null, "Provinces table already exists in database!!", "ERROR", JOptionPane.ERROR_MESSAGE);
					//e1.printStackTrace();
				}
			}
		});
		mntmCrtPron.setMnemonic(KeyEvent.VK_V);
		mnCreate.add(mntmCrtPron);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.setMnemonic(KeyEvent.VK_X);
		mnCreate.add(mntmExit);
		
		JMenu mnTable = new JMenu("Tables");
		mnTable.setMnemonic(KeyEvent.VK_T);
		menuBar.add(mnTable);
		
		JMenuItem mntmCust = new JMenuItem("Customers");
		mntmCust.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerGUI c = new CustomerGUI();
				c.setVisible(true);
			}
		});
		mntmCust.setMnemonic(KeyEvent.VK_C);
		mnTable.add(mntmCust);
		
		JMenuItem mntmProd = new JMenuItem("Products");
		mntmProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductGUI p = new ProductGUI();
				p.setVisible(true);
			}
		});
		mntmProd.setMnemonic(KeyEvent.VK_P);
		mnTable.add(mntmProd);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPgVersion = new JLabel("Customer & Product Data Application v1.0\r\n");
		lblPgVersion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblPgVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPgVersion.setBounds(10, 231, 500, 30);
		contentPane.add(lblPgVersion);
		
		JLabel lblTitle = new JLabel("Data Application");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(10, 10, 500, 50);
		contentPane.add(lblTitle);
		
		JTextPane txtpnInstructionsTo = new JTextPane();
		txtpnInstructionsTo.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpnInstructionsTo.setBackground(Color.WHITE);
		txtpnInstructionsTo.setEditable(false);
		txtpnInstructionsTo.setText("Instructions:\r\n- IMPORTANT: Create the tables\r\n\t- Click on Create and choose the required table\r\n\t- Do this for Customers, Products, and Province\r\n- To select Customers GUI, click on Tables > Customers\r\n- To select Products GUI, click on Tables > Products\r\n- To exit, click on Create > Exit");
		txtpnInstructionsTo.setBounds(10, 80, 500, 140);
		contentPane.add(txtpnInstructionsTo);
	}
}
