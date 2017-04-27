package inherit.polymorphism.controlloer;

import inherit.polymorphism.model.*;

public class TestShape {

	public static void main(String[] args) {
		//Shape s 추상클래스도 레퍼런스변수 선언 가능함.
		IShape s; //인터페이스도 레퍼런스변수 선언 가능함.
		s= new Circle(15.5);
		
		System.out.println("원면적 : " + s.area());
		System.out.println("원둘레 : " + s.perimeter());
		
		s= new Rectangle(34.5, 42.7);
		System.out.println("사각형면적 : " + s.area());
		System.out.println("사각형둘레 : " + s.perimeter());
		
	}

}
