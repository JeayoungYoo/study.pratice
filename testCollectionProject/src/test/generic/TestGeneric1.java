package test.generic;

import java.util.*;

import practice2.Book;
import test.list.Person;

public class TestGeneric1 {

	public static void main(String[] args) {
		// Generic ����� ������� ���� ���
		List list = new ArrayList();
		
		list.add(new String("apples"));
		list.add(new Person("ȫ�浿", 25, 123.5));
		list.add(new GregorianCalendar(2007, 5, 15));
		list.add(new Book("12", 2, "�ڹ�������", "���ü�"));
		
		for (Object obj : list){
			System.out.println(obj);
		}
		
		for (int i = 0; i<list.size(); i++){
			Object obj = list.get(i);
			if(obj instanceof String){
				System.out.println(((String) obj).toUpperCase());
			}
			if(obj instanceof Person){
				System.out.println(((Person) obj).getPoint());
			}
			if(obj instanceof Book){
				System.out.println("ī�װ� : " + ((Book) obj).getCategory());
			}
		}

	}

}
