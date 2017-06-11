package compony;

public class Compony {
	private double salary;
	private double annualIncome;
	private double income;
	private double bonus;
	private double afterTaxBonus;
	public Compony() {
		super();
	}
	public Compony(double salary) {
		super();
		this.salary = salary;
	}
	public double getSalary() {
		return salary * 12;
	}
	public double getAnnualIncome() {
		this.annualIncome = this.getIncome() + this.getAfterTaxBonus();
		return annualIncome;
	}
	public double getIncome() {
		return this.getSalary()-(this.getSalary() * 0.1);
	}
	public double getBonus() {
		this.bonus = (salary * 0.2) * 4; 
		return bonus; 
	}
	public double getAfterTaxBonus() {
		return this.getBonus()-(this.getBonus() * 0.055);
	}
	
	
}
