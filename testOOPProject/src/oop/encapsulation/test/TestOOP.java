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
		Student st4 = new Student(254, "김유신", "체육학", 'M', 4.5 , "서울시 강남구 역삼동" , "0101", "김유정");
		
//		System.out.println("st : " + st.hashCode());
//		System.out.println("st2 : " + st.hashCode());
		st.printInformaiton();
		st2.printInformaiton();
		st4.printInformaiton();
		
		st.setSno(77);
		st.setName("패ㅔ이커");
		st.setGender('f');
		st.setMajor("무용과");
		st.setScore(4.2);
		st.setPhone("010-1234-5678");
		st.setAddress("서울시 동작구 어딘가");
		st.setProfessor("신삼당");
		
		st.printInformaiton();
		
		//st2 값 변경
		st2.setGender('M');
		st2.setScore(4.5);
		st2.setAddress("서울시 강남구 역삼동");
		st2.setPhone("0101");
		st2.setProfessor("김유정");
		st2.printInformaiton();
		
		//st4 값 변경
		st4.setGender('F');
		st4.setScore(2.3);
		st4.setPhone("01044202250");
		st4.printInformaiton();
		
		double total = st.getScore()+st2.getScore()+st4.getScore();
		double avg = Math.round((total/3)*10)/10.0;
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		
		System.out.printf("평균 : %.1f\n", avg); //출력에서만 사용함

	}

}
