package ncs.test10;

public class Company {

	public static void main(String[] args) {
		Employee[] employees = new Employee[2];
		employees[0] = new Secretary("Hilery", 1, "secretary", 800);
		employees[1] = new Sales("Clinten", 2, "sales", 1200);
		
		System.out.println("name\tdepartment\tsalary");
		System.out.println("-------------------------------------");
		
		for(int i=0; i<employees.length; i++)
			System.out.println(employees[i].getName()+"\t"+employees[i].getDepartment()+"\t"+employees[i].getSalary());
				
		System.out.println();
		System.out.println("�μ�Ƽ�� 100 ����");
		((Secretary) employees[0]).incentive(100);
		((Sales) employees[1]).incentive(100);
		
		System.out.println("name\tdepartment\tsalary\ttax");
		System.out.println("------------------------------------------");
		
		for(int i=0; i<employees.length; i++)
			System.out.println(employees[i].getName()+"\t"+employees[i].getDepartment()+"\t"+employees[i].getSalary()+"\t"+employees[i].tax());
		
		

	}

}
