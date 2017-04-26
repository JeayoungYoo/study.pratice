package com.practice2.model.entity;

public class Circle extends Point{
	private int radius;
	
	public Circle(){}
	
	public Circle(int x, int y, int radius){
		super(x, y);
		this.radius = radius;
	}
	
	@Override
	public void draw(){
		super.draw();
		System.out.println("반지름 = " + radius );
		System.out.println("면적 = " + (int)Math.round(Math.PI * Math.pow(radius, 2)*10)/10.0);
		System.out.println("둘레 = " + (int)Math.round(2*Math.PI*radius*10)/10.0);
	}
}
