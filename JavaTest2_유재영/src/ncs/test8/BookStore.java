package ncs.test8;

import ncs.test7.Book;

public class BookStore {

	public static void main(String[] args) {
		Book bookdata;
		BookUpdate bu;
		
		bookdata = new Book("", "HTML5", 30000, 0.15);
		
		//�������� ������ ������ �������뿡 ��ü �⺻���� ��� ���־ �۾��߽��ϴ�.
		System.out.println(bookdata.toString());
		System.out.println();
		
		bu = new BookUpdate(bookdata);
		bu.getBookData();
		
		System.out.println("���� ����");
		System.out.println(bookdata.getBookName() + "\t" + bookdata.getBookPrice());
		bu.updataBookPrice();
		System.out.println("����� ����");
		System.out.println(bu.getBookData().getBookName() + "\t" + bu.getBookData().getBookPrice());
		
	}

}
