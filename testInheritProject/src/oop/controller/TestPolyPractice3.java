package oop.controller;

import java.util.Random;

import inherit.polymorphism.model.*;

public class TestPolyPractice3 {

	public static void main(String[] args) {
		IShape[] iarr = new IShape[5];
		Random r = new Random();
		for(int i=0; i<5; i++){
			if(i%2==0){
				iarr[i] = new Circle(r.nextInt(10)+1);
				System.out.println("원의 넓이 : " + iarr[i].area());
				System.out.println("원의 둘레 : " + iarr[i].perimeter());
				System.out.println();
			}
			else if (i == 3){
				iarr[i] = new Rectangle(r.nextInt(10)+1, r.nextInt(10)+1);
				System.out.println("사각형의 넓이 : " + iarr[i].area());
				System.out.println("사각형의 둘레 : " + iarr[i].perimeter());
				System.out.println();
			}
			else{
				iarr[i] = new Triangle(r.nextInt(10)+1, r.nextInt(10)+1);
				System.out.println("삼각형의 넓이 : " + iarr[i].area());
				System.out.println("삼각형의 둘레 : " + iarr[i].perimeter());
				
			}
			if (iarr[i] instanceof Triangle){
				System.out.println("빗변길이 : " + ((Triangle)iarr[i]).getHypotenuse());
				System.out.println();
			}
				
				
		}
	}
}

