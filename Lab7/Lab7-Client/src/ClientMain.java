import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) {
		int port = 8100;
		String host = "localhost";
		DataInputStream dIN = null;
		DataOutputStream dOut = null;
		
		Socket socket = null;
		
		try {
			socket = new Socket(host,port);
			dIN = new DataInputStream(socket.getInputStream());
			dOut = new DataOutputStream(socket.getOutputStream());
			
			Scanner scanner = new Scanner(System.in);
			char choice;
			do {
				System.out.print("Enter your choice (d - data) :");
				choice = scanner.nextLine().charAt(0);
				dOut.writeChar(choice);
				String result = dIN.readUTF();
				System.out.println(result);
			}while(Character.toUpperCase(choice) != 'X');
			scanner.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}