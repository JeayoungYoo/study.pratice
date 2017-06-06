package workshop03;

public class Test02 {

	public static void main(String[] args) {
		Calc calc = new Calc();
		int num = 0;
		
		if (Integer.parseInt(args[0]) > 4 && Integer.parseInt(args[0]) < 11) { 
			num = Integer.parseInt(args[0]);
			System.out.println("결과: " + calc.calculate(num));
		}
		else
			System.out.println("다시 입력하세요");
		
	}

}
