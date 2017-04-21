package com.oop.array3.model;

public class Book {
	
	private String title;
	private int price;
	private double discountRate;
	private String author;
	
	
	public Book(){}
	
	public Book(String title, int price, double discountRate, String author){
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	}
	
	//할인율 적용 가격 계산 처리용 메소드
	public int calculator(){

		return (price - (int)(price*discountRate));
	}
	
	public void setTitle(String etitle)
	
	{
	    this.title = etitle;
	}
	public void setPrice(int eprice){
		this.price = eprice;
	}
	
	public void setDiscoutRate(double ediscountRate){
		this.discountRate = ediscountRate;
	}
	public void setAuthor(String eauthor){
		this.author = eauthor;
	}
	
	
	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public String getAuthor() {
		return author;
	}

	public void bookInfomation(){
		System.out.println(this.title + "\t" + this.price + "\t" + this.discountRate + "\t" + this.author);
	}

}
