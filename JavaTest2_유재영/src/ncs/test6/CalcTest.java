package ncs.test6;

import java.util.Scanner;

public class CalcTest {

	public static void main(String[] args) {
		Calculate calc = new Calculate();
		int input1, input2;
		
		System.out.print("����1 �Է� : ");
		input1=new Scanner(System.in).nextInt();
		System.out.print("����2 �Է� : ");
		input2=new Scanner(System.in).nextInt();
		
		if ((input1>=1&&input1<=9)&&(input2>=1&&input2<=9)){
			System.out.println("�� : " + calc.sum(input1, input2));
			System.out.println("�� : " + calc.subtract(input1, input2));
			System.out.println("�� : " + calc.multiply(input1, input2));
			System.out.println("������ : " + calc.divide(input1, input2));
		}
		else
			System.out.println("1~9������ ���ڸ� �Է����ּ���");

	}

}
