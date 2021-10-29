package presentation;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;


public class Validator {
	
	/*
	 * Returns true if one of the items in 'input' is empty
	 */
	public static boolean hasEmptyInput(String[] input, String operation ) {		
		for (String i : input) {
			if (i.isBlank()) {
				JOptionPane.showMessageDialog(null, getMissingFieldMsg(operation));
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Returns true if all of the items in 'input' is empty
	 */
	public static boolean hasEmptyInputAll(String[] input, String operation) {		
		for (String i : input) {
			if (!i.isBlank()) {
				return false;
			}
		}
		
		JOptionPane.showMessageDialog(null, getMissingFieldMsg(operation));	
		return true;
	}
	
	public static boolean isInt(String input) {
		try {
			Integer.parseInt(input);	
			return true;
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Customer ID needs to be a number.");
			return false;
			
		}
	}
	
	private static String getMissingFieldMsg(String operation) {
		String msg = "Missing fields. The following are required for " + operation + ":\n";
		
		if (operation.equals("save")) {
			msg += "First Name\n"
					+ "Last Name\n"
					+ "Phone\n"
					+ "Email\n"
					+ "Street\n"
					+ "City\n"
					+ "Postal Code";
		} else if (operation.equals("update")) {
			msg += "Customer ID\n"
					+ "First Name\n"
					+ "Last Name\n"
					+ "Phone\n"
					+ "Email\n"
					+ "Street\n"
					+ "City\n"
					+ "Postal Code";
		} else if (operation.equals("display")) {
			msg += "First Name; or\n"
					+ "Last Name; or\n"
					+ "Both";
		} 
		return msg;
	}
	
	//check the inputs of if product name and product price are empty
	public static boolean checkSaveOp(JTextComponent pName, JTextComponent pPrice) {
		if (pName.getText().isEmpty() && pPrice.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Product name and Product price are required information.\nPlease enter.");
			return false;	
		} 
		else
		return true;
	}
	
	//check the inputs if all of fields are empty expect product price
	public static boolean checkFindOp(JTextComponent pID, JTextComponent pName, JTextComponent pMIN, JTextComponent pMAX) {
		if (pID.getText().isEmpty() && pName.getText().isEmpty() && pMIN.getText().isEmpty() && pMAX.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter required information you want to find.");
			return false;	
		} 
		else
		return true;
	}
	
	//check the inputs if product id is empty
	public static boolean checkUpdateOp(JTextComponent pID) {
		if (pID.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Product id is required information.\nPlease enter.");
			return false;	
		} 
		else
		return true;
	}
	
	//check the inputs if product id is valid value
	public static boolean checkProdID(JTextComponent pID) {
		if (!Pattern.matches("\\d+", pID.getText())) {
			JOptionPane.showMessageDialog(null, "Product ID must be a number.\nPlease re-enter.");
			pID.requestFocusInWindow();
			return false;
		}else 
		return true;
	}
	
	//check the inputs if product price is valid value 
	public static boolean checkProdPrice(JTextComponent pPrice) {
		if (!Pattern.matches("\\d+", pPrice.getText())) {
			JOptionPane.showMessageDialog(null, "Product price must be a number.\nPlease re-enter.");
			pPrice.requestFocusInWindow();
			return false;
		}else 
		return true;
	}
	
	//check the inputs of product max price and min price whether missing one of them
	public static boolean checkProdPriceRange(JTextComponent pMIN, JTextComponent pMAX) {
		if (pMIN.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter minimum price you want to find.");
			return false;	
		} else if (pMAX.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter maximum price you want to find.");
			return false;
		}
		else
		return true;
	}
	
	//check the inputs of product max price and min price whether using valid values
	public static boolean checkProdMAXandMINPrice(JTextComponent pMIN, JTextComponent pMAX) {
		if ((!Pattern.matches("\\d+", pMIN.getText()))||(!Pattern.matches("\\d+", pMAX.getText()))) {
			JOptionPane.showMessageDialog(null, "Range of product price must be numbers.\nPlease re-enter.");
			return false;
		}else 
		return true;
	}	
	
}
