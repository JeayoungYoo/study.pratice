package ncs.test9;

public class PlaneTest {

	public static void main(String[] args) {
		Plane p = new Airplane("L747", 1000);
		Plane c = new Cargoplane("C40", 1000);
		
		System.out.println("Plane\tfuelSize");
		System.out.println("-------------------------");
		System.out.println(p.getPlaneName()+"\t"+p.getFuelSize());
		System.out.println(c.getPlaneName()+"\t"+c.getFuelSize());
		
		System.out.println("100 운항");
		p.flight(100);
		c.flight(100);
		
		System.out.println("Plane\tfuelSize");
		System.out.println("-------------------------");
		System.out.println(p.getPlaneName()+"\t"+p.getFuelSize());
		System.out.println(c.getPlaneName()+"\t"+c.getFuelSize());
		
		System.out.println("200 주유");
		p.refuel(200);
		c.refuel(200);
		
		System.out.println("Plane\tfuelSize");
		System.out.println("-------------------------");
		System.out.println(p.getPlaneName()+"\t"+p.getFuelSize());
		System.out.println(c.getPlaneName()+"\t"+c.getFuelSize());
		
		
	}

}
