package account;

public class AccountTest {

	public static void main(String[] args) {
		Account account;
		account = new Account("441-0290-1203", 500000, 7.3);
		System.out.println("��������: " + account.getAccount() + " �����ܾ�: " + account.getBalance());
		
		account.deposit(20000);
		System.out.println("��������: " + account.getAccount() + " �����ܾ�: " + account.getBalance());
		
		System.out.println("����: " + account.calculateInterest());
		

	}

}
