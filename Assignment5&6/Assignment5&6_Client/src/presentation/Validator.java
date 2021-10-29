package presentation;

import javax.swing.JOptionPane;


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
	

	public static boolean isInt(String input) {
		try {
			Integer.parseInt(input);	
			return true;
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Customer ID needs to be a number.");
			return false;
		}
	}
	
	
	
	// verify input is within text count
	public static boolean hasValidTextCount(String input, String label) {
		
		boolean valid = false;
		int expectedLength = 0;
		
		switch(label) {
			case "First Name":
				valid = input.length() > 30 ? false : true;
				expectedLength = 30;
				break;
			case "Last Name":
				valid = input.length() > 30 ? false : true;
				expectedLength = 30;
				break;
			case "Phone":
				valid = input.length() != 10 ? false : true;
				expectedLength = 10;
				break;
			case "E-mail":
				valid = input.length() > 30 ? false : true;
				expectedLength = 30;
				break;
			case "Address":
				valid = input.length() > 50 ? false : true;
				expectedLength = 50;
				break;
			case "City":
				valid = input.length() > 30 ? false : true;
				expectedLength = 30;
				break;
			case "Postal Code":
				valid = input.length() != 6 ? false : true;
				expectedLength = 6;
				break;
		}
		
		if (!valid) {
			JOptionPane.showMessageDialog(null,
					"Invalid number of characters for " + label);
			
		}
		
		return valid;
		
	}
	
	// verify phone only has numbers
	public static boolean hasValidPhoneFormat(String input) {
		
		if (input.matches("[0-9]+")) {

			return true;
		}
		
		
		JOptionPane.showMessageDialog(null,
				"Invalid phone format."
				+ "\nInput should only contain numbers."
				);
		return false;
		
	}
	
	// verify postal code is in the A1A1A1 format
	public static boolean hasValidPostalFormat(String input) {

		if (input.toLowerCase().matches("([a-z][0-9]){3}")) {
			
			return true;
		}
		
		JOptionPane.showMessageDialog(null,
				"Invalid postal code format."
				+ "\nSample format: A1A1A1."
				);
		return false;
		
	}
	
	// verify email is in the abd@email.com format
	public static boolean hasValidEmailFormat(String input) {
		// regex source: https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		if (input.toLowerCase().matches(regex)) {
			
			return true;
		}
		
		JOptionPane.showMessageDialog(null,
				"Invalid email format."
				+ "\nSample format: user@domain.com"
				);
		
		return false;
	}
	
	// helper methods for messages
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
		} else if (operation.equals("find")) {
			msg += "First Name";
		}	
		return msg;
	}
	
}