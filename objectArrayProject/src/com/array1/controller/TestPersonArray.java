package com.array1.controller;

import java.util.Scanner;

import com.oop.array1.model.Person;

public class TestPersonArray {

	public static void main(String[] args) {
		Person[] pr = new Person[5];
		Scanner sc = new Scanner(System.in);
		
		int sumAge = 0;
		double sumHeight = 0.0, sumWeight=0.0;
		
		for (int i=0; i<pr.length; i++ ){
			pr[i] = new Person();
			System.out.print("�̸� : ");
			pr[i].setName(sc.next());
			System.out.print("���� : ");
			pr[i].setAge(sc.nextInt());
			System.out.print("Ű : ");
			pr[i].setHeight(sc.nextDouble());
			System.out.println("������ : ");
			pr[i].setWeight(sc.nextDouble());
//			System.out.println("��� : ");
//			pr[i].setProperty(sc.nextDouble());
			
			sumAge += pr[i].getAge();
			sumHeight += pr[i].getHeight();
			sumWeight += pr[i].getWeight();
		}
		//���Ȯ��
		for (int i=0; i<pr.length; i++)
			pr[i].displayPerson();
		System.out.println();
		System.out.println("���� ��� : " + sumAge/pr.length);
		System.out.println("Ű ��� : " + sumHeight/pr.length);
		System.out.println("������ ��� : " + sumWeight/pr.length);
	}

}
