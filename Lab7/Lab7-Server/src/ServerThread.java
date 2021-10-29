import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread extends Thread{

	Socket socket;
	DataInputStream dIn;
	DataOutputStream dOut;

	public ServerThread(Socket s, DataInputStream dIn, DataOutputStream dOut) {
	
		this.socket = s;
		this.dIn = dIn;
		this.dOut = dOut;
	}
	
	public void run() {
		try {
			InetAddress cAddress = socket.getInetAddress();
			System.out.println("Host Name: " + cAddress.getHostName());
			System.out.println("Host Address: " + cAddress.getHostAddress());
			
			Date dNow;
			char choice;
			SimpleDateFormat fDate;
			do{
				choice = dIn.readChar();
				switch(choice) {
					case 'd':
					case 'D':
						dNow = new Date();
						fDate = new SimpleDateFormat("yyyy.MM.dd");
						dOut.writeUTF("System Date: " + fDate.format(dNow));
						break;
					case 't':
					case 'T':
						dNow = new Date();
						fDate = new SimpleDateFormat("hh:mm:ss a");
						dOut.writeUTF("System Time: " + fDate.format(dNow));
						break;
					case 'x':
					case 'X':
						dOut.writeUTF("Good Bye");
						break;
					default:
						dOut.writeUTF("Invalid Choice --> " + choice);
						break;
				}
			} while(Character.toUpperCase(choice) != 'X');
			
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
