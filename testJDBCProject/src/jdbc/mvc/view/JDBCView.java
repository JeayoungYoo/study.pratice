package jdbc.mvc.view;

import java.util.*;

import jdbc.mvc.controller.JDBCController;
import jdbc.mvc.model.vo.Employee;

public class JDBCView {
	private Scanner sc = new Scanner(System.in);
	private JDBCController controller;
	
	public JDBCView(){}
	
	public void  displayMenu(){
		int no;
		controller = new JDBCController();
		
		do {
			System.out.println("JDBC 테스트 프로그램");
			System.out.println();
			System.out.println("1. 새 직원 등록");
			System.out.println("2. 전체 직원 조회");
			System.out.println("3. 사번으로 직원 조회");
			System.out.println("4. 직원 정보 수정");
			System.out.println("5. 직원 삭제");
			System.out.println("9. 끝내기");
			System.out.print("번호 선택 : ");
			no = sc.nextInt();
			
			switch(no){
			case 1: controller.insertEmployee(input());
					break;
			
			case 2: printList(controller.selectList());
					break;
			
			case 3: printOne(controller.selectEmployee(inputEmpId()));
					break;
			
			case 4: controller.updateEmployee(update());
					break;
			
			case 5: controller.deleteEmployee(delete());
					break;
			
			case 9:	System.out.println("정말로 종료하시겠습니까? (y/n) : ");
					if ((sc.next().toUpperCase().charAt(0)) == 'Y')
						return;
					else
						break;
			
			default : System.out.println("번호 선택이 잘못 되었습니다.");
					  System.out.println("다시 입력하십시오.\n");
				
			}
		}
		while(true);
	}
	
	private void printOne(Employee e) {
		System.out.println(e);
		
	}

	private String inputEmpId() {
		System.out.print("조회할 사번 : ");
		return sc.next();
	}

	private void printList(ArrayList<Employee> selectList) {
		for (Employee e : selectList)
			System.out.println(e);
		
	}

	private String delete() {
		System.out.println("\n삭제할 직원정보를 입력하시오. \n");
		
		System.out.print("삭제할 사번 : ");
		return sc.next();
		
	}

	private Employee update() {
		Employee emp = new Employee();
		
		System.out.println("\n수정할 직원정보를 입력하시오. \n");
		
		System.out.print("수정할 사번 : ");
		emp.setEmpid(sc.next());
		System.out.print("직급코드 : ");
		emp.setJobid(sc.next().toUpperCase());
		System.out.print("급여 : ");
		emp.setSalary(sc.nextInt());
		System.out.print("보너스포인트 : ");
		emp.setBonuspct(sc.nextDouble());
		System.out.println("부서 코드 : ");
		emp.setDeptid(sc.next());
		
		return emp;
	}

	// 새 직원정보 입력용 메소드
	public Employee input(){
		Employee emp = new Employee();
		
		System.out.println("\n 새 직원정보를 입력하시오. \n");
		
		System.out.print("사번 : ");
		emp.setEmpid(sc.next());
		System.out.print("이름 : ");
		emp.setEmpname(sc.next());
		System.out.print("주민번호 : ");
		emp.setEmpno(sc.next());
		System.out.print("메일 : ");
		emp.setEmail(sc.nextLine()+sc.nextLine());
		System.out.print("전화번호 : ");
		emp.setPhone(sc.next());
		System.out.print("직급코드 : ");
		emp.setJobid(sc.next().toUpperCase());
		System.out.print("월급 : ");
		emp.setSalary(sc.nextInt());
		System.out.print("보너스포인트 : ");
		emp.setBonuspct(sc.nextDouble());
		System.out.print("결혼여부(y/n) : ");
		emp.setMarriage(sc.next().toUpperCase());
		System.out.print("관리자 사번 : ");
		emp.setMgrid(sc.next());
		System.out.println("부서 이름 : ");
		emp.setDeptid(sc.next());
		
		return emp;
	}

	public void error() {
		System.out.println("직원 정보 추가/수정/삭제 에러 발생");
		displayMenu();
		// TODO Auto-generated method stub
		
	}
	
}
