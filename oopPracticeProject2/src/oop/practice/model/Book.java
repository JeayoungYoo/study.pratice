package oop.practice.model;

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
	
	public void settitle(String etitle)
	{
	    this.title = etitle;
	}
	public void setprice(int eprice){
		this.price = eprice;
	}
	
	public void setdiscoutRate(double ediscountRate){
		this.discountRate = ediscountRate;
	}
	public void setauthor(String eauthor){
		this.author = eauthor;
	}
	
	
	public void bookInfomation(){
		System.out.println(this.title + "\t" + this.price + "\t" + this.discountRate + "\t" + this.author);
	}

}
