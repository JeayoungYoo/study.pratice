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
			System.out.println("JDBC �׽�Ʈ ���α׷�");
			System.out.println();
			System.out.println("1. �� ���� ���");
			System.out.println("2. ��ü ���� ��ȸ");
			System.out.println("3. ������� ���� ��ȸ");
			System.out.println("4. ���� ���� ����");
			System.out.println("5. ���� ����");
			System.out.println("9. ������");
			System.out.print("��ȣ ���� : ");
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
			
			case 9:	System.out.println("������ �����Ͻðڽ��ϱ�? (y/n) : ");
					if ((sc.next().toUpperCase().charAt(0)) == 'Y')
						return;
					else
						break;
			
			default : System.out.println("��ȣ ������ �߸� �Ǿ����ϴ�.");
					  System.out.println("�ٽ� �Է��Ͻʽÿ�.\n");
				
			}
		}
		while(true);
	}
	
	private void printOne(Employee e) {
		System.out.println(e);
		
	}

	private String inputEmpId() {
		System.out.print("��ȸ�� ��� : ");
		return sc.next();
	}

	private void printList(ArrayList<Employee> selectList) {
		for (Employee e : selectList)
			System.out.println(e);
		
	}

	private String delete() {
		System.out.println("\n������ ���������� �Է��Ͻÿ�. \n");
		
		System.out.print("������ ��� : ");
		return sc.next();
		
	}

	private Employee update() {
		Employee emp = new Employee();
		
		System.out.println("\n������ ���������� �Է��Ͻÿ�. \n");
		
		System.out.print("������ ��� : ");
		emp.setEmpid(sc.next());
		System.out.print("�����ڵ� : ");
		emp.setJobid(sc.next().toUpperCase());
		System.out.print("�޿� : ");
		emp.setSalary(sc.nextInt());
		System.out.print("���ʽ�����Ʈ : ");
		emp.setBonuspct(sc.nextDouble());
		System.out.println("�μ� �ڵ� : ");
		emp.setDeptid(sc.next());
		
		return emp;
	}

	// �� �������� �Է¿� �޼ҵ�
	public Employee input(){
		Employee emp = new Employee();
		
		System.out.println("\n �� ���������� �Է��Ͻÿ�. \n");
		
		System.out.print("��� : ");
		emp.setEmpid(sc.next());
		System.out.print("�̸� : ");
		emp.setEmpname(sc.next());
		System.out.print("�ֹι�ȣ : ");
		emp.setEmpno(sc.next());
		System.out.print("���� : ");
		emp.setEmail(sc.nextLine()+sc.nextLine());
		System.out.print("��ȭ��ȣ : ");
		emp.setPhone(sc.next());
		System.out.print("�����ڵ� : ");
		emp.setJobid(sc.next().toUpperCase());
		System.out.print("���� : ");
		emp.setSalary(sc.nextInt());
		System.out.print("���ʽ�����Ʈ : ");
		emp.setBonuspct(sc.nextDouble());
		System.out.print("��ȥ����(y/n) : ");
		emp.setMarriage(sc.next().toUpperCase());
		System.out.print("������ ��� : ");
		emp.setMgrid(sc.next());
		System.out.println("�μ� �̸� : ");
		emp.setDeptid(sc.next());
		
		return emp;
	}

	public void error() {
		System.out.println("���� ���� �߰�/����/���� ���� �߻�");
		displayMenu();
		// TODO Auto-generated method stub
		
	}
	
}
