package test.list;

import java.util.*;

public class PersonManager {
	private Scanner sc = new Scanner(System.in);
	private ArrayList personList = new ArrayList();
	
	public PersonManager(){
				
	}
	
	public void addPerson(){
		/*do{
			System.out.println("고객의 정보를 입력하세요.");
			System.out.println("exit 입력하면 종료됨...");
			
			Person p = new Person();
			System.out.print("이름 : ");
			String name = sc.next();
			if (name.equals("exit") == true) break;
			System.out.print("나이 : ");
			int age = sc.nextInt();
			System.out.print("포인트 점수 : ");
			double point = sc.nextDouble();
			
			personList.add(new Person(name, age, point));
			
		}while(true);*/
		
		personList.add(new Person("홍길동", 25, 137.5));
		personList.add(new Person("유길동", 21, 147.5));
		personList.add(new Person("김길동", 22, 157.5));
		
		System.out.println("\n" + personList.size() + "명의 정보가 입력되었습니댜");
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
