package com.week4;

import java.util.Scanner;

public class ExamTestExamTest {

	public static void main(String[] args) {
		ExamString es = new ExamString();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("preChar �޼���");
		System.out.print("���ڿ� �Է� : ");
		System.out.println(es.preChar(sc.next()));
		
		
		System.out.println("charSu �޼���");
		System.out.print("���ڿ�, ���� �Է� : ");
		System.out.println(es.charSu(sc.next(), sc.next().charAt(0)));
		

	}

}
