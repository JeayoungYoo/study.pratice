package account;

public class AccountTest2 {

	public static void main(String[] args) {
		Account[] account = new Account[5];
		
		for (int i=0; i<account.length; i++) {
			account[i] = new Account("221-0101-2111", 100000, 4.5);
			System.out.println(account[i].toString());
		}
		for (int i=0; i<account.length; i++) {
			account[i].setInterestRate(3.7);
			System.out.println(account[i].toString() + " ÀÌÀÚ: " + account[i].calculateInterest() + "");
		}

	}

}
