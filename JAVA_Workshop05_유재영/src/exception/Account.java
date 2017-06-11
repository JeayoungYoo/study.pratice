package exception;

public class Account {
	private String account;
	private double balance;
	private double interestRate;
	public Account() {
		super();
	}
	public Account(String account, double balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	public double calculateInterest () {
		return this.getBalance() * this.getInterestRate() * 0.01;
	}
	
	public void deposit (double money) throws Exception {
		if (money < 0) 
			throw new Exception("입금 금액이 0보다 적습니다");
		else
			this.setBalance(this.balance + money);
	}
	
	public void withdraw (double money) throws Exception {
		if ((money > this.getBalance()) || (money < 0))
			throw new Exception("금액이 0보다 적거나 현재 잔액보다 많습니다.");
		else
			this.setBalance(this.balance - money);
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public String toString() {
		return account + "\t" + balance + "\t" + interestRate;
	}
	
	
}
