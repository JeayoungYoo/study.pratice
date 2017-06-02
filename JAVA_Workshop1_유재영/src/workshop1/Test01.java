package workshop1;

public class Test01 {

	public static void main(String[] args) {
		System.out.println(Double.parseDouble(args[0]) % Double.parseDouble(args[1])<=1 ? "나머지가 1보다 작거나 같다" : "나머지가 1보다 크다");
	}	


}