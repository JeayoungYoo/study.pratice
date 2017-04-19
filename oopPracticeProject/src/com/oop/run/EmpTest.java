package com.oop.run;

import java.util.Scanner;

import com.oop.model.dto.Employee;

public class EmpTest {

	public static void main(String[] args) {
		mainMenu();
	}

	public static void mainMenu() {

		Employee e = new Employee();
		char flag;

		do {
			System.out.println("1. �� ��� ���� �Է�");
			System.out.println("2. ��� ���� ����");
			System.out.println("3. ��� ���� ����");
			System.out.println("4. ������� ���");
			System.out.println("9. ������");

			int num = new Scanner(System.in).nextInt();

			switch (num) {
			case 1:
				e.empInput();
				break;
			case 2:
				modifyMenu(e);
				break;
			case 3: Employee e1 = new Employee();
				break;
			case 4:
				e.empOutput();
				break;
			case 9:
				System.out.println("������ �����Ͻðڽ��ϱ�? (y/n)");
				flag = new Scanner(System.in).next().charAt(0);
				if (flag == 'y')
					break;
			default:
				continue;
			}
		} while (true);

	}

	public static void modifyMenu(Employee e) {
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("1. �̸� ����");
			System.out.println("2. �޿� ����");
			System.out.println("3. �μ� ����");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� �޴��� �̵�");

			int num = sc.nextInt();

			switch (num) {
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