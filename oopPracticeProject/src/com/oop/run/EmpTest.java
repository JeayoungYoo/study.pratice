package com.oop.run;

import java.util.Scanner;

import com.oop.model.dto.Employee;

public class EmpTest {
	
	public static void main(String[] args) {
		

	}
	
	public static void mainMenu(){
		Employee e = new Employee();
		System.out.println("1. 새 사원 정보 입력");
		System.out.println("2. 사원 정보 수정");
		System.out.println("3. 사원 정보 삭제");
		System.out.println("4. 사원정보 출력");
		System.out.println("9. 끝내기");
		
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
		System.out.println("1. 이름 변경");
		System.out.println("2. 급여 변경");
		System.out.println("3. 부서 변경");
		System.out.println("4. 직급 변경");
		System.out.println("5. 이전 메뉴로 이동");
		
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
