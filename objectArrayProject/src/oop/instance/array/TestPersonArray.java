package oop.instance.array;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import oop.model.vo.Person;

public class TestPersonArray {
	static Scanner sc = new Scanner(System.in);

/*	public static void main(String[] args) {
		// Person Ŭ���� ��ü �迭 �׽�Ʈ
		//Ŭ�����ڷ���[] �迭���۷��� = new Ŭ������[����]
		Person[] pr = new Person[5];
		
		pr[0] = new Person();
		pr[1] = new Person("ȫ�浿", 27, 188.5, 68.9);
		pr[2] = new Person("ȫ���", 21, 149.3, 51);
		pr[3] = new Person("������", 64, 178.9, 78.3);
		pr[4] = new Person("��ö��", 62, 174.5, 74.1);
		
		for (int i=0; i<pr.length; i++)
			pr[i].displayPerson();

	}*/
	public static void main(String[] args) {
		//��ü �迭�� �ʱ�ȭ
		//�ڷ���[] �迭�� = {�ʱⰪ, �ʱⰪ, ...};
		//�ڷ���[] �迭�� = new �ڷ���[]{�ʱⰪ, �ʱⰪ, ...};
		
		Person[] pr = new Person[]{
				new Person(),
				new Person("ȫ�浿", 27, 188.5, 68.9),
				new Person("ȫ���", 21, 149.3, 51),
				new Person("������", 64, 178.9, 78.3),
				new Person("��ö��", 62, 174.5, 74.1)
				};
		
		int sumAge = 0;
		for (int i=0; i<pr.length; i++){
			pr[i].displayPerson();
			sumAge += pr[i].getAge();
		}
		System.out.println("5���� ��� ���� : " + sumAge/pr.length);

	}

}
