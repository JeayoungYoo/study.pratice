package exception.sample;

public class TestCalculator {

	public static void main(String[] args) {
		// ��������� ����Ŭ���� �۵� �׽�Ʈ
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
