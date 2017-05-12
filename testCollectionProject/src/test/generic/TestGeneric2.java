package test.generic;

import java.util.*;

import test.list.Person;

public class TestGeneric2 {

	public static void main(String[] args) {
		// Generic 기능 사용한 경우
		ArrayList<Person> alist = new ArrayList<Person>();
		alist.add(new Person("홍길동", 25, 1230.4));
		alist.add(new Person("리순신", 22, 1211.2));
		alist.add(new Person("김정은", 33, 2430.9));
		alist.add(new Person("리정희", 54, 1830.4));
		
		for(Person p : alist)
			System.out.println(p);
	}

}
