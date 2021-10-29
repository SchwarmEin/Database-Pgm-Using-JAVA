package data;
import java.sql.*;
import java.util.ArrayList;

import business.Customers;
public class DataIO_Cust {
	private Connection conn = null;
	public DataIO_Cust() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(DBProperties.getDBURL(), DBProperties.getConnectionProps());
	}
	
	//function of creating the customers table
	public void createCusTable() throws SQLException{
		String sqlQuery = "Create Table c_customers (\n"
					+ "customer_ID integer PRIMARY KEY, \n"
					+ "first_name varchar2(30) NOT NULL, \n"
					+ "last_name varchar2(30) NOT NULL, \n"
					+ "phone varchar2(10), \n"
					+ "email varchar2(30) NOT NULL, \n"
					+ "street varchar2(50), \n"
					+ "city varchar2(30), \n"
					+ "province varchar2(20), \n"
					+ "postal_code char(6) \n"
					+ ")";
		Statement stm = conn.createStatement();
		stm.execute(sqlQuery);
		stm.close();	
	}
	
	// function of displaying specific customers (use first name)
	public ArrayList<Customers> getCustFname(String fnameInput) throws SQLException {
		ArrayList<Customers> customers = new ArrayList<Customers>();
		String sqlQuery = String.format(
				"SELECT * FROM c_customers WHERE UPPER(first_name) LIKE UPPER('%%%s%%') ORDER BY customer_ID",
				fnameInput);	
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlQuery);
		while(rst.next()) {
			Customers customer = new Customers();
			customer.setCust_id(rst.getInt(1));
			customer.setCust_fname(rst.getString(2));
			customer.setCust_lname(rst.getString(3));
			customer.setPhone(rst.getString(4));
			customer.setEmail(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setCity(rst.getString(7));
			customer.setProvince(rst.getString(8));
			customer.setPostal_code(rst.getString(9));
			customers.add(customer);
		}
		rst.close();
		stm.close();
		return customers;
	}
	
	// function of displaying specific customers (use last name)
	public ArrayList<Customers> getCustLname(String lnameInput) throws SQLException {
		ArrayList<Customers> customers = new ArrayList<Customers>();
		String sqlQuery = String.format(
				"SELECT * FROM c_customers WHERE last_name LIKE '%%%s%%' ORDER BY customer_ID",
				lnameInput);
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlQuery);
		while(rst.next()) {
			Customers customer = new Customers();
			customer.setCust_id(rst.getInt(1));
			customer.setCust_fname(rst.getString(2));
			customer.setCust_lname(rst.getString(3));
			customer.setPhone(rst.getString(4));
			customer.setEmail(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setCity(rst.getString(7));
			customer.setProvince(rst.getString(8));
			customer.setPostal_code(rst.getString(9));
			customers.add(customer);
		}
		rst.close();
		stm.close();
		return customers;
	}
	
	// function of displaying specific customers (use first and last name)
	public ArrayList<Customers> getCust(String fnameInput, String lnameInput) throws SQLException {
		ArrayList<Customers> customers = new ArrayList<Customers>();
		String sqlQuery = String.format(
				"SELECT * FROM c_customers WHERE first_name LIKE '%%%s%%' AND last_name LIKE '%%%s%%' ORDER BY customer_ID",
				fnameInput,
				lnameInput);
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlQuery);
		while(rst.next()) {
			Customers customer = new Customers();
			customer.setCust_id(rst.getInt(1));
			customer.setCust_fname(rst.getString(2));
			customer.setCust_lname(rst.getString(3));
			customer.setPhone(rst.getString(4));
			customer.setEmail(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setCity(rst.getString(7));
			customer.setProvince(rst.getString(8));
			customer.setPostal_code(rst.getString(9));
			customers.add(customer);
		}
		rst.close();
		stm.close();
		return customers;
	}
	
	
	// function of displaying the first customer
	public Customers getFirst() throws SQLException {
		String sqlQuery = "SELECT * FROM c_customers ORDER BY customer_id";

		Statement stm = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
			    ResultSet.CONCUR_READ_ONLY);
		ResultSet rst = stm.executeQuery(sqlQuery);
		
		Customers customer = null;
		
		if (rst.first()) {
			customer = new Customers();
			customer.setCust_id(rst.getInt(1));
			customer.setCust_fname(rst.getString(2));
			customer.setCust_lname(rst.getString(3));
			customer.setPhone(rst.getString(4));
			customer.setEmail(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setCity(rst.getString(7));
			customer.setProvince(rst.getString(8));
			customer.setPostal_code(rst.getString(9));
		}
		
		rst.close();
		stm.close();
		
		return customer;
	}
	
	// function of displaying the last customer
	public Customers getLast() throws SQLException {
		String sqlQuery = "SELECT * FROM c_customers ORDER BY customer_id";

		Statement stm = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
			    ResultSet.CONCUR_READ_ONLY);
		ResultSet rst = stm.executeQuery(sqlQuery);
		
		Customers customer = null;
		
		if (rst.last()) {
		
			customer = new Customers();
			customer.setCust_id(rst.getInt(1));
			customer.setCust_fname(rst.getString(2));
			customer.setCust_lname(rst.getString(3));
			customer.setPhone(rst.getString(4));
			customer.setEmail(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setCity(rst.getString(7));
			customer.setProvince(rst.getString(8));
			customer.setPostal_code(rst.getString(9));
		}
	
		rst.close();
		stm.close();
		
		return customer;
	}
	
	// function of displaying the next customer from current one
	public Customers getNext(int id) throws SQLException {
		String sqlQuery = "SELECT * FROM c_customers ORDER BY customer_id";

		Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			    ResultSet.CONCUR_READ_ONLY);
		ResultSet rst = stm.executeQuery(sqlQuery);
		
		Customers customer = null;
		
		// make sure given id and the next id exists
		if(rst.absolute(id) && rst.next()) {
			customer = new Customers();
			customer.setCust_id(rst.getInt(1));
			customer.setCust_fname(rst.getString(2));
			customer.setCust_lname(rst.getString(3));
			customer.setPhone(rst.getString(4));
			customer.setEmail(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setCity(rst.getString(7));
			customer.setProvince(rst.getString(8));
			customer.setPostal_code(rst.getString(9));
			
		}
		
		rst.close();
		stm.close();
		
		return customer;
	}
	
	// function of displaying the previous customer from current one
	public Customers getPrevious(int id) throws SQLException {
		String sqlQuery = "SELECT * FROM c_customers ORDER BY customer_id";
		Statement stm = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
			    ResultSet.CONCUR_READ_ONLY);
		ResultSet rst = stm.executeQuery(sqlQuery);
		
		Customers customer = null;
		
		// make sure given id and the previous id exists
		if(rst.absolute(id) && rst.previous()) {
			customer = new Customers();
			customer.setCust_id(rst.getInt(1));
			customer.setCust_fname(rst.getString(2));
			customer.setCust_lname(rst.getString(3));
			customer.setPhone(rst.getString(4));
			customer.setEmail(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setCity(rst.getString(7));
			customer.setProvince(rst.getString(8));
			customer.setPostal_code(rst.getString(9));
			return customer;
		}
		
		rst.close();
		stm.close();
		
		return customer;
	}
	
	public void insertCustomer(Customers c) throws SQLException {
		String sqlQuery = String.format(
				"INSERT INTO c_customers VALUES ((select count(*)+1 from c_customers), '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
				c.getCust_fname(),
				c.getCust_lname(),
				c.getPhone(),
				c.getEmail(),
				c.getStreet(),
				c.getCity(),
				c.getProvince(),
				c.getPostal_code());
		
		Statement stm = conn.createStatement();
		System.out.println(stm.executeUpdate(sqlQuery));
		stm.close();
	}
	
	public int updateCustomer(Customers c) throws SQLException {
		int rowsUpdated = 0;
		String sqlQuery = String.format(
				"UPDATE c_customers SET "
						+ "first_name = '%s',"
						+ "last_name = '%s',"
						+ "phone = '%s',"
						+ "email = '%s',"
						+ "street = '%s',"
						+ "city = '%s',"
						+ "province = '%s',"
						+ "postal_code = '%s'"
						+ "WHERE customer_ID = %d",
				c.getCust_fname(),
				c.getCust_lname(),
				c.getPhone(),
				c.getEmail(),
				c.getStreet(),
				c.getCity(),
				c.getProvince(),
				c.getPostal_code(),
				c.getCust_id());
		
		Statement stm = conn.createStatement();
		rowsUpdated = stm.executeUpdate(sqlQuery);
		
		stm.close();
		
		return rowsUpdated;
	}
}
