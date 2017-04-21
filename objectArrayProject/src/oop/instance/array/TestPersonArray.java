package oop.instance.array;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import oop.model.vo.Person;

public class TestPersonArray {
	static Scanner sc = new Scanner(System.in);

/*	public static void main(String[] args) {
		// Person 클래스 객체 배열 테스트
		//클래스자료형[] 배열레퍼런스 = new 클래스명[갯수]
		Person[] pr = new Person[5];
		
		pr[0] = new Person();
		pr[1] = new Person("홍길동", 27, 188.5, 68.9);
		pr[2] = new Person("홍길순", 21, 149.3, 51);
		pr[3] = new Person("문재인", 64, 178.9, 78.3);
		pr[4] = new Person("안철수", 62, 174.5, 74.1);
		
		for (int i=0; i<pr.length; i++)
			pr[i].displayPerson();

	}*/
	public static void main(String[] args) {
		//객체 배열의 초기화
		//자료형[] 배열명 = {초기값, 초기값, ...};
		//자료형[] 배열명 = new 자료형[]{초기값, 초기값, ...};
		
		Person[] pr = new Person[]{
				new Person(),
				new Person("홍길동", 27, 188.5, 68.9),
				new Person("홍길순", 21, 149.3, 51),
				new Person("문재인", 64, 178.9, 78.3),
				new Person("안철수", 62, 174.5, 74.1)
				};
		
		int sumAge = 0;
		for (int i=0; i<pr.length; i++){
			pr[i].displayPerson();
			sumAge += pr[i].getAge();
		}
		System.out.println("5명의 평균 나이 : " + sumAge/pr.length);

	}

}
