package compony;

public class Test02 {

	public static void main(String[] args) {
		int sal = Integer.parseInt(args[0]);
		Compony com = new Compony(sal);
	
		
		System.out.println("�� �⺻�� ��: " + com.getSalary() + "\t����: " + com.getIncome());
		System.out.println("�� ���ʽ� ��: " + com.getBonus() + "\t����: " + com.getAfterTaxBonus());
		System.out.println("�� ���޾� ��: " + com.getAnnualIncome());

	}

}
