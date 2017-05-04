package ncs.test9;

public class Airplane extends Plane{
	public Airplane(){}
	
	public Airplane(String planeName, int fuelSize){
		super(planeName, fuelSize);
	}
	public void flight(int distance){
		super.setFuelSize(getFuelSize()-((int)(distance*0.1)*30));
	}
}
