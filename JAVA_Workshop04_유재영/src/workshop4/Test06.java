package workshop4;

import java.util.Random;

public class Test06 {

	public static void main(String[] args) {
		int input1 = Integer.parseInt(args[0]);
		int input2 = Integer.parseInt(args[1]);
		int[][] arr = new int[input1][input2];
		Random r = new Random();
		
		double sum = 0;
		
		
		if (!(args.length<2 || args.length>2)) {
			System.out.println(input1 + " " + input2);
			for (int i=0; i<arr.length; i++) {
				for (int j=0; j<arr[i].length; j++) {
					arr[i][j] = r.nextInt(4)+1;
					System.out.print(arr[i][j] + " ");
					sum += arr[i][j];
				}
				System.out.println();
			}
			System.out.println("sum="+sum);
			System.out.println("avg="+Math.round(sum/(input1*input2)*10.0)/10.0);
		}
		else
			System.out.println("다시 입력 하세요");

	}

}
