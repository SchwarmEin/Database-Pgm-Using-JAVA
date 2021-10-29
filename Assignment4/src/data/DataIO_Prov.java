package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataIO_Prov {
	
	private Connection conn = null;
	public DataIO_Prov() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(DBProperties.getDBURL(), DBProperties.getConnectionProps());
	}
	
	// create and populate province table
	public void createProvinceTable() throws SQLException{
		String sqlQuery = "CREATE TABLE province (\n"
					+ "Province_ID integer PRIMARY KEY, \n"
					+ "Postal_abbrev char(2), \n"
					+ "Name VARCHAR2(20) NOT NULL \n"
					+ ")";
		Statement stm = conn.createStatement();
		stm.execute(sqlQuery);
		stm.close();	
	}
	
	public void insertProvinceList() throws SQLException{
		String sqlQuery = "INSERT ALL "
				+ "INTO Province VALUES (1, 'AB', 'Alberta')\n"
				+ "INTO Province VALUES (2, 'BC', 'British Columbia')\n"
				+ "INTO Province VALUES (3, 'MB', 'Manitoba')\n"
				+ "INTO Province VALUES (4, 'NB', 'New Brunswick')\n"
				+ "INTO Province VALUES (5, 'NL', 'Newfl. and Lab.')\n"
				+ "INTO Province VALUES (6, 'NT', 'Northwest Ter.')\n"
				+ "INTO Province VALUES (7, 'NS', 'Nova Scotia')\n"
				+ "INTO Province VALUES (8, 'NU', 'Nunavut')\n"
				+ "INTO Province VALUES (9, 'ON', 'Ontario')\n"
				+ "INTO Province VALUES (10, 'PE', 'Prince Edward Isl.')\n"
				+ "INTO Province VALUES (11, 'QC', 'Quebec')\n"
				+ "INTO Province VALUES (12, 'SK', 'Saskatchewan')\n"
				+ "INTO Province VALUES (13, 'YT', 'Yukon')\n"
				+ "SELECT * FROM dual";
		
		Statement stm = conn.createStatement();
		stm.execute(sqlQuery);
		
		stm.close();	
	}
	
	//function of displaying the provinces table into checkbox
	public String[] setProvinceList() throws SQLException{
		ArrayList<String> provinces = new ArrayList<String>();
		String sqlQuery = "select name from province order by province_id";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlQuery);
		while(rst.next()) {
			String name = rst.getString(1);
			provinces.add(name);
		}
		rst.close();
		stm.close();
		return provinces.toArray(new String[0]);
	}
}
