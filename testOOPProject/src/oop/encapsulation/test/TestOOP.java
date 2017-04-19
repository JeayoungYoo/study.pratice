package oop.encapsulation.test;

import oop.encapsulation.sample.Student;



public class TestOOP {

	public static void main(String[] args) {
		/*DefaultSample dsamp;
		oop.encapsulation.sample.Student st;
		st = new oop.encapsulation.sample.Student();
		st.name = "홍길순";*/
		
		Student st = new Student();
		Student st2 = new Student(100, "홍길동", "정보통신");
//		Student st3 = new Student(123, "박문수", "전자공학", 3.8, "이순신");
		Student st4 = new Student(254, "김유신", "체육학", 'M', 4.5 , "서울시 강남구 역삼동" , 0101, "김유정");
		
//		System.out.println("st : " + st.hashCode());
//		System.out.println("st2 : " + st.hashCode());
		st.printInformaiton();
		st2.printInformaiton();
		st4.printInformaiton();
	}

}
