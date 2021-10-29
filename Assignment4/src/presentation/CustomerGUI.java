package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Customers;
import data.DataIO_Cust;
import data.DataIO_Prov;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class CustomerGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustID;
	private JTextField txtZip;
	private JTextField txtCity;
	private JTextField txtStreet;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtCust_lname;
	private JTextField txtCust_fname;

	public CustomerGUI(){
		setTitle("Customers Application");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustID = new JLabel("Customer ID");
		lblCustID.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCustID.setBounds(25, 50, 130, 40);
		contentPane.add(lblCustID);
		
		JLabel lblCust_fname = new JLabel("First Name");
		lblCust_fname.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCust_fname.setBounds(25, 100, 130, 40);
		contentPane.add(lblCust_fname);
		
		JLabel lblCust_lname = new JLabel("Last Name");
		lblCust_lname.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCust_lname.setBounds(25, 150, 130, 40);
		contentPane.add(lblCust_lname);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPhone.setBounds(25, 200, 130, 40);
		contentPane.add(lblPhone);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 16));
		lblEmail.setBounds(25, 250, 130, 40);
		contentPane.add(lblEmail);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Calibri", Font.BOLD, 16));
		lblStreet.setBounds(25, 300, 130, 40);
		contentPane.add(lblStreet);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCity.setBounds(25, 350, 130, 40);
		contentPane.add(lblCity);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setFont(new Font("Calibri", Font.BOLD, 16));
		lblProvince.setBounds(25, 400, 130, 40);
		contentPane.add(lblProvince);
		
		JLabel lblZip = new JLabel("Postal Code");
		lblZip.setFont(new Font("Calibri", Font.BOLD, 16));
		lblZip.setBounds(25, 450, 130, 40);
		contentPane.add(lblZip);
		
		txtCustID = new JTextField();
		txtCustID.setFont(new Font("Calibri", Font.BOLD, 16));
		txtCustID.setBounds(165, 50, 200, 40);
		contentPane.add(txtCustID);
		txtCustID.setColumns(10);
		
		txtCust_fname = new JTextField();
		txtCust_fname.setFont(new Font("Calibri", Font.BOLD, 16));
		txtCust_fname.setColumns(10);
		txtCust_fname.setBounds(165, 100, 200, 40);
		contentPane.add(txtCust_fname);
		
		txtCust_lname = new JTextField();
		txtCust_lname.setFont(new Font("Calibri", Font.BOLD, 16));
		txtCust_lname.setColumns(10);
		txtCust_lname.setBounds(165, 150, 200, 40);
		contentPane.add(txtCust_lname);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Calibri", Font.BOLD, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(165, 200, 200, 40);
		contentPane.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Calibri", Font.BOLD, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(165, 250, 200, 40);
		contentPane.add(txtEmail);
		
		txtStreet = new JTextField();
		txtStreet.setFont(new Font("Calibri", Font.BOLD, 16));
		txtStreet.setColumns(10);
		txtStreet.setBounds(165, 300, 200, 40);
		contentPane.add(txtStreet);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Calibri", Font.BOLD, 16));
		txtCity.setColumns(10);
		txtCity.setBounds(165, 350, 200, 40);
		contentPane.add(txtCity);
		
		JComboBox<Object> cboxProvince = new JComboBox<Object>();
		// Read and load the items from province table
		String[] provinceList = null;
		try {
			DataIO_Prov dbIOpro = new DataIO_Prov();
			provinceList = dbIOpro.setProvinceList();
		} catch (SQLException | ClassNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "Unable to load Province table.\nMake sure the all tables are loaded before continuing.", "ERROR", JOptionPane.ERROR_MESSAGE);
			provinceList = new String[]{"-Empty List-"};
			
		} 
		cboxProvince.setModel(new DefaultComboBoxModel<Object>(provinceList));
		cboxProvince.setEditable(true);
		cboxProvince.setFont(new Font("Calibri", Font.BOLD, 16));
		cboxProvince.setBounds(165, 400, 200, 40);
		contentPane.add(cboxProvince);
		
		txtZip = new JTextField();
		txtZip.setFont(new Font("Calibri", Font.BOLD, 16));
		txtZip.setColumns(10);
		txtZip.setBounds(165, 450, 200, 40);
		contentPane.add(txtZip);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 50, 450, 450);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// validate the textboxes, if missing fields, then inform user
				if (Validator.hasEmptyInput(new String[] {
						txtCust_fname.getText(),
						txtCust_lname.getText(),
						txtPhone.getText(),
						txtEmail.getText(),
						txtStreet.getText(),
						txtCity.getText(),
						txtZip.getText()},
						"save")) {
					return;
				}
				
				// validation passed, create and insert user to DB
				Customers c = new Customers();
				c.setCust_fname(txtCust_fname.getText());
				c.setCust_lname(txtCust_lname.getText());
				c.setPhone(txtPhone.getText());
				c.setEmail(txtEmail.getText());
				c.setStreet(txtStreet.getText());
				c.setCity(txtCity.getText());
				c.setProvince(cboxProvince.getSelectedItem().toString());
				c.setPostal_code(txtZip.getText());
				
				try {
					
					DataIO_Cust dbIOcust = new DataIO_Cust();
					dbIOcust.insertCustomer(c);
					
					JOptionPane.showMessageDialog(null, "Customer has been saved.");
					
					// reset fields
					txtCustID.setText("");
					txtCust_fname.setText("");
					txtCust_lname.setText("");
					txtPhone.setText("");
					txtEmail.setText("");
					txtStreet.setText("");
					txtCity.setText("");
					cboxProvince.setSelectedIndex(0);
					txtZip.setText("");
					
					
				} catch (SQLException | ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Unable to load Customer table.\nMake sure the all tables are loaded before continuing.", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		btnSave.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSave.setBounds(300, 520, 100, 30);
		contentPane.add(btnSave);
		
		JButton btnFind = new JButton("FIND");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "";
			
				// get the first name and last name from the user
				// if both are empty, let the user know
				if (Validator.hasEmptyInputAll(new String[] {
						txtCust_fname.getText(),
						txtCust_lname.getText()}, "display")) {
					return;
				}
					
				try {
					
					DataIO_Cust dbIOcust = new DataIO_Cust();
					ArrayList<Customers> cust;
					
					if (txtCust_lname.getText().isBlank()) {
						// if first name is not empty, but last name is empty, use first name to search
						cust = dbIOcust.getCustFname(txtCust_fname.getText());
						
					} else if (txtCust_fname.getText().isBlank()) {
						// else if first is empty, then use last name to search
						cust = dbIOcust.getCustLname(txtCust_lname.getText());
					} else {
						// else if they're both available, use both to search (and logic)
						cust = dbIOcust.getCust(txtCust_fname.getText(), txtCust_lname.getText());
					}
					
					// build text area
					for (Customers c : cust) {
						result += c.toString() + "\n";
					}
					
					if (result.isBlank())
						textArea.setText("No results found.");
					else 
						textArea.setText(result);
					
					// reset fields
					txtCustID.setText("");
					txtCust_fname.setText("");
					txtCust_lname.setText("");
					txtPhone.setText("");
					txtEmail.setText("");
					txtStreet.setText("");
					txtCity.setText("");
					cboxProvince.setSelectedIndex(0);
					txtZip.setText("");
					
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Unable to load Customer table.\nMake sure the all tables are loaded before continuing.", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			}
		});
		btnFind.setFont(new Font("Calibri", Font.BOLD, 16));
		btnFind.setBounds(425, 520, 100, 30);
		contentPane.add(btnFind);
		
		JButton btnEXIT = new JButton("EXIT");
		btnEXIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnEXIT.setFont(new Font("Calibri", Font.BOLD, 16));
		btnEXIT.setBounds(550, 520, 100, 30);
		contentPane.add(btnEXIT);
		
		JButton btnFirst = new JButton("FIRST");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear textArea
				textArea.setText("");
				
				try {
					DataIO_Cust dbIOcust = new DataIO_Cust();
					Customers c = dbIOcust.getFirst();
					
					if (c == null) {
						JOptionPane.showMessageDialog(null, "No further customer to show.");
						return;
					} 
					
					
					txtCustID.setText(Integer.toString(c.getCust_id()));
					txtCust_fname.setText(c.getCust_fname());
					txtCust_lname.setText(c.getCust_lname());
					txtPhone.setText(c.getPhone());
					txtEmail.setText(c.getEmail());
					txtStreet.setText(c.getStreet());
					txtCity.setText(c.getCity());
					cboxProvince.setSelectedItem(c.getProvince());
					txtZip.setText(c.getPostal_code());
					
					//textArea.setText(c.toString());
					
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Unable to load Customer table.\nMake sure the all tables are loaded before continuing.", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
							
			}
		});
		btnFirst.setFont(new Font("Calibri", Font.BOLD, 15));
		btnFirst.setBounds(165, 10, 100, 25);
		contentPane.add(btnFirst);
		
		JButton btnPervious = new JButton("PREVIOUS");
		btnPervious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear textArea
				textArea.setText("");
				
				// base on customer id
				// validate customer id, if empty notify the user
				if (Validator.hasEmptyInput(new String[] {txtCustID.getText()}, "previous"))
					return;
				
				// verify that the id is a number
				if (!Validator.isInt(txtCustID.getText())) {
					return;
				}
				
				try {
					DataIO_Cust dbIOcust = new DataIO_Cust();
					// verify the current id exists
					Customers c = dbIOcust.getPrevious(Integer.parseInt(txtCustID.getText()));
					
					if (c == null) {
						JOptionPane.showMessageDialog(null, "No further customer to show.");
						return;
					} 
					
					
					txtCustID.setText(Integer.toString(c.getCust_id()));
					txtCust_fname.setText(c.getCust_fname());
					txtCust_lname.setText(c.getCust_lname());
					txtPhone.setText(c.getPhone());
					txtEmail.setText(c.getEmail());
					txtStreet.setText(c.getStreet());
					txtCity.setText(c.getCity());
					cboxProvince.setSelectedItem(c.getProvince());
					txtZip.setText(c.getPostal_code());
					
					//textArea.setText(c.toString());
					
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Unable to load Customer table.\nMake sure the all tables are loaded before continuing.", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			}
		});
		btnPervious.setFont(new Font("Calibri", Font.BOLD, 15));
		btnPervious.setBounds(295, 10, 100, 25);
		contentPane.add(btnPervious);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear textArea
				textArea.setText("");
				
				// base on customer id
				// validate customer id, if empty notify the user
				if (Validator.hasEmptyInput(new String[] {txtCustID.getText()}, "next"))
					return;
				
				// verify that the id is a number
				if (!Validator.isInt(txtCustID.getText())) {
					return;
				}
				
				try {
					DataIO_Cust dbIOcust = new DataIO_Cust();
					Customers c = dbIOcust.getNext(Integer.parseInt(txtCustID.getText()));
					
					if (c == null) {
						JOptionPane.showMessageDialog(null, "No further customer to show.");
						return;
					} 
					
					txtCustID.setText(Integer.toString(c.getCust_id()));
					txtCust_fname.setText(c.getCust_fname());
					txtCust_lname.setText(c.getCust_lname());
					txtPhone.setText(c.getPhone());
					txtEmail.setText(c.getEmail());
					txtStreet.setText(c.getStreet());
					txtCity.setText(c.getCity());
					cboxProvince.setSelectedItem(c.getProvince());
					txtZip.setText(c.getPostal_code());
					
					//textArea.setText(c.toString());
					
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Unable to load Customer table.\nMake sure the all tables are loaded before continuing.", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			}
		});
		btnNext.setFont(new Font("Calibri", Font.BOLD, 15));
		btnNext.setBounds(425, 10, 100, 25);
		contentPane.add(btnNext);
		
		JButton btnLast = new JButton("LAST");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// clear textArea
				textArea.setText("");
				
				try {
					DataIO_Cust dbIOcust = new DataIO_Cust();
					Customers c = dbIOcust.getLast();
					
					if (c == null) {
						JOptionPane.showMessageDialog(null, "No further customer to show.");
						return;
					} 
					
					
					txtCustID.setText(Integer.toString(c.getCust_id()));
					txtCust_fname.setText(c.getCust_fname());
					txtCust_lname.setText(c.getCust_lname());
					txtPhone.setText(c.getPhone());
					txtEmail.setText(c.getEmail());
					txtStreet.setText(c.getStreet());
					txtCity.setText(c.getCity());
					cboxProvince.setSelectedItem(c.getProvince());
					txtZip.setText(c.getPostal_code());
					
					//textArea.setText(c.toString());
					
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Unable to load Customer table.\nMake sure the all tables are loaded before continuing.", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			}
		});
		btnLast.setFont(new Font("Calibri", Font.BOLD, 15));
		btnLast.setBounds(555, 10, 100, 25);
		contentPane.add(btnLast);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// verify that the id is a number
				if (!Validator.isInt(txtCustID.getText())) {
					return;
				}
				
				// validate the textboxes, if missing fields, then inform user
				if (Validator.hasEmptyInput(new String[] {
						txtCust_fname.getText(),
						txtCust_lname.getText(),
						txtPhone.getText(),
						txtEmail.getText(),
						txtStreet.getText(),
						txtCity.getText(),
						txtZip.getText()},
						"update")) {
					return;
				}
				
				// validation passed, create and insert user to DB
				Customers c = new Customers();
				c.setCust_id(Integer.parseInt(txtCustID.getText()));
				c.setCust_fname(txtCust_fname.getText());
				c.setCust_lname(txtCust_lname.getText());
				c.setPhone(txtPhone.getText());
				c.setEmail(txtEmail.getText());
				c.setStreet(txtStreet.getText());
				c.setCity(txtCity.getText());
				c.setProvince(cboxProvince.getSelectedItem().toString());
				c.setPostal_code(txtZip.getText());
				
				
				try {
					DataIO_Cust dbIOcust = new DataIO_Cust();
					int rowsUpdated = dbIOcust.updateCustomer(c);
					
					if (rowsUpdated == 0) {
						JOptionPane.showMessageDialog(null, "Given customer id not found.");
						
					} else if (rowsUpdated > 0) {
						JOptionPane.showMessageDialog(null, "Customer details have been updated.");
						
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, "Unable to load Customer.\nMake sure the all tables are loaded before continuing.", "ERROR", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 15));
		btnUpdate.setBounds(685, 10, 100, 25);
		contentPane.add(btnUpdate);
		
	}
}
