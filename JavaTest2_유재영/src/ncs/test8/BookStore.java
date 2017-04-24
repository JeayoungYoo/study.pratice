package ncs.test8;

import ncs.test7.Book;

public class BookStore {

	public static void main(String[] args) {
		Book bookdata;
		BookUpdate bu;
		
		bookdata = new Book("", "HTML5", 30000, 0.15);
		
		bu = new BookUpdate(bookdata);
		bu.getBookData();

		System.out.println("기존 정보");
		System.out.println(bookdata.getBookName() + "\t" + bookdata.getBookPrice());
		
		bu.updataBookPrice();
		
		System.out.println("변경된 정보");
		System.out.println(bu.getBookData().getBookName() + "\t" + bu.getBookData().getBookPrice());
		
	}

}
