package ncs.test8;

public class UserTest {

	public static void main(String[] args) {
		User[] users = new User[3];
		
		users[0] = new User("user01", "pass01", "��ö��", 32, 'M', "010-1234-5678");
		users[1] = new User("user02", "pass02", "�̿���", 25, 'F', "010-5555-7777");
		users[2] = new User("user03", "pass03", "Ȳ����", 20, 'F', "010-9874-5632");
		
		User[] copyUsers = new User[users.length];
		copyUsers = (User[])users.clone();
		
		System.out.println("users list ---------------------------------------");
		for(int i=0; i<users.length; i++)
			System.out.println(users[i].toString());
		
		System.out.println("copyUsers ---------------------------------------");
		for(int i=0; i<copyUsers.length; i++)
			System.out.println(copyUsers[i].toString());
		
		System.out.println("�񱳰�� -------------------------------------------");
		for (int i=0; i<users.length; i++)
			System.out.println(users[i].equals(copyUsers[i]));
	}

}
