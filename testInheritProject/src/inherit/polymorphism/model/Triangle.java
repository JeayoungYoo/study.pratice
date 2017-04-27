package inherit.polymorphism.model;

import org.omg.Messaging.SyncScopeHelper;

public class Triangle implements IShape{
	private double base;
	private double height;
	
	
	public Triangle() {
		super();
	}
	
	public Triangle(double base, double height) {
		super();
		this.base = base;
		this.height = height;
	}
	
	@Override
	public double area() {
		
		return (base*height)/2;
	}

	@Override
	public double perimeter() {
		System.out.println("���� ���� : " + getHypotenuse());
		return base+height+getHypotenuse();
	}
	
	public double getHypotenuse(){
		return Math.sqrt(base*base+height+height);
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	

}
