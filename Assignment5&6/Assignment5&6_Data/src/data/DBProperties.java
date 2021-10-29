package data;
import java.util.Properties;

public class DBProperties {
	private static Properties connectionProps = new Properties();
	
	public static Properties getConnectionProps() {
		//connectionProps.put("user", "n01453628"); //this is Andrew's account
		connectionProps.put("user", "n01455114"); //this is Christine's account
		connectionProps.put("password", "oracle");
		return connectionProps;
	}
	
	public static String getDBURL() {
		connectionProps.put("dbURL", "jdbc:oracle:thin:@calvin.humber.ca:1521:grok");
		return connectionProps.getProperty("dbURL");
	}
}
