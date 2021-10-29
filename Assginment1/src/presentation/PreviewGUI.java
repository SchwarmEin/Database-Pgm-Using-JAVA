package presentation;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PreviewGUI extends JFrame {
		
	public PreviewGUI(String[][] report) {
	    JFrame jf = new JFrame();      
	    String column[]={"Date","City","Number of Cases", "Number of Deaths", "Number of Cases Recovered"};         
	    JTable jt=new JTable(report,column);    
	    jt.setBounds(30,40,200,300);          
	    JScrollPane sp=new JScrollPane(jt);    
	    jf.add(sp);          
	    jf.setSize(1000,500);    
	    jf.setVisible(true);    
	}     
}
