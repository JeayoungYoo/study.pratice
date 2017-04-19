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
	
	public void information(){
		System.out.println(this.productID + "\t" + this.productName + "\t" + this.productArea + "\t" + this.price + "\t" + this.tex);
	}
	
	

}
