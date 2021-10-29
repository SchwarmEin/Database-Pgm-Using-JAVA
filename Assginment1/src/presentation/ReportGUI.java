package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.JButton;

import data.TextFileIO;

import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ReportGUI extends JFrame {

	private JPanel contentPane;
	public static JDateChooser DateInput;
	public static JTextField txtFilterInput;
	public static JComboBox<Object> comboBoxFilterChoice;

	/**
	 * Create the frame.
	 */
	public ReportGUI() {
		setTitle("New Report");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelectionFilter = new JLabel("Select Filter:");
		lblSelectionFilter.setBounds(10, 8, 77, 36);
		contentPane.setLayout(null);
		contentPane.add(lblSelectionFilter);
		
		txtFilterInput = new JTextField();
		txtFilterInput.setEditable(false);
		txtFilterInput.setHorizontalAlignment(SwingConstants.CENTER);
		txtFilterInput.setColumns(10);
		txtFilterInput.setBounds(103, 52, 303, 36);
		contentPane.add(txtFilterInput);
		
		JLabel lblSeachFilter = new JLabel("Search:");
		lblSeachFilter.setBounds(10, 52, 82, 36);
		contentPane.add(lblSeachFilter);

		DateInput = new JDateChooser();
		DateInput.setBounds(103, 52, 303, 36);
		DateInput.setDateFormatString("MM/dd/yyyy");
		DateInput.setVisible(false);
		contentPane.add(DateInput);
		
		SimpleDateFormat datefrm = new SimpleDateFormat("MM/dd/yyyy");
		
		comboBoxFilterChoice = new JComboBox<Object>();
		comboBoxFilterChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filter = (String) comboBoxFilterChoice.getSelectedItem();
				
				if (filter.equals("All")) {
					/*
					 *  if user selects all:
					 *  	- turn off the date picker
					 *  	- text field should be visible, but not editable
					 *  	- clear the text in the text field
					 */	
					
					DateInput.setVisible(false);
					txtFilterInput.setVisible(true);
					txtFilterInput.setEditable(false);
					txtFilterInput.setText("");
					
				} else if (filter.equals("City")) {
					/*
					 *  if user selects city:
					 *  	- turn off the date picker
					 *  	- text field should be visible and editable
					 *  	- clear the text in the text field
					 */	
					
					DateInput.setVisible(false);
					txtFilterInput.setVisible(true);
					txtFilterInput.setEditable(true);
					txtFilterInput.setText("");
					
				} else if(filter.equals("Date")) {
					/*
					 *  if user selects city:
					 *  	- turn on the date picker
					 *  	- text field should not be visible and editable
					 *  	- clear the date in the date picker
					 */	
					
					DateInput.setVisible(true);
					txtFilterInput.setVisible(false);
					txtFilterInput.setEditable(false);
					DateInput.setDate(null);
				
					
				}
				
			}
				
		});
		comboBoxFilterChoice.setEditable(true);
		comboBoxFilterChoice.setModel(new DefaultComboBoxModel<Object>(new String[] {"All", "City", "Date"}));
		comboBoxFilterChoice.setBounds(104, 15, 302, 22);
		contentPane.add(comboBoxFilterChoice);
		
		JButton btnRunReport = new JButton("Run Report");
		btnRunReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String filter = (String) comboBoxFilterChoice.getSelectedItem();
				String[][] report = {};
				
				try {
								
					// call data layer to get the reports
					if(filter.equals("All")) {
						 report = TextFileIO.readDataAll(ReportGUI.txtFilterInput.getText());
						 
					} else if (filter.equals("Date") && Validator.checkDate(DateInput, "Date")) {
						String date = datefrm.format(ReportGUI.DateInput.getDate()).toString();
						report =  TextFileIO.readDataByDate(date);
						
					} else if (filter.equals("City") && Validator.checkCity(txtFilterInput, "City")) {
						report = TextFileIO.readDataByCity(ReportGUI.txtFilterInput.getText());
						
					}
					
					// present the report to the user if any
					if (report.length == 1) {
						// only the total row is available, report is empty
						JOptionPane.showMessageDialog(null, "No results found.");
					} else if (report.length > 1) {
						// values found, show the report
						new PreviewGUI(report);
						
					}
					
					// else do not do anything, user ran into a validation error
					
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "Error !" + e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE );
				}
				
			}
		});
		
		btnRunReport.setBounds(158, 99, 103, 36);
		contentPane.add(btnRunReport);
	}
}
