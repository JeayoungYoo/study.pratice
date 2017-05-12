package test.generic;

import java.util.*;

import practice2.Book;
import test.list.Person;

public class TestGeneric1 {

	public static void main(String[] args) {
		// Generic 기능을 사용하지 않은 경우
		List list = new ArrayList();
		
		list.add(new String("apples"));
		list.add(new Person("홍길동", 25, 123.5));
		list.add(new GregorianCalendar(2007, 5, 15));
		list.add(new Book("12", 2, "자바의정석", "남궁성"));
		
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
				System.out.println("카테고리 : " + ((Book) obj).getCategory());
			}
		}

	}

}
