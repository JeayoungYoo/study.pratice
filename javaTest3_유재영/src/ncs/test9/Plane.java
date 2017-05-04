package ncs.test9;

public abstract class Plane {
	private String planeName;
	private int fuelSize;
	public Plane() {
		super();
	}
	public Plane(String planeName, int fuelSize) {
		super();
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	public void refuel(int fuel){
		fuel += 200;
	}
	
	public abstract void flight(int distance);
}
