package presentation;

import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Customers;
import data.DataIO_Cust;


public class ClientHandler implements Runnable{
	private Socket clientsocket;
	private DataOutputStream dOut;
	private DataInputStream dIn;

	public ClientHandler(Socket socket) throws IOException {
		super();
		this.clientsocket = socket;
		dOut = new DataOutputStream(clientsocket.getOutputStream());
		dIn = new DataInputStream(clientsocket.getInputStream());
	}

	public void run() {
		
		while (!clientsocket.isClosed()) {
			try {
				char clientSelection = dIn.readChar();
				
				switch(clientSelection) {
					case 'a':
						writeToGUI("INFO: Add operation request received");
						Customers cAdd = new Customers();
						cAdd.setCust_fname(dIn.readUTF());
						cAdd.setCust_lname(dIn.readUTF());
						cAdd.setStreet(dIn.readUTF());
						cAdd.setCity(dIn.readUTF());
						cAdd.setProvince(dIn.readUTF());
						cAdd.setPostal_code(dIn.readUTF());
						cAdd.setPhone(dIn.readUTF());
						cAdd.setEmail(dIn.readUTF());
						
						(new DataIO_Cust()).insertCustomer(cAdd);
						
						writeToGUI("INFO: Add operation request done. Notifying client.");
						dOut.writeChar('a');
						dOut.writeUTF("INFO: Add operation request done.");
						
						break;
					case 'f':
						writeToGUI("INFO: Try to find the data with firstname.");
						String fname = dIn.readUTF();
						String result = "";
						ArrayList<Customers> cust;
						DataIO_Cust dbIOcust = new DataIO_Cust();
						cust = dbIOcust.getCustFname(fname);
						for (Customers cFind : cust) {
							result += cFind.toString() + "\n";
						}
						if (result == "") {
							writeToGUI("INFO: No data is found from c_customers table.");
							dOut.writeChar('f');
							dOut.writeUTF("No row has been found by using first name " + fname);
						}
						else {
							writeToGUI("INFO: Find the data from c_customers table.");
							dOut.writeChar('f');
							dOut.writeUTF("INFO: Data has been found!"+"\n" + result);
						}
						break;
					case 'u':
						writeToGUI("INFO: Update operation request received");
						writeToGUI("INFO: Check the Customer ID");
						Customers cUpdate = new Customers();
						cUpdate.setCust_id(dIn.readInt());
						cUpdate.setCust_fname(dIn.readUTF());
						cUpdate.setCust_lname(dIn.readUTF());
						cUpdate.setStreet(dIn.readUTF());
						cUpdate.setCity(dIn.readUTF());
						cUpdate.setProvince(dIn.readUTF());
						cUpdate.setPostal_code(dIn.readUTF());
						cUpdate.setPhone(dIn.readUTF());
						cUpdate.setEmail(dIn.readUTF());
						
						int rowsUpdated = (new DataIO_Cust()).updateCustomer(cUpdate);
						if (rowsUpdated == 0) {
							writeToGUI("INFO: Customer ID does not be found.");
							dOut.writeChar('u');
							dOut.writeUTF("INFO: Customer ID is not available to update.");
						}
						else {
							writeToGUI("INFO: Update operation request done. Notifying client.");
							dOut.writeChar('u');
							dOut.writeUTF("INFO: Update operation request done.");
						}
						break;
					case 'e':
						close();
						writeToGUI("INFO: A client disconnected.");
						break;
					default:
						// don't do anything
						break;
				}
						
			} catch (SocketException e) {
				// do nothing, it's from stopping the server
				
			
			} catch (IOException e) {
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void close() {
		if (clientsocket != null) {
			try {

				clientsocket.close();
				
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void closeFromServer() {
		
		if (clientsocket != null) {
			try {
				dOut.writeChar('x');
				dOut.writeUTF("INFO: Server closed the connection.");
				
				clientsocket.close();
				
			} catch (SocketException e) {
				// do nothing, it's from stopping the server
				
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void writeToGUI(String msg) {
		ServerGUI.textArea.setText(
				ServerGUI.textArea.getText()
				+ "\n"
				+ msg
				);
	}
}
