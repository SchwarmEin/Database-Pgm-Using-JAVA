import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnect {
	
	public static void main(String[] args) {
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
				String dURL = "jdbc:oracle:thin:@calvin.humber.ca:1521:grok";
				
				String userName = "N01455114";
				
				String pwd = "oracle";
				
				Connection connection = DriverManager.getConnection(dURL, userName, pwd);
				
				System.out.println("Able to connect.");
			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
