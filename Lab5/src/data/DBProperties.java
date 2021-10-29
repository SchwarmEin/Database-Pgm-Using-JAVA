package data;

import java.util.Properties;

public class DBProperties {
	
	private static Properties connProp = new Properties();
	
	public static Properties getConnectionProperties() {
		connProp.put("user", "N01455114");
		connProp.put("password", "oracle");
		
		return connProp;
	}
	
	public static String getDatabaseUrl() {
		connProp.put("dbUrl", "jdbc:oracle:thin:@calvin.humber.ca:1521:grok");
		return connProp.getProperty("dbUrl");
	}

}
