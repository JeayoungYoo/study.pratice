package test.generic;

import java.util.*;

import test.list.Person;

public class TestGeneric2 {

	public static void main(String[] args) {
		// Generic ��� ����� ���
		ArrayList<Person> alist = new ArrayList<Person>();
		alist.add(new Person("ȫ�浿", 25, 1230.4));
		alist.add(new Person("������", 22, 1211.2));
		alist.add(new Person("������", 33, 2430.9));
		alist.add(new Person("������", 54, 1830.4));
		
		for(Person p : alist)
			System.out.println(p);
	}

}
