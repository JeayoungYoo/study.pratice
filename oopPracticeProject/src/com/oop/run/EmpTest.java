package com.oop.run;

import java.util.Scanner;

import com.oop.model.dto.Employee;

public class EmpTest {
	
	public static void main(String[] args) {
		

	}
	
	public static void mainMenu(){
		Employee e = new Employee();
		System.out.println("1. �� ��� ���� �Է�");
		System.out.println("2. ��� ���� ����");
		System.out.println("3. ��� ���� ����");
		System.out.println("4. ������� ���");
		System.out.println("9. ������");
		
		int num = new Scanner(System.in).nextInt();
		
		switch(num){
		case 1: e.empInput(); break;
		case 2: modifyMenu(e); break;
		case 3: break;
		case 4: e.empOutput(); break;
		case 9: break;
			default : continue;
		}
	}
	
	public static void modifyMenu(Employee e){
		System.out.println("1. �̸� ����");
		System.out.println("2. �޿� ����");
		System.out.println("3. �μ� ����");
		System.out.println("4. ���� ����");
		System.out.println("5. ���� �޴��� �̵�");
		
		int num = new Scanner(System.in).nextInt();
		
		
		switch(num){
		case 1: e.setEmpName(e.empInput()); break;
		case 2: modifyMenu(e); break;
		case 3: break;
		case 4: e.empOutput(); break;
		case 5: return;
			default : continue;
	}

}
