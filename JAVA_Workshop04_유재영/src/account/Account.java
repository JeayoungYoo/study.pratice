package account;

public class Account {
	private String account;
	private int balance;
	private double interestRate;
	public Account() {
		super();
	}
	public Account(String account, int balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public int getBalance() {
		return balance;
	}
	public double calculateInterest() {
		return Math.round(this.balance * (this.interestRate * 0.01)*10.0)/10.0;
	}
	
	public void deposit (int money) {
		this.balance += money;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public String toString() {
		return "°èÁÂ¹øÈ£: " + account + " ÀÜ¾×: " + balance + " ÀÌÀÚÀ²: " + interestRate + "%";
	}
	public void withdraw (int money) {
		this.balance -= money;
	}
}
