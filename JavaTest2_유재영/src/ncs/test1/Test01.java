package ncs.test1;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		double grade1 = 0, grade2 = 0, grade3 = 0;
		String[] a;
		int[] b;

		System.out.print("������ �Է��ϼ���");
		input = sc.nextLine();
		a=input.split(" ");
		
		for (int i=0; i<a.length; i++){
			b[i]=Integer.parseInt(a[i]);
			if (b[i]<10||b[i]>99)
				System.out.println("�ٽ� �Է����ּ���");
		}
		
		
		
		
		/*int n1 = input.indexOf(" ");
		int n2 = input.indexOf(" ", n1 + 1);
		int n3 = input.indexOf(" ", n2 + 1);
		int n4 = input.indexOf(" ", n3 + 1);

		if (input.length()==14) {
			a[0] = Integer.parseInt(input.substring(0, n1));
			a[1] = Integer.parseInt(input.substring(n1 + 1, n2));
			a[2] = Integer.parseInt(input.substring(n2 + 1, n3));
			a[3] = Integer.parseInt(input.substring(n3 + 1, n4));
			a[4] = Integer.parseInt(input.substring(n4 + 1, input.length()));


			grade1 = ((a[0] + a[1]) / 2) * 0.6; // 60% ����
			grade2 = ((a[2] + a[3]) / 2) * 0.2; // 20% ����
			grade3 = a[4] * 0.2; // 20% ����

			if (grade1 + grade2 + grade3 >= 90) {
				System.out.println("������ : " + (grade1 + grade2 + grade3));
				System.out.println("Class : Gold Class");
			} else if (grade1 + grade2 + grade3 >= 80) {
				System.out.println("������ : " + (grade1 + grade2 + grade3));
				System.out.println("Class : silver Class");
			} else if (grade1 + grade2 + grade3 >= 70) {
				System.out.println("������ : " + (grade1 + grade2 + grade3));
				System.out.println("Class : bronze Class");
			} else {
				System.out.println("������ : " + (grade1 + grade2 + grade3));
				System.out.println("Class : Normal Class");
			}

		}
		else
			System.out.println("�ٽ� �Է��ϼ���");

	}*/

}
