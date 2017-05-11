package test.list;

import java.util.*;

public class PersonManager {
	private Scanner sc = new Scanner(System.in);
	private ArrayList personList = new ArrayList();
	
	public PersonManager(){
				
	}
	
	public void addPerson(){
		/*do{
			System.out.println("���� ������ �Է��ϼ���.");
			System.out.println("exit �Է��ϸ� �����...");
			
			Person p = new Person();
			System.out.print("�̸� : ");
			String name = sc.next();
			if (name.equals("exit") == true) break;
			System.out.print("���� : ");
			int age = sc.nextInt();
			System.out.print("����Ʈ ���� : ");
			double point = sc.nextDouble();
			
			personList.add(new Person(name, age, point));
			
		}while(true);*/
		
		personList.add(new Person("ȫ�浿", 25, 137.5));
		personList.add(new Person("���浿", 21, 147.5));
		personList.add(new Person("��浿", 22, 157.5));
		
		System.out.println("\n" + personList.size() + "���� ������ �ԷµǾ����ϴ�");
	}
	
	public void printPersonList(){
		for (Object obj : personList)
			System.out.println(obj);
		
	}
	
	public void ascendingName(){
		personList.sort(new PersonNameAsc());
	}
	
	public void descendingName(){
		personList.sort(new PersonNameDesc());
	}
	
	public void ascendingPoint(){
		personList.sort(new PersonPointAsc());
	}
	
	public void descendingPoint(){
		personList.sort(new PersonPointDesc());
	}
}
