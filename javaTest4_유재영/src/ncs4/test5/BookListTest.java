package ncs4.test5;

import java.io.*;
import java.util.*;

public class BookListTest {

	public static void main(String[] args) {
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
	
	public void saveFile(List<Book> list){
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
			for (int i=0; i<list.size(); i++)
				oos.writeObject((Book)list.get(i));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("������.����");
	}
	
	public List<Book> loadFile() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"))) {
			List<Book> list = new ArrayList<Book>();
			while(true) {
				list.add((Book) ois.readObject());
				return list;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	public void printList (List<Book> list) {
		for (Book book : list) { 
			System.out.println(book);
			System.out.println("���ε� ���� : " + (int)(book.getPrice() - (book.getPrice()*book.getDiscountRate())));
		}
	}

}
