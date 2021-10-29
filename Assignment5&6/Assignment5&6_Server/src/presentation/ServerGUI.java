package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

import javax.swing.JButton;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
	
public class ServerGUI extends JFrame {
	
		private JPanel contentPane;
		
		private Thread t;
		private ServerMain ss;
		public static JTextArea textArea;
		
		public ServerGUI(){
			setTitle("DB Server Application");
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 700, 320);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 10, 674, 226);
			contentPane.add(scrollPane);
			
			textArea = new JTextArea();
			textArea.setEditable(false);
			scrollPane.setViewportView(textArea);
			
			JButton btnSTART = new JButton("START");
			btnSTART.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// if server is already up, don't try to start again
					if (ss != null) {
						textArea.setText(textArea.getText() + "\nWARN: Server is already running.");
						return;
					}
					
					ss = new ServerMain();
					t = new Thread(ss);
					t.start();
				}
			});
			btnSTART.setFont(new Font("Calibri", Font.BOLD, 16));
			btnSTART.setBounds(100, 250, 100, 30);
			contentPane.add(btnSTART);
			
			JButton btnSTOP = new JButton("STOP");
			btnSTOP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// if server is not running, dont try to stop, there's nothing to stop
					if (ss == null) {
						textArea.setText(textArea.getText() + "\nWARN: Server is not running.");
						return;
					}
					
					// stop the server, then set to null to reset
					ss.stop();
					ss=null;

					textArea.setText(textArea.getText() + "\nINFO: Server has been stopped.");	
				}
			});
			btnSTOP.setFont(new Font("Calibri", Font.BOLD, 16));
			btnSTOP.setBounds(500, 250, 100, 30);
			contentPane.add(btnSTOP);		
		}
}