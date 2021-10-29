import java.io.*;
import java.net.*;

public class ServerMain {

	public static void main(String[] args) {
		int port = 8100;
		ServerSocket server = null;
		Socket socket = null;
		DataInputStream dIN = null;
		DataOutputStream dOut = null;
		
		try {
			server = new ServerSocket(port);
			System.out.println("Server is running and waiting for client...");
			while(true) {
								
				socket = server.accept();
				System.out.println("\nServer Accepted...");
				System.out.println(socket);
				
				dIN = new DataInputStream(socket.getInputStream());
				dOut = new DataOutputStream(socket.getOutputStream());
				
				Thread thread = new ServerThread(socket, dIN, dOut);
				
				thread.start();
				System.out.println("New Thread Started ID " + Long.toString(thread.getId()) + "...");

				
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
}
