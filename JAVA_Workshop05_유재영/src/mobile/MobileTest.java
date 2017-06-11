package mobile;

public class MobileTest {

	public static void main(String[] args) {
		
		
		Mobile mobile1 = new Ltab ("Ltab", 500, "AP-01");
		Mobile mobile2 = new Otab ("Otab", 1000, "AND-20");
		
		System.out.println("Mobile\tBattery\tOS");
		System.out.println("----------------------");
		System.out.println(mobile1);
		System.out.println(mobile2);
		
		mobile1.charge(10);
		mobile2.charge(10);
		System.out.println("\n10분 충전");
		
		System.out.println("Mobile\tBattery\tOS");
		System.out.println("----------------------");
		System.out.println(mobile1);
		System.out.println(mobile2);
		
		mobile1.operate(5);
		mobile2.operate(5);
		System.out.println("\n5분 통화");
		
		System.out.println("Mobile\tBattery\tOS");
		System.out.println("----------------------");
		System.out.println(mobile1);
		System.out.println(mobile2);
	}

}
