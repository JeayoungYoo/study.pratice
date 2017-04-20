package test.math;

public class TestMath {
	public static void main(String[] args) {
		// static field, static method 사용 테스트
		System.out.println("Math.E : " + Math.E);
//		Math.E = 3.5;
		System.out.println("Math.PI : " + Math.PI);
		
		//Math math = new Math();
		//static 이면서 매개변수도 있고 반환값도 있는 메소드
		
		double result1 = Math.abs(-3.5);
		
		System.out.println("result1 : " + result1);
		
		//반환값이 있는 메소드는 다른 메소드 안에 사용 가능
		//값이 사용되는 위치에 바로 메소드 사용할 수 있음
		System.out.println("반환값 : " + Math.abs(-3.5));
		
		int sum = Math.addExact(100, 200);
		System.out.println("sum : " + sum);
		System.out.println("sum : " + Math.addExact(100, 200));
		
		
		//static 이면서 매개변수는 없고 반환값이 있는 메소드
		double result2 = Math.random();
		System.out.println("result2 : " + result2);
		System.out.println("랜덤값 : " + Math.random());
	}
}
