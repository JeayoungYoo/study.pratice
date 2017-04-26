package com.practice1.model.vo;

public class Book {
	private String title;
	private String author;
	private int price;
	
	public Book(){}
	
	public Book(String title, String author, int price){
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "제목 : " + this.title + "\t작가 : " + this.author + "\t가격 : " + this.price;
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		Book other = (Book) obj;
		
		if(this.title.equals(other.title) && this.author == other.author && this.price == other.price)
			result = true;
		
		return result;
	}

	@Override
	public Object clone(){
		Book bk = new Book();
		bk.title = this.title;
		bk.author = this.author;
		bk.price = this.price;
		return bk;
	}
	
	
	
}
