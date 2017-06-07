package workshop4;

public class Test04 {

	public static void main(String[] args) {
		int input = Integer.parseInt(args[0]);
		System.out.print("Â¦¼ö: ");
		for (int i=1; i<input; i++) {
			if (i%2==0) {
				System.out.print(i + "\t");
			}
		}
		System.out.println("\n°á°ú: " + new Calc().calculate(input));
		

	}

}
