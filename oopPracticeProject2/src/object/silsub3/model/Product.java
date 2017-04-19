package object.silsub3.model;

public class Product {
	private String productID;
	private String productName;
	private String productArea;
	private int price;
	private double tex;
	
	public Product(){}

	public Product(String productID, String productName, String productArea, int price, double tex) {
		this.productID = productID;
		this.productName = productName;
		this.productArea = productArea;
		this.price = price;
		this.tex = tex;
	}
	
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductArea() {
		return productArea;
	}

	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getTex() {
		return tex;
	}

	public void setTex(double tex) {
		this.tex = tex;
	}

	public void information(){
		System.out.println(this.productID + "\t" + this.productName + "\t" + this.productArea + "\t" + this.price + "\t" + this.tex);
	}
	
	

}
