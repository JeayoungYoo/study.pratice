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
		Student st4 = new Student(254, "������", "ü����", 'M', 4.5 , "����� ������ ���ﵿ" , "0101", "������");
		
//		System.out.println("st : " + st.hashCode());
//		System.out.println("st2 : " + st.hashCode());
		st.printInformaiton();
		st2.printInformaiton();
		st4.printInformaiton();
		
		st.setSno(77);
		st.setName("�Ф���Ŀ");
		st.setGender('f');
		st.setMajor("�����");
		st.setScore(4.2);
		st.setPhone("010-1234-5678");
		st.setAddress("����� ���۱� ���");
		st.setProfessor("�Ż��");
		
		st.printInformaiton();
		
		//st2 �� ����
		st2.setGender('M');
		st2.setScore(4.5);
		st2.setAddress("����� ������ ���ﵿ");
		st2.setPhone("0101");
		st2.setProfessor("������");
		st2.printInformaiton();
		
		//st4 �� ����
		st4.setGender('F');
		st4.setScore(2.3);
		st4.setPhone("01044202250");
		st4.printInformaiton();
		
		double total = st.getScore()+st2.getScore()+st4.getScore();
		double avg = Math.round((total/3)*10)/10.0;
		System.out.println("���� : " + total);
		System.out.println("��� : " + avg);
		
		System.out.printf("��� : %.1f\n", avg); //��¿����� �����

	}

}
