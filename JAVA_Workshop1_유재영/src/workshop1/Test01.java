package workshop1;

public class Test01 {

	public static void main(String[] args) {
		System.out.println((Double.parseDouble(args[0])%Double.parseDouble(args[2])) ? "나머지가 1보다 작거나 같다" : "나머지가 1보다 크다");
		
		
		double input1 = Double.parseDouble(args[0]);
		double input2 = Double.parseDouble(args[2]);
		
		if (input1%input2<=1) {
			System.out.println("나머지가 1보다 작거나 같다!");
		}
		else
			System.out.println("나머지가 1보다 크다!");
		
	}

}