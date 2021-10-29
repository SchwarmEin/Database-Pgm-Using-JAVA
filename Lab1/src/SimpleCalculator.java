import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SimpleCalculator {

	private JFrame frmLabChristine;
	private JTextField textFirstField;
	private JTextField textSecondField;
	private JTextField textResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalculator window = new SimpleCalculator();
					window.frmLabChristine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimpleCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLabChristine = new JFrame();
		frmLabChristine.setResizable(false);
		frmLabChristine.setTitle("Lab1 - Christine Ebeo");
		frmLabChristine.setBounds(100, 100, 450, 300);
		frmLabChristine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLabChristine.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Simple Calculator");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(39, 27, 210, 37);
		frmLabChristine.getContentPane().add(lblTitle);
		
		JLabel lblFirstNum = new JLabel("First Number");
		lblFirstNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstNum.setBounds(39, 81, 146, 14);
		frmLabChristine.getContentPane().add(lblFirstNum);
		
		JLabel lblSecondNum = new JLabel("Second Number");
		lblSecondNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSecondNum.setBounds(39, 118, 146, 14);
		frmLabChristine.getContentPane().add(lblSecondNum);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResult.setBounds(39, 156, 146, 14);
		frmLabChristine.getContentPane().add(lblResult);
		
		textFirstField = new JTextField();
		textFirstField.setBounds(183, 80, 202, 20);
		frmLabChristine.getContentPane().add(textFirstField);
		textFirstField.setColumns(10);
		
		textSecondField = new JTextField();
		textSecondField.setColumns(10);
		textSecondField.setBounds(183, 117, 202, 20);
		frmLabChristine.getContentPane().add(textSecondField);
		
		textResult = new JTextField();
		textResult.setEditable(false);
		textResult.setColumns(10);
		textResult.setBounds(183, 155, 202, 20);
		frmLabChristine.getContentPane().add(textResult);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result = Double.parseDouble(textFirstField.getText()) + Double.parseDouble(textSecondField.getText());
				
				textResult.setText(Double.toString(result));
			}
		});
		btnPlus.setBounds(44, 200, 41, 37);
		frmLabChristine.getContentPane().add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result = Double.parseDouble(textFirstField.getText()) - Double.parseDouble(textSecondField.getText());
				
				textResult.setText(Double.toString(result));
			}
		});
		btnMinus.setBounds(144, 200, 41, 37);
		frmLabChristine.getContentPane().add(btnMinus);
		
		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result = Double.parseDouble(textFirstField.getText()) / Double.parseDouble(textSecondField.getText());
				
				textResult.setText(Double.toString(result));				
			}
		});
		btnDivide.setBounds(243, 200, 41, 37);
		frmLabChristine.getContentPane().add(btnDivide);
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double result = Double.parseDouble(textFirstField.getText()) * Double.parseDouble(textSecondField.getText());
				
				textResult.setText(Double.toString(result));
			}
		});
		btnMultiply.setBounds(344, 200, 41, 37);
		frmLabChristine.getContentPane().add(btnMultiply);
	}
}
