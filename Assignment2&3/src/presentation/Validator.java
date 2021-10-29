package presentation;

import javax.swing.JOptionPane;

public class Validator {
	
	public static boolean isEmptyStudentID(String studentID)  {
		
		if (studentID.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Student ID is empty.");
			
			return true;
		}
		
		return false;
	}
	
	public static boolean isNumStudentID(String studentID) {
		
		try {
			Integer.parseInt(studentID);
			
		} catch (NumberFormatException e){
			return false;
		}
		
		return true;
	}
	
	public static boolean isValidProgramSelection(String program) {
		
		if (program.equals("ALL")) {
			JOptionPane.showMessageDialog(null, "Please select a valid program other than \"ALL\"");
			return false;
		}
		
		return true;
		
	}

}
