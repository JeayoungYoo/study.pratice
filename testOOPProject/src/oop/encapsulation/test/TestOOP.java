package oop.encapsulation.test;

import oop.encapsulation.sample.Student;



public class TestOOP {

	public static void main(String[] args) {
		/*DefaultSample dsamp;
		oop.encapsulation.sample.Student st;
		st = new oop.encapsulation.sample.Student();
		st.name = "ȫ���";*/
		
		Student st = new Student();
		Student st2 = new Student(100, "ȫ�浿", "�������");
//		Student st3 = new Student(123, "�ڹ���", "���ڰ���", 3.8, "�̼���");
		Student st4 = new Student(254, "������", "ü����", 'M', 4.5 , "����� ������ ���ﵿ" , 0101, "������");
		
//		System.out.println("st : " + st.hashCode());
//		System.out.println("st2 : " + st.hashCode());
		st.printInformaiton();
		st2.printInformaiton();
		st4.printInformaiton();
	}

}
