package ncs.test4;

import java.util.Scanner;

public class NoticeTest {

	public static void main(String[] args) {
		Object[] obArray = new Object[3];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����� ���������� �Է��Ͻÿ�. (3�� �ݺ� �Է� ó����)");
		
		String title=null, author=null, contents=null;
		for (int i=0; i<obArray.length; i++) {
			System.out.print("���� : ");
			title = sc.nextLine();
			System.out.print("�ۼ��� : ");
			author = sc.next();
			System.out.print("���� : ");
			contents = sc.nextLine() + sc.nextLine();
			
//			obArray[i] = new Object(title, author, contents);
		}

	}

}
