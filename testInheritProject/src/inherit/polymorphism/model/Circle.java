package inherit.polymorphism.model;

public class Circle implements IShape{//extends Shape{
	
	private double raidus;
	
	public Circle() {
		super();
	}
	
	public Circle(double raidus) {
		super();
		this.raidus = raidus;
	}

	public double getRaidus() {
		return raidus;
	}

	public void setRaidus(double raidus) {
		this.raidus = raidus;
	}

	@Override
	public double area() {
		return Math.round(IShape.PI*Math.pow(raidus, 2)*10)/10.0;
	}

	@Override
	public double perimeter() {
		return Math.round(2*IShape.PI*raidus*10)/10.0;
	}

}
