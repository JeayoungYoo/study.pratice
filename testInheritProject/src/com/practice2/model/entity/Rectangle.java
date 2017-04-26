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
		super.draw();
		System.out.println("가로 = " + width + "\t세로 = " + height);
		System.out.println("사각형의면적 = " + (int)Math.round(width*height*10)/10.0);
		System.out.println("사각형의둘레 = " + (int)Math.round(2*(width+height)*10)/10.0);
	}

}
