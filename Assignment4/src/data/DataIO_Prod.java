package data;
import java.sql.*;
import java.util.ArrayList;

import business.Products;

public class DataIO_Prod {
	private Connection conn = null;
	public DataIO_Prod() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(DBProperties.getDBURL(), DBProperties.getConnectionProps());
	}
	
	//function of creating the products table
	public void createProdTable() throws SQLException{
		String sqlQuery = "Create Table p_products (\n"
					+ "product_ID integer PRIMARY KEY, \n"
					+ "product_name varchar2(30) NOT NULL, \n"
					+ "list_price number(9,2) NOT NULL \n"
					+ ")";
		Statement stm = conn.createStatement();
		stm.execute(sqlQuery);
		stm.close();	
	}
	
	//function of displaying the products table
	public ArrayList<Products> getProd() throws SQLException{
		ArrayList<Products> products = new ArrayList<Products>();
		String sqlQuery = "select * from p_products order by product_ID";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlQuery);
		while(rst.next()) {
			Products product = new Products();
			product.setProd_id(rst.getInt(1));
			product.setProd_name(rst.getString(2));
			product.setProd_price(rst.getDouble(3));
			products.add(product);
		}
		rst.close();
		stm.close();
		return products;
	}
	
	//row insert function - save operation
	public void insertProduct(Products prod) throws SQLException {
		String sqlQuery = String.format(
				"INSERT INTO p_products VALUES ((select count(*)+1 from p_products), '%s', %f)",
				prod.getProd_name(),
				prod.getProd_price());
				
		Statement stm = conn.createStatement();
		stm.executeUpdate(sqlQuery);
		stm.close();
	}
	
	//row update function - update operation
	public int updateProduct(Products prod) throws SQLException {
		int rowsUpdated = 0;
		String sqlQuery = String.format(
				"UPDATE programs SET "
				+ "product_name= '%s',"
				+ "list_price= %f," 
				+ "WHERE product_ID= %d",
				
				prod.getProd_name(),
				prod.getProd_price(),
				prod.getProd_id());
				
		Statement stm = conn.createStatement();
		rowsUpdated = stm.executeUpdate(sqlQuery);
		stm.close();
		return rowsUpdated;
	}
	
	//find the row with product ID
	public ArrayList<Products> getProdID(int prodIDInput) throws SQLException {
		ArrayList<Products> products = new ArrayList<Products>();
		String sqlQuery = String.format(
				"SELECT * FROM p_products WHERE product_ID = %d",
				prodIDInput);
		
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlQuery);

		while(rst.next()) {
			Products product = new Products();
			product.setProd_id(rst.getInt(1));
			product.setProd_name(rst.getString(2));
			product.setProd_price(rst.getDouble(3));
			products.add(product);
		}
		rst.close();
		stm.close();
		return products;
	}
	
	//find the rows with product price range
	public ArrayList<Products> getProdPrice(double prodMINInput, double prodMAXInput) throws SQLException {
		ArrayList<Products> products = new ArrayList<Products>();
		String sqlQuery = String.format(
				"SELECT * FROM p_products WHERE list_price BETWEEN %f AND %f ORDER BY product_ID",
				prodMINInput, prodMAXInput);
		
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlQuery);
		while(rst.next()) {
			Products product = new Products();
			product.setProd_id(rst.getInt(1));
			product.setProd_name(rst.getString(2));
			product.setProd_price(rst.getDouble(3));
			products.add(product);
		}
		rst.close();
		stm.close();
		return products;
	}
	
	//find the row with product name
	public ArrayList<Products> getProdName(String ProdNameInput) throws SQLException {
		ArrayList<Products> products = new ArrayList<Products>();
		String sqlQuery = String.format(
				"SELECT * FROM p_products WHERE product_name LIKE '%%%s%%' ORDER BY product_ID",
				ProdNameInput);
		
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sqlQuery);
		while(rst.next()) {
			Products product = new Products();
			product.setProd_id(rst.getInt(1));
			product.setProd_name(rst.getString(2));
			product.setProd_price(rst.getDouble(3));
			products.add(product);
		}
		rst.close();
		stm.close();
		return products;
	}
}
