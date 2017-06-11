package workshop5;

public class Test01 {

	public static void main(String[] args) {
		char[] input = args[0].toCharArray();
		
		for (int i=1; i<=input.length; i++) {
			System.out.print(input[input.length-i]);
		}
	}

}
