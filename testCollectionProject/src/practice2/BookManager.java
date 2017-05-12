package practice2;

import java.util.*;

public class BookManager {
	private ArrayList bookList;
	
	
	public BookManager() {
		bookList  = new ArrayList();
	}
	
	public BookManager(ArrayList bookList) {
		this.bookList = new ArrayList(bookList);
	}
	
	public void addBook(Book book){
		bookList.add(book);
	}
	
	public void deleteBook(int index){
		bookList.remove(index);
	}
	
	public int searchBook(String bTitle){
	      int index = -1;
	      for (int i=0; i<bookList.size(); i++){
	         if (bTitle.equals(((Book)this.bookList.get(i)).getTitle())) {
	            return i;
	         }
	      }
	      return index;
	   }
	
	public void printBook(int index){
		System.out.println(bookList.get(index).toString());
	}
	
	public void displayAll(){
		System.out.println(bookList.toString());
	}
	public Book[] sortedBookList(){
	      bookList.sort(new AscCategory());
	      return (Book[]) bookList.toArray(new Book[0]);
	   }
	   
	   public void printBookList(Book[] br){
	      //Object[] objArr = bookList.toArray();
	      //for (Object obj : objArr)
	      //   System.out.println(objArr);
	      for (Book b : br) {
	         System.out.println(b.toString());
	      }
	   }
	/*public Book[] sortedBookList(){
		bookList.sort(new AscCategory());
		Book[] book = (Book[]) bookList.toArray();
		return book;
	}
	
	public void printBookList(Book[] br){
		Object[] objArr = bookList.toArray();
		for (Object obj : objArr)
			System.out.println(objArr);
	}*/
}
