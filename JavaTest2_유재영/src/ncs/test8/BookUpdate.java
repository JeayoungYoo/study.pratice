package ncs.test8;

import ncs.test7.Book;

public class BookUpdate {
	private Book book;
	
	public BookUpdate(){}

	public BookUpdate(Book book) {
		this.book = book;
	}
	
	public Book getBookData(){
		return book;
	}
	
	public void updataBookPrice(){
		book.setBookPrice((int)book.getBookPrice()-(book.getBookPrice()*book.getBookDiscountRate()));
		
	}
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
