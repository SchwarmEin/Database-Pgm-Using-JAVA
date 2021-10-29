package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;

public class CovidAppMainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CovidAppMainWindow() {
		setResizable(false);
		setTitle("Covid Data Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenuItem mntmAddNewRcd = new JMenuItem("Add New Record");
		mntmAddNewRcd.setMnemonic(KeyEvent.VK_A);
		mntmAddNewRcd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecordGUI r = new RecordGUI();
				r.setVisible(true);
			}
		});
		mnFile.add(mntmAddNewRcd);
		
		JMenuItem mntmReport = new JMenuItem("Run Report");
		mntmReport.setMnemonic(KeyEvent.VK_R);
		mntmReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportGUI r = new ReportGUI();
				r.setVisible(true);
			}
		});
		mnFile.add(mntmReport);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setMnemonic(KeyEvent.VK_X);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPgVersion = new JLabel("Covid-19 Data Management v1.0\r\n");
		lblPgVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblPgVersion.setBounds(10, 197, 504, 31);
		contentPane.add(lblPgVersion);
		
		JLabel lblTitle = new JLabel("Covid-19 Data Management");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(10, 11, 504, 49);
		contentPane.add(lblTitle);
		
		JTextPane txtpnInstructionsTo = new JTextPane();
		txtpnInstructionsTo.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpnInstructionsTo.setBackground(Color.WHITE);
		txtpnInstructionsTo.setEditable(false);
		txtpnInstructionsTo.setText("Instructions:\r\n- "
				+ "To create or edit new reports, click on File > Add New Record\r\n- "
				+ "To generate reports, click on File > Run Report\r\n- "
				+ "To exit, click on File > Exit");
		txtpnInstructionsTo.setBounds(10, 71, 498, 93);
		contentPane.add(txtpnInstructionsTo);
	}
}
