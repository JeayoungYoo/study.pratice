package ncs.test6;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculator cc = new Calculator();
		
		try {
			System.out.println("°á°ú°ª : " + cc.getSum(sc.nextInt()));
		} catch (InvalidException e) {
			e.printStackTrace();
		}
	}

}
