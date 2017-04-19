package oop.practice.controller;

import oop.practice.model.Book;

public class TestBook {

	public static void main(String[] args) {
		Book book = new Book();
		Book book2 = new Book("¿·¿ª ¿Øπﬂ«œ¥¬ JAVA" , 20000 , 0.2 , "±Ë¿±øµ");
		
		book.bookInfomation();
		book2.bookInfomation();

	}

}
