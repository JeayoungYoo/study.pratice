package practice2;

import java.util.Scanner;

public class TestBookManager {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {
		BookManager bm = new BookManager();

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
				bm.addBook(inputBook());
				break;
			case 2:
				bm.printBookList(bm.sortedBookList());
				break;
			case 3:
				System.out.print("삭제 하실 인덱스 번호 입력 : ");
				bm.deleteBook(Integer.parseInt(inputBookTitle()));
				break;
			case 4:
				System.out.print("검색하실 책 제목 입력 : ");
				bm.searchBook(inputBookTitle());
				break;
			case 5:
				bm.displayAll();
				break;
			case 6:
				return;
			}

		} while (true);
	}

	public static Book inputBook() {
		Book book;
		String bNo;
		int category;
		String title;
		String author;

		System.out.print("도서번호를 입력하세요 : ");
		bNo = sc.next();
		System.out.print("도서분류코드 입력 : ");
		category = sc.nextInt();
		System.out.print("책 제목 : ");
		title = sc.next();
		System.out.print("저자 : ");
		author = sc.next();

		return book = new Book(bNo, category, title, author);

	}
	public static String inputBookTitle(){
		String input = sc.next();
		return input;
		
	}

}
