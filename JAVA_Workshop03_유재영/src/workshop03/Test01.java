package workshop03;

public class Test01 {

	public static void main(String[] args) {
		for (int i=1; i<7; i++) {
			for (int j=1; j<7; j++) {
				if (i-j > 0 && i-j <= 3)
					System.out.println(i +"-" + j + " = " + (i-j));
			}
		}

	}

}
