package practice3;

import java.util.Scanner;

import practice2.Book;

public class TestBookManagerMap {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		BookManagerMap bm = new BookManagerMap();

		do {
			System.out.println("1. �� ���� �߰�");
			System.out.println("2. �������� ������ ���");
			System.out.println("3. ���� ����");
			System.out.println("4. ���� �˻����");
			System.out.println("5. ��ü ���");
			System.out.println("6. ������");
			System.out.print("��ȣ �Է� : ");
			int num=sc.nextInt();
			switch (num) {
			case 1:
				bm.putBook(inputBook());
				break;
			case 2:
				bm.printBookMap(bm.sortedBookMap());
				break;
			case 3:
				System.out.print("���� �Ͻ� �ε��� ��ȣ �Է� : ");
				bm.removeBook(inputBookTitle());
				break;
			case 4:
				System.out.print("�˻��Ͻ� å ���� �Է� : ");
				bm.printBook(bm.searchBook(inputBookTitle()));
				break;
			case 5:
				bm.displayAll();
				break;
			case 6:
				System.exit(0);
//				return;
			}

		} while (true);
	}

	public static Book inputBook() {
		String bNo;
		int category;
		String title;
		String author;

		System.out.print("������ȣ�� �Է��ϼ��� : ");
		bNo = sc.next();
		System.out.print("�����з��ڵ� �Է�\n(1.�ι� /2.�ڿ����� /3.�Ƿ� /4.��Ÿ) : ");
		category = sc.nextInt();
		System.out.print("å ���� : ");
		title = sc.nextLine()+sc.nextLine();
		System.out.print("���� : ");
		author = sc.nextLine()+sc.nextLine();

		return new Book(bNo, category, title, author);

	}
	public static String inputBookTitle(){
		String input = sc.next();
		return input;
		
	}

}
