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
			System.out.println("1. 새 사원 정보 입력");
			System.out.println("2. 사원 정보 수정");
			System.out.println("3. 사원 정보 삭제");
			System.out.println("4. 사원정보 출력");
			System.out.println("9. 끝내기");

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
				System.out.println("정말로 종료하시겠습니까? (y/n)");
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
			System.out.println("1. 이름 변경");
			System.out.println("2. 급여 변경");
			System.out.println("3. 부서 변경");
			System.out.println("4. 직급 변경");
			System.out.println("5. 이전 메뉴로 이동");

			int num = sc.nextInt();

			switch (num) {
			case 1:
				System.out.println("이름을 입력해주세요");
				e.setEmpName(sc.next());
				break;
			case 2:
				System.out.println("급여를 입력해주세요");
				e.setSalary(sc.nextInt());
				break;
			case 3:
				System.out.println("소속부서를 입력해주세요");
				e.setDept(sc.next());
				break;
			case 4:
				System.out.println("직급을 입력해주세요");
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