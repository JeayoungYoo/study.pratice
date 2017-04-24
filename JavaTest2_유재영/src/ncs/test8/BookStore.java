package ncs.test8;

import ncs.test7.Book;

public class BookStore {

	public static void main(String[] args) {
		Book bookdata;
		BookUpdate bu;
		
		bookdata = new Book("", "HTML5", 30000, 0.15);
		
		//실행결과엔 써있지 않지만 구현내용에 객체 기본정보 출력 써있어서 작업했습니다.
		System.out.println(bookdata.toString());
		System.out.println();
		
		bu = new BookUpdate(bookdata);
		bu.getBookData();
		
		System.out.println("기존 정보");
		System.out.println(bookdata.getBookName() + "\t" + bookdata.getBookPrice());
		bu.updataBookPrice();
		System.out.println("변경된 정보");
		System.out.println(bu.getBookData().getBookName() + "\t" + bu.getBookData().getBookPrice());
		
	}

}
