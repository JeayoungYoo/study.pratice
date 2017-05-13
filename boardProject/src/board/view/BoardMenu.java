package board.view;

import java.util.Scanner;

import board.controller.BoardManager;

public class BoardMenu {
	Scanner sc = new Scanner(System.in);
	// ■ static으로 선언해야하는지는 아직 모르겠습니다.
	static BoardManager bmg = new BoardManager();

	public BoardMenu() {
	}

	public void mainMenu() {
		BoardMenu bm = new BoardMenu();

		do {
			System.out.println("******* 게시글 서비스 프로그램 *******");
			System.out.println("1. 게시글 쓰기");
			System.out.println("2. 게시글 전체 보기");
			System.out.println("3. 게시글 한개 보기");
			System.out.println("4. 게시글 제목 수정");
			System.out.println("5. 게시글 내용 수정");
			System.out.println("6. 게시글 삭제");
			System.out.println("7. 게시글 검색");
			System.out.println("8. 파일에 저장하기");
			System.out.println("9. 정렬하기");
			System.out.println("10. 끝내기");
			System.out.println("메뉴 번호 선택 : ");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				// BoardManager의 writeBoard() 실행
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
				// BookMenu 의 sortSubMenu() 실행
				bm.sortSubMenu();
				break;
			case 10:
				return;
			}
		} while (true);
	}

	public void sortSubMenu() {

		System.out.println("****** 게시글 정렬 메뉴 ****");
		System.out.println("1. 글번호순 오름차순정렬");
		System.out.println("2. 글번호순 내림차순정렬");
		System.out.println("3. 작성날짜순 오름차순정렬");
		System.out.println("4. 작성날짜순 내림차순정렬");
		System.out.println("5. 글제목순 오름차순정렬");
		System.out.println("6. 글제목순 내림차순정렬");
		System.out.println("7. 이전 메뉴로 이동");
		System.out.println("메뉴 번호 : ");
		int menu = sc.nextInt();

		switch (menu) {
		case 1:
			// BoardManager 의 sortList(1, false) 실행
			bmg.sortList(1, false);
			break;
		case 2:
			// sortList(1, true) 실행
			bmg.sortList(1, true);
			break;
		case 3:
			// sortList(2, false) 실행
			bmg.sortList(2, false);
			break;
		case 4:
			// sortList(2, true) 실행
			bmg.sortList(2, true);
			break;
		case 5:
			// sortList(3, false) 실행
			bmg.sortList(3, false);
			break;
		case 6:
			// sortList(3, true) 실행
			bmg.sortList(3, true);
			break;
		case 7:
			// return 처리
			return;
		}
	}
}
