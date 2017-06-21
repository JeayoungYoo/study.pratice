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
			//����
			System.out.println(result + "���� �߰��Ǿ����ϴ�.");
			new JDBCView().displayMenu();
		}
		else {
			//����
			System.out.println("�� ���� �߰� ��� ����!!");
			new JDBCView().error();
		}
	}
	
	public void updateEmployee(Employee e) {
		int result = new EmployeeDAO2().updateEmployee(e);
		
		if (result > 0) {
			//����
			System.out.println(result + "���� �����Ǿ����ϴ�.");
			new JDBCView().displayMenu();
		}
		else {
			//����
			System.out.println("�� ���� ���� ����!!");
			new JDBCView().error();
		}
	}
	
	public void deleteEmployee(String empId) {
		int result = new EmployeeDAO2().deleteEmployee(empId);
		
		if (result > 0) {
			//����
			System.out.println(result + "���� �����Ǿ����ϴ�.");
			new JDBCView().displayMenu();
		}
		else {
			//����
			System.out.println("�� ���� ���� ����!!");
			new JDBCView().error();
		}
	}
}
