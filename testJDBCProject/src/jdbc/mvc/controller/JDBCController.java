package jdbc.mvc.controller;

import java.util.ArrayList;

import jdbc.mvc.model.dao.EmployeeDAO;
import jdbc.mvc.model.dao.EmployeeDAO2;
import jdbc.mvc.model.vo.Employee;
import jdbc.mvc.view.JDBCView;
public class JDBCController {
	public JDBCController(){}
	
	public ArrayList<Employee> selectList(){
		return new EmployeeDAO2().selectAll();
	}
	
	public Employee selectEmployee(String empId) {
		return new EmployeeDAO2().selectOne(empId);
	}
	
	public void insertEmployee (Employee e) {
		int result = new EmployeeDAO2().insertEmployee(e);
		
		if (result > 0) {
			//성공
			System.out.println(result + "행이 추가되었습니다.");
			new JDBCView().displayMenu();
		}
		else {
			//실패
			System.out.println("새 직원 추가 등록 실패!!");
			new JDBCView().error();
		}
	}
	
	public void updateEmployee(Employee e) {
		int result = new EmployeeDAO2().updateEmployee(e);
		
		if (result > 0) {
			//성공
			System.out.println(result + "행이 수정되었습니다.");
			new JDBCView().displayMenu();
		}
		else {
			//실패
			System.out.println("새 직원 수정 실패!!");
			new JDBCView().error();
		}
	}
	
	public void deleteEmployee(String empId) {
		int result = new EmployeeDAO2().deleteEmployee(empId);
		
		if (result > 0) {
			//성공
			System.out.println(result + "행이 삭제되었습니다.");
			new JDBCView().displayMenu();
		}
		else {
			//실패
			System.out.println("새 직원 삭제 실패!!");
			new JDBCView().error();
		}
	}
}
