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
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서정보 정렬후 출력");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 검색출력");
			System.out.println("5. 전체 출력");
			System.out.println("6. 끝내기");
			System.out.print("번호 입력 : ");
			int num=sc.nextInt();
			switch (num) {
			case 1:
				bm.putBook(inputBook());
				break;
			case 2:
				bm.printBookMap(bm.sortedBookMap());
				break;
			case 3:
				System.out.print("삭제 하실 인덱스 번호 입력 : ");
				bm.removeBook(inputBookTitle());
				break;
			case 4:
				System.out.print("검색하실 책 제목 입력 : ");
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

		System.out.print("도서번호를 입력하세요 : ");
		bNo = sc.next();
		System.out.print("도서분류코드 입력\n(1.인문 /2.자연과학 /3.의료 /4.기타) : ");
		category = sc.nextInt();
		System.out.print("책 제목 : ");
		title = sc.nextLine()+sc.nextLine();
		System.out.print("저자 : ");
		author = sc.nextLine()+sc.nextLine();

		return new Book(bNo, category, title, author);

	}
	public static String inputBookTitle(){
		String input = sc.next();
		return input;
		
	}

}
