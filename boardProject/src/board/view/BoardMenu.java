package board.view;

import java.util.Scanner;

import board.controller.BoardManager;

public class BoardMenu {
	Scanner sc = new Scanner(System.in);
	// �� static���� �����ؾ��ϴ����� ���� �𸣰ڽ��ϴ�.
	static BoardManager bmg = new BoardManager();

	public BoardMenu() {
	}

	public void mainMenu() {
		BoardMenu bm = new BoardMenu();

		do {
			System.out.println("******* �Խñ� ���� ���α׷� *******");
			System.out.println("1. �Խñ� ����");
			System.out.println("2. �Խñ� ��ü ����");
			System.out.println("3. �Խñ� �Ѱ� ����");
			System.out.println("4. �Խñ� ���� ����");
			System.out.println("5. �Խñ� ���� ����");
			System.out.println("6. �Խñ� ����");
			System.out.println("7. �Խñ� �˻�");
			System.out.println("8. ���Ͽ� �����ϱ�");
			System.out.println("9. �����ϱ�");
			System.out.println("10. ������");
			System.out.println("�޴� ��ȣ ���� : ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				// BoardManager�� writeBoard() ����
				bmg.writeBoard();
				break;
			case 2:
				// displayAllList()
				bmg.displayAllList();
				break;
			case 3:
				// displayBoard()
				bmg.displayBoard();
				break;
			case 4:
				// modifyTitle()
				bmg.modifyTitle();
				break;
			case 5:
				// modifyContent()
				bmg.modifyContent();
				break;
			case 6:
				// deleteBoard()
				bmg.deleteBoard();
				break;
			case 7:
				// searchBoard()
				bmg.searchBoard();
				break;
			case 8:
				// saveListFile()
				bmg.saveListFile();
				break;
			case 9:
				// BookMenu �� sortSubMenu() ����
				bm.sortSubMenu();
				break;
			case 10:
				return;
			}
		} while (true);
	}

	public void sortSubMenu() {

		System.out.println("****** �Խñ� ���� �޴� ****");
		System.out.println("1. �۹�ȣ�� ������������");
		System.out.println("2. �۹�ȣ�� ������������");
		System.out.println("3. �ۼ���¥�� ������������");
		System.out.println("4. �ۼ���¥�� ������������");
		System.out.println("5. ������� ������������");
		System.out.println("6. ������� ������������");
		System.out.println("7. ���� �޴��� �̵�");
		System.out.println("�޴� ��ȣ : ");
		int menu = sc.nextInt();

		switch (menu) {
		case 1:
			// BoardManager �� sortList(1, false) ����
			bmg.sortList(1, false);
			break;
		case 2:
			// sortList(1, true) ����
			bmg.sortList(1, true);
			break;
		case 3:
			// sortList(2, false) ����
			bmg.sortList(2, false);
			break;
		case 4:
			// sortList(2, true) ����
			bmg.sortList(2, true);
			break;
		case 5:
			// sortList(3, false) ����
			bmg.sortList(3, false);
			break;
		case 6:
			// sortList(3, true) ����
			bmg.sortList(3, true);
			break;
		case 7:
			// return ó��
			return;
		}
	}
}
