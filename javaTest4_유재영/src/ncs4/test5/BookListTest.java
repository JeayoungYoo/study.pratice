package ncs4.test5;

import java.io.*;
import java.util.*;

public class BookListTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BookListTest test5 = new BookListTest();
		ArrayList<Book> list = new ArrayList<Book>();
		
		test5.storeList(list);
		
		test5.saveFile(list);
		
		List<Book> booksList = test5.loadFile();
		
		test5.printList(booksList);

	}
	
	public void storeList(List<Book> list){
		list.add(new Book("�ڹ��� ����", "���ü�", 30000, "��������", 0.15));
		list.add(new Book("�������� �ڹ�", "������", 29000, "������", 0.2));
		list.add(new Book("��ü���� JAVA8", "�ݿ���", 30000, "�Ͻ�Ȩ", 0.1));
		System.out.println(list);
		
	}
	
	public void saveFile(List<Book> list) throws FileNotFoundException, IOException {
		String fileName = "books.dat";
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(fileName));
			objOut.writeObject(list);
			objOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public List<Book> loadFile() {
		List<Book> list = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"))) {
			list = (List<Book>) ois.readObject();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
		
	}
	
	public void printList (List<Book> list) {
		for (Book book : list) { 
			System.out.println(book);
			System.out.println("���ε� ���� : " + (int)(book.getPrice() - (book.getPrice()*book.getDiscountRate())));
			
		}
	}

}
