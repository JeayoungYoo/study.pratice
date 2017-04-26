package com.practice1.controller;

import com.practice1.model.vo.Book;

import inherit.sample.Circle;

public class TestSilsub1 {
	public static void main(String[] args){
		
		Book bk = new Book("하앍하앍", "이외수", 15000);
		Book bk1 = new Book("자바의정석", "남궁성", 30000);
		
		System.out.println(bk.toString()+"\n"+bk1.toString());
		System.out.println(bk.equals(bk1));
		
		
		
		Book copybk = (Book)bk.clone();
		
		System.out.println("bk와 copybk의 주소가 같냐? " + (bk.hashCode()==copybk.hashCode()));
		System.out.println("bk와 copybk의 내용이 같냐? " + bk.toString().equals(copybk.toString()));
		
		
	}
}
