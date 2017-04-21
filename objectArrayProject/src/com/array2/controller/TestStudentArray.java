package com.array2.controller;

import java.util.Scanner;

import com.oop.array2.model.Student;

public class TestStudentArray {

	public static void main(String[] args) {
		Student[] st = new Student[10];
		Scanner sc = new Scanner(System.in);
		
		int cnt=0, sumScore=0;
		
		while(true){
			st[cnt] = new Student();
			System.out.print("�й� �Է� : ");
			st[cnt].setSno(sc.nextInt());
			System.out.print("�̸� �Է� : ");
			st[cnt].setName(sc.next());
			System.out.print("���� �Է� : ");
			st[cnt].setMajor(sc.next());
			System.out.print("���� �Է� : ");
			st[cnt].setGender(sc.next().charAt(0));
			System.out.print("���� �Է� : ");
			st[cnt].setScore(sc.nextDouble());
			System.out.println("�ּ� �Է� : ");
			st[cnt].setAddress(sc.nextLine()+sc.nextLine());
			System.out.print("��ȭ��ȣ �Է� : ");
			st[cnt].setPhone(sc.next());
			System.out.print("�������� �Է� : ");
			st[cnt].setProfessor(sc.next());
			
			System.out.print("�߰� �Է��Ҳ���? (y/n) : ");
			if (sc.next().toUpperCase().charAt(0)=='Y'){
				cnt++;
				continue;
			}
			else
				break;
		}
		
		for (int i=0; i<=cnt; i++){
			st[i].printInformaiton();
			sumScore += st[i].getScore();
		}
		System.out.println("�Էµ� �л����� ��� ���� : " + sumScore/(cnt+1));
		
	}
}
