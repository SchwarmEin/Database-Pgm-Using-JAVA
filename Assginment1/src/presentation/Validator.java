package presentation;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

public class Validator {
	
	/* *
	 * verifies if date input has valid
	 * */
	public static boolean checkDate(JDateChooser dateInput, String title) {
		// empty entry
		if (dateInput.getDate() == null) {
			JOptionPane.showMessageDialog(dateInput, title + " is a required field.\nPlease re-enter.");
			return false;	
		}
		return true;
	}
	
	public static boolean checkCity(JTextComponent c, String title) {		
		if (c.getText().length() == 0) {			
			JOptionPane.showMessageDialog(c, title + " is a required field.\nPlease re-enter.");
			c.requestFocusInWindow();
			return false;				
		}
		if ((Pattern.matches("[a-zA-Z\s.]+", c.getText())) == false) {
			JOptionPane.showMessageDialog(c, title + " is an invalid city name.\nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		else if((Pattern.matches("[A-Z]+", c.getText().substring(0,1))) == false){
			JOptionPane.showMessageDialog(c, title + " first letter should be a capital letter.\nPlease re-enter.");
			c.requestFocusInWindow();
			return false;
		}
		else 
			return true;
	}
}
