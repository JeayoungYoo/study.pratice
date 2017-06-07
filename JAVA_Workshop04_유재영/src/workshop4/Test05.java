package workshop4;

public class Test05 {

	public static void main(String[] args) {
		int input = Integer.parseInt(args[0]);
		int sum = 0;
		for (int i=input; i<11; i++) {
			if (i%3 != 0 && i%5 != 0) {
				sum += i;
				System.out.print(i + "+");
			}
		}
		
		System.out.println("\n°á°ú: " + sum);

	}

}
