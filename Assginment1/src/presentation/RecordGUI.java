package presentation;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;


import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import business.CovidStats;
import data.TextFileIO;

public class RecordGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnSave;
	private JDateChooser DateInput;
	private JTextField txtCityInput;
	private JSpinner txtCasesInput;
	private JSpinner txtDeathsInput;
	private JSpinner txtRecoveredInput;
	
	/**
	 * Create the frame.
	 */
	public RecordGUI() {
		setResizable(false);
		setTitle("COVID19 New Record Entry");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbldate = new JLabel("Date:");
		lbldate.setFont(new Font("Calibri", Font.PLAIN, 14));
		lbldate.setBounds(10, 27, 197, 36);
		lbldate.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lbldate);

		DateInput = new JDateChooser();
		DateInput.setBounds(207, 27, 197, 36);
		DateInput.setDateFormatString("MM/dd/yyyy");
		contentPane.add(DateInput);
			
		SimpleDateFormat datefrm = new SimpleDateFormat("MM/dd/yyyy");
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCity.setBounds(10, 63, 197, 36);
		contentPane.add(lblCity);
		
		txtCityInput = new JTextField();
		txtCityInput.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtCityInput.setBounds(207, 63, 197, 36);
		txtCityInput.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(txtCityInput);
		
		JLabel lblCases = new JLabel("Number of Cases:");
		lblCases.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblCases.setBounds(10, 99, 197, 36);
		contentPane.add(lblCases);
		
		JLabel lblDeaths = new JLabel("Number of Deaths:");
		lblDeaths.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblDeaths.setBounds(10, 135, 197, 36);
		contentPane.add(lblDeaths);
		
		JLabel lblRecovered = new JLabel("Number of Cases Recovered:");
		lblRecovered.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblRecovered.setBounds(10, 171, 197, 36);
		contentPane.add(lblRecovered);
		
		txtCasesInput = new JSpinner();
		txtCasesInput.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtCasesInput.setModel(new SpinnerNumberModel(0, 0, null, 1));
		txtCasesInput.setBounds(207, 99, 197, 36);
		contentPane.add(txtCasesInput);
		
		txtDeathsInput = new JSpinner();
		txtDeathsInput.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtDeathsInput.setModel(new SpinnerNumberModel(0, 0, null, 1));
		txtDeathsInput.setBounds(207, 135, 197, 36);
		contentPane.add(txtDeathsInput);
		
		txtRecoveredInput = new JSpinner();
		txtRecoveredInput.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtRecoveredInput.setModel(new SpinnerNumberModel(0, 0, null, 1));
		txtRecoveredInput.setBounds(207, 171, 197, 36);
		contentPane.add(txtRecoveredInput);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//  Validate and save the data input	
				if ((Validator.checkDate(DateInput, "Date")) && 
						(Validator.checkCity(txtCityInput, "City"))){
				
					String date = datefrm.format(DateInput.getDate()).toString();
					String city = txtCityInput.getText();
					String cases = txtCasesInput.getValue().toString();
					String death = txtDeathsInput.getValue().toString();
					String recover = txtRecoveredInput.getValue().toString();
					
					try {
						
						CovidStats covid = new CovidStats();
						covid.setDate(date);
						covid.setCity(city);
						covid.setNumCase(cases);
						covid.setNumDeath(death);
						covid.setNumRec(recover);
						
						TextFileIO.writeData(covid);
						JOptionPane.showMessageDialog(null, "Data has been saved.");		  
					} 
					catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error !" + e1.getMessage(), "ERROR" ,JOptionPane.ERROR_MESSAGE );
					}	
				}
			}
		});
		
		btnSave.setBounds(156, 218, 100, 36);
		contentPane.add(btnSave);
		

	}
}
