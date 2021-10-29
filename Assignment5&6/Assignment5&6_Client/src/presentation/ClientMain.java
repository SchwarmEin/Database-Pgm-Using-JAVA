package presentation;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import business.Customers;



public class ClientMain implements Runnable {
	
	int port = 8102;
	String host = "localhost";
	DataInputStream dIn = null;
	DataOutputStream dOut = null;
	Socket socket = null;
	
	boolean stop = false;
	
	public ClientMain() {

	}

	@Override
	public void run() {		
		try {
			socket = new Socket(host, port);
			dIn = new DataInputStream(socket.getInputStream());
			dOut = new DataOutputStream(socket.getOutputStream());
			
			writeToGUI("INFO: Successfully connected to server.");
			
			// update the buttons on the GUI
			this.enableButtons();
			
			while (true) {
				char serverResponse = dIn.readChar();
				
				switch(serverResponse) {
					case 'a':
						writeToGUI(dIn.readUTF());
						break;
					case 'f':
						writeToGUI(dIn.readUTF());
						break;
					case 'u':
						writeToGUI(dIn.readUTF());
						break;
					case 'x':
						// this only happens when server closes connections
						this.disableButtons();
						writeToGUI(dIn.readUTF());
						break;
					default:
						// don't do anything
						break;
				}
				 
			}			
		} catch (ConnectException e) {
			
			writeToGUI("ERROR: Server is not running.");
			return;
			
		} catch (EOFException e) {	
			// do nothing
			// server closed the connection
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		// once outside the loop, close the socket
		try {
			socket.close();
		} catch (IOException e) {	
			e.printStackTrace();
		}
		
	}
	
	public void add(Customers c) {
		try {
			
			writeToGUI("INFO: Add operation request sent. ");
			
			dOut.writeChar('a');
			dOut.writeUTF(c.getCust_fname());
			dOut.writeUTF(c.getCust_lname());
			dOut.writeUTF(c.getStreet());
			dOut.writeUTF(c.getCity());
			dOut.writeUTF(c.getProvince());
			dOut.writeUTF(c.getPostal_code());
			dOut.writeUTF(c.getPhone());
			dOut.writeUTF(c.getEmail());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void find(Customers c) {
		try {
			writeToGUI("INFO: Find operation request sent. ");
			
			dOut.writeChar('f');
			dOut.writeUTF(c.getCust_fname());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Customers c) {
		try {
			
			writeToGUI("INFO: Update operation request sent. ");
			
			dOut.writeChar('u');
			dOut.writeInt(c.getCust_id());
			dOut.writeUTF(c.getCust_fname());
			dOut.writeUTF(c.getCust_lname());
			dOut.writeUTF(c.getStreet());
			dOut.writeUTF(c.getCity());
			dOut.writeUTF(c.getProvince());
			dOut.writeUTF(c.getPostal_code());
			dOut.writeUTF(c.getPhone());
			dOut.writeUTF(c.getEmail());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		stop = true;
		try {
			// inform the server to disconnect this client
			dOut.writeChar('e');		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void writeToGUI(String msg) {
		ClientGUI.textArea.setText(
				ClientGUI.textArea.getText()
				+ "\n"
				+ msg
				);
	}
	
	private void enableButtons() {
		ClientGUI.btnConnect.setEnabled(false);
		ClientGUI.btnAdd.setEnabled(true);
		ClientGUI.btnFind.setEnabled(true);
		ClientGUI.btnUpdate.setEnabled(true);
		ClientGUI.btnExit.setEnabled(true);
	}
	
	private void disableButtons() {
		ClientGUI.btnConnect.setEnabled(true);
		ClientGUI.btnAdd.setEnabled(false);
		ClientGUI.btnFind.setEnabled(false);
		ClientGUI.btnUpdate.setEnabled(false);
		ClientGUI.btnExit.setEnabled(false);
	}

}
