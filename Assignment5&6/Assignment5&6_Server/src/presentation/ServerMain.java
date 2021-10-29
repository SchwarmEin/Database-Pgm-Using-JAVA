package presentation;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ServerMain implements Runnable{
	public static int port = 8102;
	private boolean stop = false;
	private ServerSocket server;
	
	ArrayList<ClientHandler> clientList = new ArrayList<ClientHandler>(); 
	
	public ServerMain() {
		
	}
		
	public void run() {	
		try {
			server = new ServerSocket(port);
			ServerGUI.textArea.setText(
					ServerGUI.textArea.getText()
					+ "\nINFO: Server is running and waiting for client."
					);
			
			while(!stop) {
				
				Socket socket = server.accept();
				
				ClientHandler sm = new ClientHandler(socket);
				clientList.add(sm);
				
				Thread th = new Thread(sm);
				th.start();
				
				ServerGUI.textArea.setText(
						ServerGUI.textArea.getText()
						+ "\nINFO: A client connected.");
				
			}
			
			
			
		} catch (SocketException e) {
			// do nothing, it's from stopping the server
			// see stop method below
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {	
		this.stop = true;
		try {
			// disconnect all the clients
			for(ClientHandler c : clientList) {
				c.closeFromServer();
			}
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
