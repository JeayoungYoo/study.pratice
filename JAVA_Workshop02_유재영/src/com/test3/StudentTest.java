package com.test3;

public class StudentTest {

	public static void main(String[] args) {
		Student studentArray[] = new Student[3];
		studentArray[0] = new Student("ȫ�浿", 15, 170, 80);
		studentArray[1] = new Student("�ѻ��", 13, 180, 70);
		studentArray[2] = new Student("�Ӱ���", 16, 175, 65);
		
		double ageSum=0, heiSum=0, weiSum=0;
		int maxAge=0, minAge=0, maxHei=0, minHei=0, maxWei=0, minWei=0;
		
		System.out.println("�̸�\t����\t����\t������");
		for(int i=0; i<studentArray.length; i++) {
			System.out.println(studentArray[i].studentInfo());
			ageSum += studentArray[i].getAge();
			heiSum += studentArray[i].getHeight();
			weiSum += studentArray[i].getWeight();
			
			for (int j=i+1; j<studentArray.length; j++) {
				if (studentArray[i].getAge() > studentArray[j].getAge()) {
					maxAge=i;
					minAge=j;
				}
				else {
					maxAge=j;
					minAge=i;
				}
				
				if(studentArray[i].getHeight()>studentArray[j].getHeight()) {
					maxHei=i;
					minHei=j;
				}
				else {
					maxHei=j;
					minHei=i;
				}
				
				if(studentArray[i].getWeight()>studentArray[j].getWeight()) {
					maxWei=i;
					minWei=j;
				}
				else {
					maxWei=j;
					minWei=i;
				}
			}
		}
		
		System.out.println("���� ���: " + Math.round(ageSum/studentArray.length*1000)/1000.0);
		System.out.println("���� ���: " + Math.round(heiSum/studentArray.length*1000)/1000.0);
		System.out.println("������ ���: " + Math.round(weiSum/studentArray.length*1000)/1000.0);
		
		/*for (int i=0; i<studentArray.length-1; i++) {
			for (int j=i+1; j<studentArray.length; j++) {
				if (studentArray[i].getAge()>studentArray[j].getAge()) {
					maxIndex=i;
					minIndex=j;
				}
				
				else{
					maxIndex=j;
					minIndex=i;
				}
			}
		}*/
			
		System.out.println("���̰� ���� ���� �л�: " + studentArray[maxAge].getName());
		System.out.println("���̰� ���� ���� �л�: " + studentArray[minAge].getName());
		
		/*
		for (int i=0; i<studentArray.length-1; i++) {
			for (int j=i+1; j<studentArray.length; j++) {
				if (studentArray[i].getHeight()>studentArray[j].getHeight()) {
					maxIndex=i;
					minIndex=j;
				}
				
				else{
					maxIndex=j;
					minIndex=i;
				}
			}
		}*/
		
		System.out.println("������ ���� ū �л�: " + studentArray[maxHei].getName());
		System.out.println("������ ���� ���� �л�: " + studentArray[minHei].getName());
		
		/*
		for (int i=0; i<studentArray.length-1; i++) {
			for (int j=i+1; j<studentArray.length; j++) {
				if (studentArray[i].getWeight()>studentArray[j].getWeight()) {
					maxIndex=i;
					minIndex=j;
				}
				
				else{
					maxIndex=j;
					minIndex=i;
				}
			}
		}*/
		
		System.out.println("�����԰� ���� ���� ������ �л�: " + studentArray[maxWei].getName());
		System.out.println("�����԰� ���� ���� ������ �л�: " + studentArray[minWei].getName());
	}

}
