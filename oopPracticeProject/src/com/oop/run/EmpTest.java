package com.oop.run;

import java.util.Scanner;

import com.oop.model.dto.Employee;

public class EmpTest {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		mainMenu();
	}

	public static void mainMenu() {

		Employee e = new Employee();
		

		do {
			System.out.println("1. �� ��� ���� �Է�");
			System.out.println("2. ��� ���� ����");
			System.out.println("3. ��� ���� ����");
			System.out.println("4. ������� ���");
			System.out.println("9. ������");

			

			switch (sc.nextInt()) {
			case 1:
				e.empInput();
				break;
			case 2:
				modifyMenu(e);
				break;
			case 3: e = new Employee();
				break;
			case 4:
				e.empOutput();
				break;
			case 9:
				System.out.println("������ �����Ͻðڽ��ϱ�? (y/n) : ");
				if (sc.next().toUpperCase().charAt(0) == 'Y'){
					return;
				}
			default:
				return;
			}
		} while(true);

	}

	public static void modifyMenu(Employee e) {
		do {
			System.out.println("1. �̸� ����");
			System.out.println("2. �޿� ����");
			System.out.println("3. �μ� ����");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� �޴��� �̵�");

			

			switch (sc.nextInt()) {
			case 1:
				System.out.println("�̸��� �Է����ּ���");
				e.setEmpName(sc.next());
				break;
			case 2:
				System.out.println("�޿��� �Է����ּ���");
				e.setSalary(sc.nextInt());
				break;
			case 3:
				System.out.println("�ҼӺμ��� �Է����ּ���");
				e.setDept(sc.next());
				break;
			case 4:
				System.out.println("������ �Է����ּ���");
				e.setJob(sc.next());
				break;
			case 5:
				return;
			default:
				continue;
			}
		} while (true);

	}
}