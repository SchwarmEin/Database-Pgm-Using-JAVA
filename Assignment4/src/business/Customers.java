package business;

public class Customers {
	private int cust_id;
	private String cust_fname, cust_lname, phone, email, street, city, province, postal_code;

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_fname() {
		return cust_fname;
	}

	public void setCust_fname(String cust_fname) {
		this.cust_fname = cust_fname;
	}

	public String getCust_lname() {
		return cust_lname;
	}

	public void setCust_lname(String cust_lname) {
		this.cust_lname = cust_lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	@Override
	public String toString() {
		return  String.format("Customer ID: %d, "
				+ "First Name: %s, "
				+ "Last Name: %s, "
				+ "Phone: %s, "
				+ "Email: %s, "
				+ "Street: %s, "
				+ "City: %s, "
				+ "Province: %s, "
				+ "Postal Code: %s",
				
				cust_id,
				cust_fname,
				cust_lname,
				phone,
				email,
				street,
				city,
				province,
				postal_code);
	}

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
