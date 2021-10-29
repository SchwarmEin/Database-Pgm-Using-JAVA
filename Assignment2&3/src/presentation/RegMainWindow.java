package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Student;
import data.BinaryIO;
import data.RandomIO;
import data.TextFileIO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class RegMainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudentID;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ArrayList<JCheckBox> chckbxList = new ArrayList<JCheckBox>();

	/**
	 * Create the frame.
	 */
	public RegMainWindow() {
		setTitle("Student Course Registration");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentID = new JLabel("Student ID");
		lblStudentID.setFont(new Font("Calibri", Font.BOLD, 16));
		lblStudentID.setBounds(25, 50, 130, 60);
		contentPane.add(lblStudentID);
		
		JLabel lblProgram = new JLabel("Program");
		lblProgram.setFont(new Font("Calibri", Font.BOLD, 16));
		lblProgram.setBounds(25, 110, 130, 60);
		contentPane.add(lblProgram);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Calibri", Font.BOLD, 16));
		lblSemester.setBounds(25, 170, 130, 60);
		contentPane.add(lblSemester);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Calibri", Font.BOLD, 16));
		lblCourse.setBounds(25, 230, 130, 60);
		contentPane.add(lblCourse);
		
		txtStudentID = new JTextField();
		txtStudentID.setFont(new Font("Calibri", Font.BOLD, 16));
		txtStudentID.setBounds(165, 60, 280, 40);
		contentPane.add(txtStudentID);
		txtStudentID.setColumns(10);
		
		JComboBox<Object> cboxProgram = new JComboBox<Object>();
		
		cboxProgram.setEditable(true);
		cboxProgram.setFont(new Font("Calibri", Font.BOLD, 16));
		cboxProgram.setBounds(165, 120, 280, 40);
		contentPane.add(cboxProgram);
		
		JRadioButton rdbtnSemester1 = new JRadioButton("1");
		rdbtnSemester1.setSelected(true);
		rdbtnSemester1.setActionCommand("1");
		buttonGroup.add(rdbtnSemester1);
		rdbtnSemester1.setFont(new Font("Calibri", Font.BOLD, 16));
		rdbtnSemester1.setBounds(165, 185, 60, 30);
		contentPane.add(rdbtnSemester1);
		
		JRadioButton rdbtnSemester2 = new JRadioButton("2");
		rdbtnSemester2.setActionCommand("2");
		buttonGroup.add(rdbtnSemester2);
		rdbtnSemester2.setFont(new Font("Calibri", Font.BOLD, 16));
		rdbtnSemester2.setBounds(225, 185, 60, 30);
		contentPane.add(rdbtnSemester2);
		
		JRadioButton rdbtnSemester3 = new JRadioButton("3");
		rdbtnSemester3.setActionCommand("3");
		buttonGroup.add(rdbtnSemester3);
		rdbtnSemester3.setFont(new Font("Calibri", Font.BOLD, 16));
		rdbtnSemester3.setBounds(285, 185, 60, 30);
		contentPane.add(rdbtnSemester3);
		
		JRadioButton rdbtnSemester4 = new JRadioButton("4");
		rdbtnSemester4.setActionCommand("4");
		buttonGroup.add(rdbtnSemester4);
		rdbtnSemester4.setFont(new Font("Calibri", Font.BOLD, 16));
		rdbtnSemester4.setBounds(345, 185, 60, 30);
		contentPane.add(rdbtnSemester4);
		
		JCheckBox chckbxCourse1 = new JCheckBox("C1");
		chckbxCourse1.setFont(new Font("Calibri", Font.BOLD, 16));
		chckbxCourse1.setBounds(165, 245, 60, 30);
		contentPane.add(chckbxCourse1);
		
		JCheckBox chckbxCourse2 = new JCheckBox("C2");
		chckbxCourse2.setFont(new Font("Calibri", Font.BOLD, 16));
		chckbxCourse2.setBounds(225, 245, 60, 30);
		contentPane.add(chckbxCourse2);
		
		JCheckBox chckbxCourse3 = new JCheckBox("C3");
		chckbxCourse3.setFont(new Font("Calibri", Font.BOLD, 16));
		chckbxCourse3.setBounds(285, 245, 60, 30);
		contentPane.add(chckbxCourse3);
		
		JCheckBox chckbxCourse4 = new JCheckBox("C4");
		chckbxCourse4.setFont(new Font("Calibri", Font.BOLD, 16));
		chckbxCourse4.setBounds(345, 245, 60, 30);
		contentPane.add(chckbxCourse4);
		
		JCheckBox chckbxCourse5 = new JCheckBox("C5");
		chckbxCourse5.setFont(new Font("Calibri", Font.BOLD, 16));
		chckbxCourse5.setBounds(405, 245, 60, 30);
		contentPane.add(chckbxCourse5);
		
		chckbxList.add(chckbxCourse1);
		chckbxList.add(chckbxCourse2);
		chckbxList.add(chckbxCourse3);
		chckbxList.add(chckbxCourse4);
		chckbxList.add(chckbxCourse5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(475, 50, 393, 225);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get student id
								
				try {
					int stID = RandomIO.getNumRecords() + 1;
					
					//get the program
					String program = (String) cboxProgram.getSelectedItem();
					
					//check the selected program, if ALL, don't save, notify user to select another 
					if (!Validator.isValidProgramSelection(program)) {
						return;
					}
					
					// get courses
					ArrayList<String> courses =  new ArrayList<String>();
					for (JCheckBox chckbx : chckbxList) {
						
						if (chckbx.isSelected()) {
							courses.add(chckbx.getText());
						}
					}
					
					// get semester
					int semester = Integer.parseInt(buttonGroup.getSelection().getActionCommand());
					
					Student student = new Student(stID, program, String.join(",", courses), semester);
					
					BinaryIO.writeStudent(student);
					
					// after each save:
					//	show the new student id on the frame
					//	show saved student to text area
					txtStudentID.setText(String.valueOf(stID));
					textArea.setText(student.toString());
					
					JOptionPane.showMessageDialog(null, "Data has been saved.");
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Data was not saved\nPlease try again.");
					
				}
				
			}
		});
		btnSave.setFont(new Font("Calibri", Font.BOLD, 16));
		btnSave.setBounds(265, 300, 100, 30);
		contentPane.add(btnSave);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// read input based on program selection
				try {
					String program = cboxProgram.getSelectedItem().toString();
					if (program.contains("ALL")) {
						ArrayList<Student> allstudentList = BinaryIO.readALLStudents();
						String allstudentDisplay = ""; 
						for (Student student : allstudentList) {
							allstudentDisplay += student.toString() + "\n";
						}		
						textArea.setText(allstudentDisplay);	
					}
					else {
						ArrayList<Student> studentList = BinaryIO.readStudents((String) cboxProgram.getSelectedItem());			
						String studentDisplay = ""; 
						for (Student student : studentList) {
							studentDisplay += student.toString() + "\n";
						}	
						textArea.setText(studentDisplay);	
					}
			
					// reset form
					txtStudentID.setText("");
					buttonGroup.clearSelection();
					rdbtnSemester1.setSelected(true);
					
					for (JCheckBox chckbx : chckbxList) {
						chckbx.setSelected(false);
					}
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "No records to show.");
				}
			}
		});
		btnDisplay.setFont(new Font("Calibri", Font.BOLD, 16));
		btnDisplay.setBounds(375, 300, 100, 30);
		contentPane.add(btnDisplay);
		
		JButton btnEXIT = new JButton("EXIT");
		btnEXIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEXIT.setFont(new Font("Calibri", Font.BOLD, 16));
		btnEXIT.setBounds(485, 300, 100, 30);
		contentPane.add(btnEXIT);
		
		JButton btnFirst = new JButton("FIRST");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student student = RandomIO.findFirst();
					
					// set the student id
					txtStudentID.setText(String.valueOf(student.getStID()));
					
					// set the program
					cboxProgram.setSelectedItem(student.getProgram());
					
					// set the semester
					if (student.getSemester() == 1)	
						rdbtnSemester1.setSelected(true);
					else if (student.getSemester() == 2)	
						rdbtnSemester2.setSelected(true);
					else if (student.getSemester() == 3)	
						rdbtnSemester3.setSelected(true);
					else if (student.getSemester() == 4)	
						rdbtnSemester4.setSelected(true);
					
					// clear and set the courses
					for (JCheckBox chckbx : chckbxList) {
						if (chckbx.isSelected()) {
							chckbx.setSelected(false);
						}
					}
					for (JCheckBox chckbx : chckbxList) {
						if (student.getCourse().contains(chckbx.getText())) {
							chckbx.setSelected(true);
						}
					}
					
					// display the first record into text area
					textArea.setText(student.toString());
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "No records to show.");
				}
			}
		});
		btnFirst.setFont(new Font("Calibri", Font.BOLD, 15));
		btnFirst.setBounds(165, 10, 100, 25);
		contentPane.add(btnFirst);
		
		JButton btnPervious = new JButton("PREVIOUS");
		btnPervious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (Validator.isEmptyStudentID(txtStudentID.getText())) 
						 return;
					
					int stID = Integer.parseInt(txtStudentID.getText());
					Student student = RandomIO.findPerviousRec(stID);
					
					// set the student id
					txtStudentID.setText(String.valueOf(student.getStID()));
					
					// set the program
					cboxProgram.setSelectedItem(student.getProgram());
					
					// set the semester
					if (student.getSemester() == 1)	
						rdbtnSemester1.setSelected(true);
					else if (student.getSemester() == 2)	
						rdbtnSemester2.setSelected(true);
					else if (student.getSemester() == 3)	
						rdbtnSemester3.setSelected(true);
					else if (student.getSemester() == 4)	
						rdbtnSemester4.setSelected(true);
					
					// clear and set the courses
					for (JCheckBox chckbx : chckbxList) {
						if (chckbx.isSelected()) {
							chckbx.setSelected(false);
						}
					}
					for (JCheckBox chckbx : chckbxList) {
						if (student.getCourse().contains(chckbx.getText())) {
							chckbx.setSelected(true);
						}
					}
					
					// display the first record into text area
					textArea.setText(student.toString());
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "No records to show.");
				}
			}	
		});
		btnPervious.setFont(new Font("Calibri", Font.BOLD, 15));
		btnPervious.setBounds(295, 10, 100, 25);
		contentPane.add(btnPervious);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (Validator.isEmptyStudentID(txtStudentID.getText())) 
						 return;
					
					int stID = Integer.parseInt(txtStudentID.getText());
					Student student = RandomIO.findNextRec(stID);
					
					// set the student id
					txtStudentID.setText(String.valueOf(student.getStID()));
					
					// set the program
					cboxProgram.setSelectedItem(student.getProgram());
					
					// set the semester
					if (student.getSemester() == 1)	
						rdbtnSemester1.setSelected(true);
					else if (student.getSemester() == 2)	
						rdbtnSemester2.setSelected(true);
					else if (student.getSemester() == 3)	
						rdbtnSemester3.setSelected(true);
					else if (student.getSemester() == 4)	
						rdbtnSemester4.setSelected(true);
					
					// clear and set the courses
					for (JCheckBox chckbx : chckbxList) {
						if (chckbx.isSelected()) {
							chckbx.setSelected(false);
						}
					}
					for (JCheckBox chckbx : chckbxList) {
						if (student.getCourse().contains(chckbx.getText())) {
							chckbx.setSelected(true);
						}
					}
					
					// display the first record into text area
					textArea.setText(student.toString());
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "No records to show.");
					
				}
			}
		});
		btnNext.setFont(new Font("Calibri", Font.BOLD, 15));
		btnNext.setBounds(425, 10, 100, 25);
		contentPane.add(btnNext);
		
		JButton btnLast = new JButton("LAST");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Student student = RandomIO.findLast();
					// set the student id
					txtStudentID.setText(String.valueOf(student.getStID()));
					
					// set the program
					cboxProgram.setSelectedItem(student.getProgram());
					
					// set the semester
					if (student.getSemester() == 1)	
						rdbtnSemester1.setSelected(true);
					else if (student.getSemester() == 2)	
						rdbtnSemester2.setSelected(true);
					else if (student.getSemester() == 3)	
						rdbtnSemester3.setSelected(true);
					else if (student.getSemester() == 4)	
						rdbtnSemester4.setSelected(true);
					
					// clear and set the courses
					for (JCheckBox chckbx : chckbxList) {	
						if (chckbx.isSelected()) {
							chckbx.setSelected(false);
						}
					}
					for (JCheckBox chckbx : chckbxList) {	
						if (student.getCourse().contains(chckbx.getText())) {
							chckbx.setSelected(true);
						}
					}
					
					// display the first record into text area
					textArea.setText(student.toString());
					
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "No records to show.");
				}
			}
		});
		btnLast.setFont(new Font("Calibri", Font.BOLD, 15));
		btnLast.setBounds(555, 10, 100, 25);
		contentPane.add(btnLast);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (Validator.isEmptyStudentID(txtStudentID.getText())
						|| !Validator.isNumStudentID(txtStudentID.getText()))
					return;
				
				int stID = Integer.parseInt(txtStudentID.getText());
				
				//get the program
				String program = (String) cboxProgram.getSelectedItem();
				
				//check the selected program, if ALL, don't save, notify user to select another 
				if (!Validator.isValidProgramSelection(program)) {
					return;
				}
				
				// get courses
				ArrayList<String> courses =  new ArrayList<String>();
				for (JCheckBox chckbx : chckbxList) {
					
					if (chckbx.isSelected()) {
						courses.add(chckbx.getText());
					}
				}
				
				// get semester
				int semester = Integer.parseInt(buttonGroup.getSelection().getActionCommand());
				
				Student update_rec = new Student(stID, program, String.join(",", courses), semester);
				
				try {
					RandomIO.updateRec(update_rec);
					JOptionPane.showMessageDialog(null, "Data has been updated.");
					
					// after each update:
					//	show the new student id on the frame
					//	show saved student to text area
					textArea.setText(update_rec.toString());
					
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "Student ID " + stID + " does not exist.");
				
				}
				
			}
		});
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 15));
		btnUpdate.setBounds(685, 10, 100, 25);
		contentPane.add(btnUpdate);
		
		
		// populate the student id field (id is automated) and combo-box
		try {					
			// Read and load the items from ProgramList.txt
			String[] programList = TextFileIO.readProgramList();
			cboxProgram.setModel(new DefaultComboBoxModel<Object>(programList));
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
}