package test.list;

public class TestPersonManager {

	public static void main(String[] args) {
		// ��ü ����� ArrayList test
		PersonManager pm = new PersonManager();
		
		System.out.println("����--------------------------------");
		pm.addPerson();
		pm.printPersonList();
		System.out.println("�̸�����----------------------------------");
		pm.ascendingName();
		pm.printPersonList();
		System.out.println("�̸�����----------------------------------");
		pm.descendingName();
		pm.printPersonList();
		System.out.println("����Ʈ����----------------------------------");
		pm.ascendingPoint();
		pm.printPersonList();
		System.out.println("����Ʈ����----------------------------------");
		pm.descendingPoint();
		pm.printPersonList();
		System.out.println("��----------------------------------");
	}

}
