package com.practice2.controller;

import java.util.Random;

import com.practice2.model.entity.Circle;
import com.practice2.model.entity.Point;
import com.practice2.model.entity.Rectangle;


public class Main {
	public static void main(String[] args){
		Random ran = new Random();
		Circle[] c = new Circle[3];
/*		c[0] = new Circle(10, 20, 30);
		c[1] = new Circle(5, 10, 15);
		c[2] = new Circle(3, 6, 9);*/
		Rectangle[] r = new Rectangle[3];
/*		r[0] = new Rectangle(10, 20, 30, 40);
		r[1] = new Rectangle(5, 6, 7, 8);
		r[2] = new Rectangle(9, 10, 11, 12);*/
		
		
	/*	for (int i=0; i<3; i++){
			c[i].draw();
			r[i].draw();
			System.out.println();
		}*/
		
		Point[] p = new Point[5];
		
		for (int i=0; i<5; i++){
			p[i] = new Circle(ran.nextInt(10), ran.nextInt(10), ran.nextInt(10));
			p[i] = new Rectangle(ran.nextInt(10), ran.nextInt(10), ran.nextInt(10), ran.nextInt(10));
			p[i].draw();
			System.out.println();
		}
		
	}
}
