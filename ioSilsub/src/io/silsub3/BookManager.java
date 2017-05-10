package io.silsub3;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;




public class BookManager{
	Scanner sc = new Scanner(System.in);

	public BookManager() {
		super();
		
	}
	
	public void fileSave(){
			Book[] book = new Book[5];
			try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
			
			objOut.writeObject(book[0] = new Book("�ڹ�������", "������", 30000, new GregorianCalendar(1991, 1, 1), 0.5));
			
			objOut.writeObject(book[1] = new Book("�Ͼ��Ͼ�", "������", 45000, new GregorianCalendar(1992, 2, 2), 0.2));
			
			objOut.writeObject(book[2] = new Book("���� ���� �˰��ִ�", "������", 30000, new GregorianCalendar(1993, 3, 3), 0.1));
			
			objOut.writeObject(book[3] = new Book("��������", "���", 15000, new GregorianCalendar(1994, 4, 4), 0.3));
			
			objOut.writeObject(book[4] = new Book("����ó", "���̺��", 10000, new GregorianCalendar(1995, 5, 5), 0.05));
			
/*			for(Book b : books)
				objOut.writeObject(b);*/
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fileRead(){

		try(ObjectInputStream objin = new ObjectInputStream(new FileInputStream("books.dat"))) {
			Book[] book = new Book[10]; 
			
			do{
				System.out.println(objin.readObject());
			}while(true);
			
		} catch (EOFException e) {
			System.out.printf("books.dat �б� �Ϸ�!");
			
			
		} catch (IOException e) {
			System.out.println("score.dat ���� �б� ����...");
		} catch (Exception e) {
			
		}
	}
	
}
