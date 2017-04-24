package ncs.test5;

import java.util.Scanner;

public class TestScore {

	public static void main(String[] args) {
		double [][] a = new double[3][5];
		
		for (int i=0; i<a.length; i++){
			for (int j=0; j<a[i].length-2; j++){
				System.out.print("값을 입력하세요");
				a[i][j] = new Scanner(System.in).nextDouble();
			}
		}
		
		for (int i=0; i<a.length; i++){
			double sum = 0;
			for(int j=0; j<a[i].length; j++){
				if (j<3){
					sum += a[i][j];
					System.out.print(a[i][j]+"\t");
				}
				else if (j==3)
					System.out.print(sum+ "\t");
				else
					System.out.println((int)(Math.round((sum/3)*10))/10.0);
					
			}
		}

	}

}
