package workshop03;

public class Test02 {

	public static void main(String[] args) {
		Calc calc = new Calc();
		int num = 0;
		
		if (Integer.parseInt(args[0]) > 4 && Integer.parseInt(args[0]) < 11) { 
			num = Integer.parseInt(args[0]);
			System.out.println("���: " + calc.calculate(num));
		}
		else
			System.out.println("�ٽ� �Է��ϼ���");
		
	}

}
