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
			System.out.print("학번 입력 : ");
			st[cnt].setSno(sc.nextInt());
			System.out.print("이름 입력 : ");
			st[cnt].setName(sc.next());
			System.out.print("전공 입력 : ");
			st[cnt].setMajor(sc.next());
			System.out.print("성별 입력 : ");
			st[cnt].setGender(sc.next().charAt(0));
			System.out.print("학점 입력 : ");
			st[cnt].setScore(sc.nextDouble());
			System.out.println("주소 입력 : ");
			st[cnt].setAddress(sc.nextLine()+sc.nextLine());
			System.out.print("전화번호 입력 : ");
			st[cnt].setPhone(sc.next());
			System.out.print("지도교수 입력 : ");
			st[cnt].setProfessor(sc.next());
			
			System.out.print("추가 입력할꺼야? (y/n) : ");
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
		System.out.println("입력된 학생들의 평균 점수 : " + sumScore/(cnt+1));
		
	}
}
