package data;

import java.sql.Statement;
import java.util.ArrayList;

import business.Program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataIO {
	
	private Connection conn = null;
	
	public DataIO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		conn = DriverManager.getConnection(DBProperties.getDatabaseUrl(), DBProperties.getConnectionProperties());
		
	}
	
	public void createTable() throws SQLException {
		String query = "CREATE TABLE Programs (\n"
				+ "P_ID varchar2 (7) PRIMARY KEY,\n"
				+ "P_Name varchar2 (30) NOT NULL,\n"
				+ "P_CR_HRS number (2),\n"
				+ "P_SEATS number (3)\n"
				+ ")";
		
		Statement stm = conn.createStatement();
		stm.execute(query);
		stm.close();			
				
	}
	
	public ArrayList<Program> getPrograms() throws SQLException {
		
		ArrayList<Program> programs = new ArrayList<Program>();
		
		String query = "SELECT * FROM Programs"; 
		
		Statement stm = conn.createStatement();
		
		ResultSet rst = stm.executeQuery(query);
		
		while (rst.next()) {
			Program program = new Program(
					rst.getString(1),
					rst.getString(2),
					rst.getInt(3),
					rst.getInt(4)
					);
			
			programs.add(program);
		}
		
		rst.close();
		stm.close();
		
		return programs;
		
	}
	
	public void insertProgram(Program program) throws SQLException {
		String query = String.format("INSERT INTO Programs VALUES ('%s', '%s', %d, %d)",
						program.getId(),
						program.getName(),
						program.getCrHrs(),
						program.getSeats());
		
		Statement stm = conn.createStatement();
		stm.executeUpdate(query);
		stm.close();
		
	}
	
	public void updateProgram(Program program) throws SQLException {
		String query = String.format(
				"UPDATE Programs SET "
				+ "P_Name='%s', "
				+ "P_CR_HRS=%d, "
				+ "P_SEATS=%d "
				+ "WHERE P_ID='%s'",
				program.getName(), program.getCrHrs(), program.getSeats(), program.getId());
		
		Statement stm = conn.createStatement();
		stm.executeUpdate(query);
		stm.close();
		
	}
	
	public void deleteNoSeats() throws SQLException {
		
		String query = "DELETE FROM Programs WHERE P_SEATS=0"; 
		
		Statement stm = conn.createStatement();
		stm.executeUpdate(query);
		stm.close();
		
		
	}
	
	

}
