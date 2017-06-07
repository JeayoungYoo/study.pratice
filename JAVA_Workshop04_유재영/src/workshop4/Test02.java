package workshop4;

import java.util.Random;

public class Test02 {

	public static void main(String[] args) {
		Random r = new Random();
		int[] arr3 = new int[5];
		int sum =0;
		for (int i=0; i<arr3.length; i++) {
			arr3[i] = r.nextInt(9)+1;
			System.out.print(arr3[i] + "\t");
			sum += arr3[i];
		}
		System.out.println("\nsum="+sum);
		System.out.println("avg="+sum/arr3.length);

	}

}
