package ncs.test2;

public class CharTest {

	public static void main(String[] args) {
		char[] input=args[0].toUpperCase().toCharArray();
						
		for (int i=input.length-1; i>=0; i--){
			System.out.print(input[i]);
		}
	}
}