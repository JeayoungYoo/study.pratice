package ncs.test2;

import java.util.Scanner;

public class CharTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] input;
		int j;
		
		System.out.print("문자입력 : ");
		input = sc.next().toUpperCase().toCharArray();

		for (int i=0; i<input.length; i++){
			j=(input.length-i)-1;
			System.out.print(input[j]);
		}
		
		
		

	}

}
