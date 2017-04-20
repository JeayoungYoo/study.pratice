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
			System.out.println("1. 새 사원 정보 입력");
			System.out.println("2. 사원 정보 수정");
			System.out.println("3. 사원 정보 삭제");
			System.out.println("4. 사원정보 출력");
			System.out.println("9. 끝내기");

			

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
				System.out.println("정말로 종료하시겠습니까? (y/n) : ");
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
			System.out.println("1. 이름 변경");
			System.out.println("2. 급여 변경");
			System.out.println("3. 부서 변경");
			System.out.println("4. 직급 변경");
			System.out.println("5. 이전 메뉴로 이동");

			

			switch (sc.nextInt()) {
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