package exception;

public class AccountTest {

	public static void main(String[] args) {
		Account account;
		account = new Account("441-0290-1203", 500000, 7.3);
		System.out.println("계좌정보: " + account);
		
		try {
			account.deposit(-10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			account.withdraw(600000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("이자: " + account.calculateInterest());

	}

}
