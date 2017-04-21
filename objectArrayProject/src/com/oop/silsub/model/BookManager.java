package com.oop.silsub.model;

import java.util.Scanner;

import com.oop.array2.model.Student;
import com.oop.array3.model.Book;

public class BookManager {
	private Book[] bar = new Book[]{};
	Scanner sc = new Scanner(System.in);
	private static int count=0;
	{
		bar = new Book[10];
	}
	
	public BookManager(){}

	public void menu() {
		
		do{
			System.out.println("1. ���� ���� �߰�");
			System.out.println("2. ��� ���");
			System.out.println("7. ������");
			
			switch(sc.nextInt()){
			case 1: bookInput(); break;
			case 2: bookAllOutput(); break;
			case 7: return;
			default : continue;
			}
		}while(true);		
	}

	public void bookAllOutput() {
		for (int i=0; i<count; i++){
			bar[i].bookInfomation();
		}
		
	}

	public void bookInput() {
		
		while(true){
			if(count==10)
				break;
			
			bar[count] = new Book();
			System.out.print("���� �Է��ϼ� : ");
			bar[count].setTitle(sc.next());
			System.out.print("�۰� �Է��� : ");
			bar[count].setAuthor(sc.next());
			System.out.print("���� �Է��� : ");
			bar[count].setPrice(sc.nextInt());
			System.out.print("������ �Է��� : ");
			bar[count].setDiscoutRate(sc.nextDouble());
			
			count++;
			return;
		}
		
	}
	

}
