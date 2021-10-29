package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Person;
import data.RandomIO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RecordGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRecordNumber;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldAge;
	private JTextField textFieldPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordGUI frame = new RecordGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RecordGUI() {
		setTitle("Random File Processor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecordNumber = new JLabel("Record #");
		lblRecordNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRecordNumber.setBounds(85, 61, 108, 14);
		contentPane.add(lblRecordNumber);
		
		textFieldRecordNumber = new JTextField();
		textFieldRecordNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldRecordNumber.setBounds(236, 52, 266, 32);
		contentPane.add(textFieldRecordNumber);
		textFieldRecordNumber.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(85, 102, 108, 14);
		contentPane.add(lblFirstName);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldFirstName.setColumns(10);
		textFieldFirstName.setBounds(236, 93, 266, 32);
		contentPane.add(textFieldFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(85, 143, 121, 14);
		contentPane.add(lblLastName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(236, 134, 266, 32);
		contentPane.add(textFieldLastName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAge.setBounds(85, 181, 71, 20);
		contentPane.add(lblAge);
		
		textFieldAge = new JTextField();
		textFieldAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldAge.setColumns(10);
		textFieldAge.setBounds(236, 175, 266, 32);
		contentPane.add(textFieldAge);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhone.setBounds(85, 227, 71, 14);
		contentPane.add(lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(236, 218, 266, 32);
		contentPane.add(textFieldPhone);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Person person = new Person();
					person.setFirstName(textFieldFirstName.getText());
					person.setLastName(textFieldLastName.getText());
					person.setAge(Integer.parseInt(textFieldAge.getText()));
					person.setPhone(textFieldPhone.getText());
				
					
					try {
						RandomIO.writePerson(person);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					
					// reset the fields
					textFieldRecordNumber.setText("");
					textFieldFirstName.setText("");
					textFieldLastName.setText("");
					textFieldPhone.setText("");
					textFieldAge.setText("");
				}
				
			
		});
		btnAdd.setBounds(126, 273, 121, 40);
		contentPane.add(btnAdd);
		
		JButton btnFind = new JButton("Find");
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if (Integer.parseInt(textFieldRecordNumber.getText()) < 1) {
						JOptionPane.showMessageDialog(null, "Invalid record number.");
						
					} else {

						Person person = RandomIO.findRecordNumber(Integer.parseInt(textFieldRecordNumber.getText()));
						
						textFieldFirstName.setText(person.getFirstName().trim());
						textFieldLastName.setText(person.getLastName().trim());
						textFieldPhone.setText(person.getPhone().trim());
						textFieldAge.setText(String.valueOf(person.getAge()));
						
					}
					
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					
					JOptionPane.showMessageDialog(null, 
							"Invalid Record Number"
							
						);
				}
				
			}
		});
		btnFind.setBounds(298, 273, 108, 40);
		contentPane.add(btnFind);
	}
}
