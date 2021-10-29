package business;

public class Products {
	private int prod_id;
	private String prod_name;
	private double prod_price, prod_price_min, prod_price_max;
	
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public double getProd_price() {
		return prod_price;
	}
	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}
	public double getProd_price_min() {
		return prod_price_min;
	}
	public void setProd_price_min(double prod_price_min) {
		this.prod_price_min = prod_price_min;
	}
	public double getProd_price_max() {
		return prod_price_max;
	}
	public void setProd_price_max(double prod_price_max) {
		this.prod_price_max = prod_price_max;
	}

	@Override
	public String toString() {
		return String.format("Product ID: %d, "
				+ "Product name: %s, "
				+ "Prodcut price: %.2f ",
				
				prod_id,
				prod_name,
				prod_price
				);
	}
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
