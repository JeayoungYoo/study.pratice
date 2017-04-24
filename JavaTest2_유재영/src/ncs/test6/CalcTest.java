package ncs.test6;

import java.util.Scanner;

public class CalcTest {

	public static void main(String[] args) {
		Calculate calc = new Calculate();
		int input1, input2;
		
		System.out.print("정수1 입력 : ");
		input1=new Scanner(System.in).nextInt();
		System.out.print("정수2 입력 : ");
		input2=new Scanner(System.in).nextInt();
		
		if ((input1>=1&&input1<=9)&&(input2>=1&&input2<=9)){
			System.out.println("합 : " + calc.sum(input1, input2));
			System.out.println("차 : " + calc.subtract(input1, input2));
			System.out.println("곱 : " + calc.multiply(input1, input2));
			System.out.println("나누기 : " + calc.divide(input1, input2));
		}
		else
			System.out.println("1~9까지의 숫자를 입력해주세요");

	}

}
