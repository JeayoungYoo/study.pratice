package inherit.test;

import inherit.sample.*;

public class TestInheritance {
	
	public void test1(){
		Circle cir1 = new Circle();
		Rectangle rec1 = new Rectangle();
		Circle cir2 = new Circle(12.5);
		Rectangle rec2 = new Rectangle(11.2, 15.3);
		Circle cir3 = new Circle("원", 33.3);
		Rectangle rec3 = new Rectangle("사각형", 10, 10);
		cir1.calculator();
		cir2.calculator();
		cir3.calculator();
		cir1.information();
		cir2.information();
		cir3.information();
		
		rec1.calculator();
		rec2.calculator();
		rec3.calculator();
		rec1.information();
		rec2.information();
		rec3.information();
		
		
	}
	
	public void test2(){
		Circle[] cArr = new Circle[3];
		Rectangle[] rArr = new Rectangle[3];
		
		cArr[0] = new Circle("원1", 10.5);
		cArr[1] = new Circle("원2", 11.5);
		cArr[2] = new Circle("원3", 12.5);
		
		rArr[0] = new Rectangle("사각1", 10.4, 10.4);
		rArr[1] = new Rectangle("사각2", 11.4, 11.4);
		rArr[2] = new Rectangle("사각3", 12.4, 12.4);
		
		for (int i = 0; i<3; i++){
			cArr[i].calculator();
			rArr[i].calculator();
			cArr[i].information();
			rArr[i].information();
		}
	}
	
	//java.lang.Object는 모든 클래스들의 부모이다.
	//Object 가 제공하는 메소드는 사용 가능하다
	
/*	public void test3(){
		//추상클래스는 객체 생성 못 함
		Shape s = new Shape("도형");
		Shape s2 = s;  // 주소 복사
		
		System.out.println("s와 s2의 주소가 같은지? " + s.equals(s2));
		System.out.println("s : " + s.hashCode());
		System.out.println("s2 : " + s2.hashCode());
		System.out.println("s.toString() : " + s.toString());
		System.out.println("s : " + s);
		
		String st1 = "apple";
		String st2 = "banana";
		System.out.println("st1.toString() : " + st1.toString());
		System.out.println("st1 : " + st1);
		System.out.println("값이 같은지? " + st1.equals("apple"));
		
	}
	
	public void test4(){
		Shape s = new Shape("도형");
		Circle cir = new Circle("원", 12.3);
		Rectangle rec = new Rectangle("사각형", 10, 20);
		
		System.out.println("s : " + s);
		System.out.println("cir : " + cir);
		System.out.println("rec : " + rec);
	}
	
	//상속관계에 있는 클래스일 때는 부모 레퍼런스가 후손 객체의 주소를 받ㄹ을 수 있음
	
	public void test5(){
		Shape s = new Circle();
		System.out.println("s : " + s);
		
		//부모 레퍼런스로는 부모것만 참조할 수 있음
		//후손 소유 멤버를 참조할면, 부모레퍼런스를 후손 클래스형으로
		//형변환 해야 함 : 상속관계에 있는 클래스간에만 형변환 가능함
		//DownCasting 이라고함 : 직접 ㅁㅇ시해야 함
		((Circle)s).setRadius(10);
		System.out.println("s : " + s);
		s=  new Rectangle();
		System.out.println("s : " + s);
		
		Object obj = s;
		System.out.println("obj : " + obj);
		obj = new Shape();
		obj = new Circle();
		obj = new String();
		obj = new java.util.Date();
		System.out.println("obj : " + obj);
	}
	
	//overriding equals() test
	public void test6(){
		Shape s1 = new Shape("도형1");
		Shape s2 = new Shape("shape");
		Shape s3 = new Shape("도형1");
		
		if (s1.equals(s2))
			System.out.println("두 객체안의 모든 필드값이 같다");
		else
			System.out.println("두 객체안의 필드값이 다르다");
		
		if (s1.equals(s3))
			System.out.println("두 객체안의 모든 필드값이 같다");
		else
			System.out.println("두 객체안의 필드값이 다르다");
	}*/
	
	//equals() test
	public void test7(){
		Circle c1 = new Circle("원", 10.6);
		Circle c2 = new Circle("원", 10.6);
		
		System.out.println("주소가 같은지 ? " + (c1 == c2));
		System.out.println("값들이 모두 같은지 ? " + c1.equals(c2));
	}
	
	public void test8(){
		Circle c1 = new Circle("circle", 23.5);
		Circle copyC1 = (Circle)c1.clone();
		
		System.out.println("c1 : " + c1);
		System.out.println("copyC1 : " + copyC1);
		System.out.println("c1 : " + c1.hashCode());
		System.out.println("copyC1 : " + copyC1.hashCode());
		
	}
	
	public static void main(String[] args){
		// 상속 테스트
		TestInheritance tin = new TestInheritance();
		//tin.test1();
//		tin.test2();
//		tin.test3();
//		tin.test4();
//		tin.test5();
//		tin.test6();
//		tin.test7();
		tin.test8();
		
		
	}
}
