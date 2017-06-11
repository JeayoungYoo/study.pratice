package compony;

public class Test02 {

	public static void main(String[] args) {
		int sal = Integer.parseInt(args[0]);
		Compony com = new Compony(sal);
	
		
		System.out.println("연 기본급 합: " + com.getSalary() + "\t세후: " + com.getIncome());
		System.out.println("연 보너스 합: " + com.getBonus() + "\t세후: " + com.getAfterTaxBonus());
		System.out.println("연 지급액 합: " + com.getAnnualIncome());

	}

}
