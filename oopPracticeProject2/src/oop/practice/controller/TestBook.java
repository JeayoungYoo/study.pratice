package oop.practice.controller;

import oop.practice.model.Book;

public class TestBook {

	public static void main(String[] args) {
		Book book = new Book();
		Book book2 = new Book("���� �����ϴ� JAVA" , 20000 , 0.2 , "������");
		
		book.bookInfomation();
		book2.bookInfomation();
		
		book.setTitle("�ڹ��� ����");
		book.setPrice(35000);
		book.setDiscoutRate(0.1);
		book.setAuthor("����");
		
		/*int discountPrice1 = book.calculator();
		int discountPrice2 = book2.calculator();*/
		
		
		System.out.println("������ : " + book.getTitle());
//		System.out.println("���ε� ���� : " + discountPrice1 + " ��");
		System.out.println("���ε� ���� : " + book.calculator());
		System.out.println("������ : " + book2.getTitle());
		System.out.println("���ε� ���� : " + book2.calculator());
//		System.out.println("���ε� ���� : " + discountPrice2 + " ��");
		
		
		
	}

}
