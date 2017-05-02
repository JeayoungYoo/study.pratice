package exception.sample;

public class TestCalculator {

	public static void main(String[] args) {
		// 사용자정의 예외클래스 작동 테스트
		new TestCalculator().testMethod();

	}

	private void testMethod() {
		try {
			double result = new Calculator().divide(10.2, 3.0);
			System.out.println("result : " + result);
		} catch (ZeroDivideException e) {
			e.printStackTrace();
		} 
	}

}
