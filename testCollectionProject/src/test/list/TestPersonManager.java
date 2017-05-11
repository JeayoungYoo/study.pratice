package test.list;

public class TestPersonManager {

	public static void main(String[] args) {
		// 객체 저장용 ArrayList test
		PersonManager pm = new PersonManager();
		
		System.out.println("원본--------------------------------");
		pm.addPerson();
		pm.printPersonList();
		System.out.println("이름오름----------------------------------");
		pm.ascendingName();
		pm.printPersonList();
		System.out.println("이름내림----------------------------------");
		pm.descendingName();
		pm.printPersonList();
		System.out.println("포인트오름----------------------------------");
		pm.ascendingPoint();
		pm.printPersonList();
		System.out.println("포인트내림----------------------------------");
		pm.descendingPoint();
		pm.printPersonList();
		System.out.println("끝----------------------------------");
	}

}
