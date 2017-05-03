package com.week4;

import java.util.Scanner;

public class ExamTestExamTest {

	public static void main(String[] args) {
		ExamString es = new ExamString();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("preChar 메서드");
		System.out.print("문자열 입력 : ");
		System.out.println(es.preChar(sc.next()));
		
		
		System.out.println("charSu 메서드");
		System.out.print("문자열, 문자 입력 : ");
		System.out.println(es.charSu(sc.next(), sc.next().charAt(0)));
		

	}

}
