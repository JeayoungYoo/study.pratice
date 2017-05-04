package ncs.test9;

public class Cargoplane extends Plane{
	
	public Cargoplane(){
		
	}
	
	public Cargoplane(String planeName, int fuelSize){
		super(planeName, fuelSize);
	}
	
	public void flight(int distance){
		super.setFuelSize(getFuelSize()-((int)(distance*0.1)*50));
		
	}
}

