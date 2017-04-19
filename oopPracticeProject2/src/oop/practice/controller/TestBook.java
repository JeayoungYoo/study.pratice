package oop.practice.controller;

import oop.practice.model.Book;

public class TestBook {

	public static void main(String[] args) {
		Book book = new Book();
		Book book2 = new Book("잠을 유발하는 JAVA" , 20000 , 0.2 , "김윤영");
		
		book.bookInfomation();
		book2.bookInfomation();
		
		book.setTitle("자바의 정석");
		book.setPrice(35000);
		book.setDiscoutRate(0.1);
		book.setAuthor("윤상섭");
		
		/*int discountPrice1 = book.calculator();
		int discountPrice2 = book2.calculator();*/
		
		
		System.out.println("도서명 : " + book.getTitle());
//		System.out.println("할인된 가격 : " + discountPrice1 + " 원");
		System.out.println("할인된 가격 : " + book.calculator());
		System.out.println("도서명 : " + book2.getTitle());
		System.out.println("할인된 가격 : " + book2.calculator());
//		System.out.println("할인된 가격 : " + discountPrice2 + " 원");
		
		
		
	}

}
