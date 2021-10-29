package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Products;
import data.DataIO_Prod;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ProductGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtProdID;
	private JTextField txtProdName;
	private JTextField txtProdPrice;
	private JTextField txtProdPriceMin;
	private JTextField txtProdPriceMax;

	/**
	 * Create the frame.
	 */
	public ProductGUI() {
		setResizable(false);
		setTitle("Products Application");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProdID = new JLabel("Product ID");
		lblProdID.setFont(new Font("Calibri", Font.BOLD, 16));
		lblProdID.setBounds(25, 20, 150, 40);
		contentPane.add(lblProdID);
		
		JLabel lblProdName = new JLabel("Product Name");
		lblProdName.setFont(new Font("Calibri", Font.BOLD, 16));
		lblProdName.setBounds(25, 70, 150, 40);
		contentPane.add(lblProdName);
		
		JLabel lblProdPrice = new JLabel("Product Price");
		lblProdPrice.setFont(new Font("Calibri", Font.BOLD, 16));
		lblProdPrice.setBounds(25, 120, 150, 40);
		contentPane.add(lblProdPrice);
		
		JLabel lblProdPriceMin = new JLabel("Products Min Price");
		lblProdPriceMin.setFont(new Font("Calibri", Font.BOLD, 16));
		lblProdPriceMin.setBounds(25, 170, 150, 40);
		contentPane.add(lblProdPriceMin);
		
		JLabel lblFindOnlyMin = new JLabel("*FIND ONLY");
		lblFindOnlyMin.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblFindOnlyMin.setBounds(335, 170, 80, 40);
		contentPane.add(lblFindOnlyMin);
		
		JLabel lblProdPriceMax = new JLabel("Products Max Price");
		lblProdPriceMax.setFont(new Font("Calibri", Font.BOLD, 16));
		lblProdPriceMax.setBounds(25, 220, 150, 40);
		contentPane.add(lblProdPriceMax);
		
		JLabel lblFindOnlyMax = new JLabel("*FIND ONLY");
		lblFindOnlyMax.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		lblFindOnlyMax.setBounds(335, 220, 80, 40);
		contentPane.add(lblFindOnlyMax);
		
		txtProdID = new JTextField();
		txtProdID.setFont(new Font("Calibri", Font.BOLD, 16));
		txtProdID.setBounds(185, 20, 230, 40);
		contentPane.add(txtProdID);
		txtProdID.setColumns(10);
		
		txtProdName = new JTextField();
		txtProdName.setFont(new Font("Calibri", Font.BOLD, 16));
		txtProdName.setColumns(10);
		txtProdName.setBounds(185, 70, 230, 40);
		contentPane.add(txtProdName);
		
		txtProdPrice = new JTextField();
		txtProdPrice.setFont(new Font("Calibri", Font.BOLD, 16));
		txtProdPrice.setColumns(10);
		txtProdPrice.setBounds(185, 120, 230, 40);
		contentPane.add(txtProdPrice);
		
		txtProdPriceMin = new JTextField();
		txtProdPriceMin.setFont(new Font("Calibri", Font.BOLD, 16));
		txtProdPriceMin.setColumns(10);
		txtProdPriceMin.setBounds(185, 170, 150, 40);
		contentPane.add(txtProdPriceMin);
		
		txtProdPriceMax = new JTextField();
		txtProdPriceMax.setFont(new Font("Calibri", Font.BOLD, 16));
		txtProdPriceMax.setColumns(10);
		txtProdPriceMax.setBounds(185, 220, 150, 40);
		contentPane.add(txtProdPriceMax);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(425, 10, 350, 350);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Calibri", Font.PLAIN, 14));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "";
				try {
					DataIO_Prod dbIOprod = new DataIO_Prod();
					ArrayList<Products> prod = dbIOprod.getProd();
					
					//list the rows of the products table from database 
					for (Products p : prod) {
						result += p.toString() + "\n";
					}
					
					//check if there is any result return
					if (result.isBlank())
						textArea.setText("No result found.");
					else 
						textArea.setText(result);
					
					// reset input fields
					txtProdID.setText("");
					txtProdName.setText("");
					txtProdPrice.setText("");
					txtProdPriceMin.setText("");
					txtProdPriceMax.setText("");
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDisplay.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDisplay.setBounds(25, 275, 90, 30);
		contentPane.add(btnDisplay);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//check if the product name and product price is valid value to insert
				if (Validator.checkSaveOp(txtProdName, txtProdPrice)&&Validator.checkProdPrice(txtProdPrice)) {
					Products p = new Products();
					p.setProd_name(txtProdName.getText());
					p.setProd_price(Double.parseDouble(txtProdPrice.getText()));
					
					try {
						DataIO_Prod dbIOprod = new DataIO_Prod();
						dbIOprod.insertProduct(p);
						
						//show the successful message
						JOptionPane.showMessageDialog(null, "Product details have been saved.");
						
						// reset fields
						txtProdID.setText("");
						txtProdName.setText("");
						txtProdPrice.setText("");
						txtProdPriceMin.setText("");
						txtProdPriceMax.setText("");
						
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}	
		});
		btnSave.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSave.setBounds(125, 275, 90, 30);
		contentPane.add(btnSave);
		
		JButton btnFind = new JButton("FIND");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "";	
				//make sure that there are inputs for find operation
				if (Validator.checkFindOp(txtProdID, txtProdName, txtProdPriceMin, txtProdPriceMax)) {
					//if the product id field is not empty and the product id is valid value
					if (!txtProdID.getText().isBlank() && Validator.checkProdID(txtProdID)) {
						try {
							//get the required parameters
							ArrayList<Products> prod;
							DataIO_Prod dbIOprod = new DataIO_Prod();
							int id = Integer.parseInt(txtProdID.getText());
							
							//execute the find operation with product id
							prod = dbIOprod.getProdID(id);
							
							for (Products p : prod) {
								result += p.toString() + "\n";
							}
							
							//check if there is any result
							if (result.isBlank())
								textArea.setText("No results found.");
							else 
								textArea.setText(result);
							
							// reset input fields
							txtProdID.setText("");
							txtProdName.setText("");
							txtProdPrice.setText("");
							txtProdPriceMin.setText("");
							txtProdPriceMax.setText("");
							
							} catch (ClassNotFoundException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					//if the product name field is not empty
					} else if (!txtProdName.getText().isBlank()) {
						try {
							//get the required parameters
							ArrayList<Products> prod;	
							DataIO_Prod dbIOprod = new DataIO_Prod();
							String name = txtProdName.getText();
							
							//execute the find operation with product name
							prod = dbIOprod.getProdName(name);
							
							for (Products p : prod) {
								result += p.toString() + "\n";
							}
							
							//check if there is any result
							if (result.isBlank())
								textArea.setText("No results found.");
							else 
								textArea.setText(result);
							
							// reset input fields
							txtProdID.setText("");
							txtProdName.setText("");
							txtProdPrice.setText("");
							txtProdPriceMin.setText("");
							txtProdPriceMax.setText("");
							} catch (ClassNotFoundException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					// check if the one of product minimum price or product maximum price fields is not empty
					} else if (!txtProdPriceMin.getText().isBlank() || !txtProdPriceMax.getText().isBlank()) {
						/*check if both of the product minimum price and product maximum price should be provided,
						 and these values of price should be valid.*/
						if (Validator.checkProdPriceRange(txtProdPriceMin, txtProdPriceMax) 
								&& Validator.checkProdMAXandMINPrice(txtProdPriceMin, txtProdPriceMax)) {
							try {
								//get the required parameters
								ArrayList<Products> prod;	
								DataIO_Prod dbIOprod = new DataIO_Prod();
								double min = Double.parseDouble(txtProdPriceMin.getText());
								double max = Double.parseDouble(txtProdPriceMax.getText());
								
								//execute the find operation with range of product price
								prod = dbIOprod.getProdPrice(min, max);
								
								for (Products p : prod) {
									result += p.toString() + "\n";
								}
								
								//check if there is any result
								if (result.isBlank())
									textArea.setText("No results found.");
								else 
									textArea.setText(result);
								
								// reset input fields
								txtProdID.setText("");
								txtProdName.setText("");
								txtProdPrice.setText("");
								txtProdPriceMin.setText("");
								txtProdPriceMax.setText("");
								
							} catch (ClassNotFoundException | SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}
		});
		btnFind.setFont(new Font("Calibri", Font.BOLD, 16));
		btnFind.setBounds(225, 275, 90, 30);
		contentPane.add(btnFind);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// clear textArea
				textArea.setText("");
				
				//check if the product id is provided and price is valid value
				if(Validator.checkUpdateOp(txtProdID)&&Validator.checkProdPrice(txtProdPrice)) {
					
					// get the new values
					Products p = new Products();
					p.setProd_id(Integer.parseInt(txtProdID.getText()));
					p.setProd_name(txtProdName.getText());
					p.setProd_price(Double.parseDouble(txtProdPrice.getText()));
					
					// replace the old rows with the updated values
					try {
						DataIO_Prod dbIOprod = new DataIO_Prod();
						int rowsUpdated = dbIOprod.updateProduct(p);
						
						//check if the update is success
						if (rowsUpdated == 0) {
							JOptionPane.showMessageDialog(null, "Given product id not found.");	
						} else {
							JOptionPane.showMessageDialog(null, "Product details have been updated.");
						}
						
						// reset input fields
						txtProdID.setText("");
						txtProdName.setText("");
						txtProdPrice.setText("");
						txtProdPriceMin.setText("");
						txtProdPriceMax.setText("");
						
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}		
			}
		});
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 16));
		btnUpdate.setBounds(325, 275, 90, 30);
		contentPane.add(btnUpdate);
		
		JButton btnEXIT = new JButton("EXIT");
		btnEXIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnEXIT.setFont(new Font("Calibri", Font.BOLD, 16));
		btnEXIT.setBounds(25, 325, 390, 30);
		contentPane.add(btnEXIT);
		
	}
}
