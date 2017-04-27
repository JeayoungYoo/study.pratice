package test.polymorphism;

public class TestPolymorphism {

	public static void main(String[] args) {
		// 다형성 테스트
		A aob = new A();
		B bob = new B();
		C cob = new C();
		
		PP.testPP(aob);
		PP.testPP(bob);
		PP.testPP(cob);
		
		

	}

}
