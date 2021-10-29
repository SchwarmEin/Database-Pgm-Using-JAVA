package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Customers;
import data.DataIO_Prov;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class ClientGUI extends JFrame {

	public static JTextArea textArea;
	public static JButton btnConnect;
	public static JButton btnAdd;
	public static JButton btnFind;
	public static JButton btnUpdate;
	public static JButton btnExit;
	
	private JPanel contentPane;
	private JTextField txtCustID;
	private JTextField txtZip;
	private JTextField txtCity;
	private JTextField txtStreet;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtCust_lname;
	private JTextField txtCust_fname;
	
	private Thread t;
	private ClientMain cc;

	public ClientGUI(){
		setTitle("DB Client Application");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1042, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustID = new JLabel("ID");
		lblCustID.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCustID.setBounds(25, 50, 130, 40);
		contentPane.add(lblCustID);
		
		JLabel lblCust_fname = new JLabel("First Name");
		lblCust_fname.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCust_fname.setBounds(25, 100, 130, 40);
		contentPane.add(lblCust_fname);
		
		JLabel lblCust_lname = new JLabel("Last Name");
		lblCust_lname.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCust_lname.setBounds(452, 100, 130, 40);
		contentPane.add(lblCust_lname);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Calibri", Font.BOLD, 16));
		lblPhone.setBounds(25, 255, 130, 40);
		contentPane.add(lblPhone);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 16));
		lblEmail.setBounds(452, 253, 130, 40);
		contentPane.add(lblEmail);
		
		JLabel lblStreet = new JLabel("Address");
		lblStreet.setFont(new Font("Calibri", Font.BOLD, 16));
		lblStreet.setBounds(25, 151, 130, 40);
		contentPane.add(lblStreet);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCity.setBounds(25, 202, 130, 40);
		contentPane.add(lblCity);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setFont(new Font("Calibri", Font.BOLD, 16));
		lblProvince.setBounds(375, 202, 130, 40);
		contentPane.add(lblProvince);
		
		JLabel lblZip = new JLabel("Postal Code");
		lblZip.setFont(new Font("Calibri", Font.BOLD, 16));
		lblZip.setBounds(562, 202, 130, 40);
		contentPane.add(lblZip);
		
		txtCustID = new JTextField();
		txtCustID.setFont(new Font("Calibri", Font.BOLD, 16));
		txtCustID.setBounds(165, 50, 277, 40);
		contentPane.add(txtCustID);
		txtCustID.setColumns(10);
		
		txtCust_fname = new JTextField();
		txtCust_fname.setFont(new Font("Calibri", Font.BOLD, 16));
		txtCust_fname.setColumns(10);
		txtCust_fname.setBounds(165, 100, 277, 40);
		contentPane.add(txtCust_fname);
		
		txtCust_lname = new JTextField();
		txtCust_lname.setFont(new Font("Calibri", Font.BOLD, 16));
		txtCust_lname.setColumns(10);
		txtCust_lname.setBounds(562, 100, 320, 40);
		contentPane.add(txtCust_lname);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Calibri", Font.BOLD, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(165, 255, 277, 40);
		contentPane.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Calibri", Font.BOLD, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(562, 255, 320, 40);
		contentPane.add(txtEmail);
		
		txtStreet = new JTextField();
		txtStreet.setFont(new Font("Calibri", Font.BOLD, 16));
		txtStreet.setColumns(10);
		txtStreet.setBounds(165, 151, 717, 40);
		contentPane.add(txtStreet);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Calibri", Font.BOLD, 16));
		txtCity.setColumns(10);
		txtCity.setBounds(165, 202, 200, 40);
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
		cboxProvince.setBounds(452, 202, 100, 40);
		contentPane.add(cboxProvince);
		
		txtZip = new JTextField();
		txtZip.setFont(new Font("Calibri", Font.BOLD, 16));
		txtZip.setColumns(10);
		txtZip.setBounds(682, 202, 200, 40);
		contentPane.add(txtZip);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 316, 980, 225);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO validation here
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
				
				// validate text count
				if (!Validator.hasValidTextCount(txtCust_fname.getText(), lblCust_fname.getText())
					|| !Validator.hasValidTextCount(txtCust_lname.getText(), lblCust_lname.getText())
					|| !Validator.hasValidTextCount(txtPhone.getText(), lblPhone.getText())
					|| !Validator.hasValidTextCount(txtEmail.getText(), lblEmail.getText())
					|| !Validator.hasValidTextCount(txtStreet.getText(), lblStreet.getText())
					|| !Validator.hasValidTextCount(txtCity.getText(), lblCity.getText())
					|| !Validator.hasValidTextCount(txtZip.getText(), lblZip.getText())
						) {
					return;
				}
				
				// validate the format for phone
				if (!Validator.hasValidPhoneFormat(txtPhone.getText())) {
					return;
				}
				
				// validate postal format
				if (!Validator.hasValidPostalFormat(txtZip.getText())) {
					return;
				}
				
				// validate email format
				if (!Validator.hasValidEmailFormat(txtEmail.getText())) {
					return;
				}
				
				Customers c = new Customers();
				c.setCust_fname(txtCust_fname.getText());
				c.setCust_lname(txtCust_lname.getText());
				c.setStreet(txtStreet.getText());
				c.setCity(txtCity.getText());
				c.setProvince(cboxProvince.getSelectedItem().toString());
				c.setPostal_code(txtZip.getText());
				c.setPhone(txtPhone.getText());
				c.setEmail(txtEmail.getText());
				
				// request to add customer
				cc.add(c);
				
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
				
			}
		});
		btnAdd.setEnabled(false);
		btnAdd.setFont(new Font("Calibri", Font.BOLD, 16));
		btnAdd.setBounds(905, 105, 100, 30);
		contentPane.add(btnAdd);
		
		btnFind = new JButton("FIND");
		btnFind.setEnabled(false);
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customers c = new Customers();

				// validate the text boxes, if first name is missing, then inform user
				if (Validator.hasEmptyInput(new String[] {
						txtCust_fname.getText()},
						"find")) {
					return;
				}
				
				// validate text count for first name
				if (!Validator.hasValidTextCount(txtCust_fname.getText(), lblCust_fname.getText())) {
					return;
				}
				
				c.setCust_fname(txtCust_fname.getText());
				cc.find(c);
				
				txtCust_fname.setText("");
			}
		});
		btnFind.setFont(new Font("Calibri", Font.BOLD, 16));
		btnFind.setBounds(905, 156, 100, 30);
		contentPane.add(btnFind);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO validation here
				// validate the textboxes, if missing fields, then inform user
				if (Validator.hasEmptyInput(new String[] {
						txtCustID.getText(),
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
				
				if(!Validator.isInt(txtCustID.getText())) {
					return;
				}
				
				// validate text count
				if (!Validator.hasValidTextCount(txtCust_fname.getText(), lblCust_fname.getText())
					|| !Validator.hasValidTextCount(txtCust_lname.getText(), lblCust_lname.getText())
					|| !Validator.hasValidTextCount(txtPhone.getText(), lblPhone.getText())
					|| !Validator.hasValidTextCount(txtEmail.getText(), lblEmail.getText())
					|| !Validator.hasValidTextCount(txtStreet.getText(), lblStreet.getText())
					|| !Validator.hasValidTextCount(txtCity.getText(), lblCity.getText())
					|| !Validator.hasValidTextCount(txtZip.getText(), lblZip.getText())
						) {
					return;
				}
				
				// validate the format for phone
				if (!Validator.hasValidPhoneFormat(txtPhone.getText())) {
					return;
				}
				
				// validate postal format
				if (!Validator.hasValidPostalFormat(txtZip.getText())) {
					return;
				}
				
				// validate email format
				if (!Validator.hasValidEmailFormat(txtEmail.getText())) {
					return;
				}
				
				Customers c = new Customers();
				c.setCust_id(Integer.parseInt(txtCustID.getText()));
				c.setCust_fname(txtCust_fname.getText());
				c.setCust_lname(txtCust_lname.getText());
				c.setStreet(txtStreet.getText());
				c.setCity(txtCity.getText());
				c.setProvince(cboxProvince.getSelectedItem().toString());
				c.setPostal_code(txtZip.getText());
				c.setPhone(txtPhone.getText());
				c.setEmail(txtEmail.getText());
				
				// request to update customer
				cc.update(c);
				
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
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 16));
		btnUpdate.setBounds(905, 207, 100, 30);
		contentPane.add(btnUpdate);
		
		btnExit = new JButton("EXIT");
		btnExit.setEnabled(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cc.stop();
				System.exit(0);		
			}
		});
		btnExit.setFont(new Font("Calibri", Font.BOLD, 16));
		btnExit.setBounds(905, 260, 100, 30);
		contentPane.add(btnExit);
		
		// moved connect to the bottom so it knows of the other buttons
		btnConnect = new JButton("CONNECT");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cc = new ClientMain();
				t = new Thread(cc);
				
				t.start();
				
			}
		});
		btnConnect.setFont(new Font("Calibri", Font.BOLD, 16));
		btnConnect.setBounds(905, 55, 100, 30);
		contentPane.add(btnConnect);
	}
}
