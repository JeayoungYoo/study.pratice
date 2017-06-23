package product.model.vo;

public class Product implements java.io.Serializable {
	private String product_Id;
	private String p_name;
	private int price;
	private String description;
	public Product() {
		super();
	}
	public Product(String product_Id, String p_name, int price, String description) {
		super();
		this.product_Id = product_Id;
		this.p_name = p_name;
		this.price = price;
		this.description = description;
	}
	public String getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(String product_Id) {
		this.product_Id = product_Id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return product_Id + ", " + p_name + ", " + price + ", "
				+ description;
	}
	
	
}
