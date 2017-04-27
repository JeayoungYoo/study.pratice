package inherit.polymorphism.model;

public interface IShape {
	//상수필드는 멤버로 가질수도 있음
	public static final double PI = Math.PI;
	
	
	//추상메소드로만 구성된 추상클래스 변형체이다.
	double area(); //면적 계산 리턴용
	double perimeter(); //둘레 계산 리턴용
	//abstract public 는 당연히 있는거라 생략해도 된다.

}
