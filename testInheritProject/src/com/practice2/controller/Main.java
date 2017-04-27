package com.practice2.controller;

import java.util.Random;

import com.practice2.model.entity.Circle;
import com.practice2.model.entity.Point;
import com.practice2.model.entity.Rectangle;


public class Main {
	public static void main(String[] args){
		Random ran = new Random();
		Circle[] c = new Circle[3];
		Rectangle[] r = new Rectangle[3];
		
		for (int i=0; i<c.length; i++){
			c[i] = new Circle(ran.nextInt(10)+1, ran.nextInt(10)+1, ran.nextInt(10)+1);
			r[i] = new Rectangle(ran.nextInt(10)+1, ran.nextInt(10)+1, ran.nextInt(10)+1, ran.nextInt(10)+1);
		}
		for (int i=0; i<c.length; i++){
			c[i].draw();
			System.out.println();
			r[i].draw();
			System.out.println();

		}
		
		
		Point[] p = new Point[5];
		
		for (int i=0; i<5; i++){
			if(i%2==0)
				p[i] = new Circle(ran.nextInt(10)+1, ran.nextInt(10)+1, ran.nextInt(10)+1);
			else
				p[i] = new Rectangle(ran.nextInt(10)+1, ran.nextInt(10)+1, ran.nextInt(10)+1, ran.nextInt(10)+1);
			p[i].draw();
			System.out.println();
		}
		
	}
}
