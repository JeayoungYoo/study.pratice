package inherit.polymorphism.model;

public class Rectangle implements IShape{//extends Shape{
	
	private double width;
	private double height;
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Rectangle() {
		super();
	}
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	@Override
	public double area() {
		return Math.round(width*height*10)/10.0;
	}
	@Override
	public double perimeter() {
		return Math.round(2*(width+height)*10)/10.0;
	}
	
	
}
