package com.practice1.controller;

import com.practice1.model.vo.Book;

import inherit.sample.Circle;

public class TestSilsub1 {
	public static void main(String[] args){
		
		Book bk = new Book("�Ͼ��Ͼ�", "�ܼ̿�", 15000);
		Book bk1 = new Book("�ڹ�������", "���ü�", 30000);
		
		System.out.println(bk.toString()+"\n"+bk1.toString());
		System.out.println(bk.equals(bk1));
		
		
		
		Book copybk = (Book)bk.clone();
		
		System.out.println("bk�� copybk�� �ּҰ� ����? " + (bk.hashCode()==copybk.hashCode()));
		System.out.println("bk�� copybk�� ������ ����? " + bk.toString().equals(copybk.toString()));
		
		
	}
}
