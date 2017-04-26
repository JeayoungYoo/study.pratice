package com.practice2.model.entity;

public class Rectangle extends Point{
	private int width;
	private int height;
	
	public Rectangle(){}
	
	public Rectangle(int x, int y, int width, int height){
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public void draw(){
		System.out.println("x좌표 = " + x + "\t" + "y좌표 = " + y + "\n" + "사각형의면적 = " + width*height + "\n" + "사각형의둘레" + 2*(width+height));
	}

}
