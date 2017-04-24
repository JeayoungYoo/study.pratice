package ncs.test1;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input;
		double score=0;
		int[] b = new int[5];

		System.out.print("점수를 입력하세요");
		String[] a=sc.nextLine().split(" ");
		if (a.length==5){
			for (int i=0; i<a.length; i++){
				b[i]=Integer.parseInt(a[i]);
				if (b[i]<10||b[i]>99){
					System.out.println("다시 입력해주세요");
					return;
				}
			}
			score = ((b[0]+b[1])/2*0.6) + ((b[2]+b[3])/2*0.2) + (b[4]/2*0.2);
			
			
			System.out.println("평가점수 : " + score);
			
			if (score>=90)
				System.out.println("Class : Gold Class");
			else if (score>=80)
				System.out.println("Class : Silver Class");
			else if (score>=70)
				System.out.println("Class : Bronze Class");
			else
				System.out.println("Class : Normal Class");
		
	}
		
				
	}}
				
		
	
		
		
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


			grade1 = ((a[0] + a[1]) / 2) * 0.6; // 60% 적용
			grade2 = ((a[2] + a[3]) / 2) * 0.2; // 20% 적용
			grade3 = a[4] * 0.2; // 20% 적용

			if (grade1 + grade2 + grade3 >= 90) {
				System.out.println("평가점수 : " + (grade1 + grade2 + grade3));
				System.out.println("Class : Gold Class");
			} else if (grade1 + grade2 + grade3 >= 80) {
				System.out.println("평가점수 : " + (grade1 + grade2 + grade3));
				System.out.println("Class : silver Class");
			} else if (grade1 + grade2 + grade3 >= 70) {
				System.out.println("평가점수 : " + (grade1 + grade2 + grade3));
				System.out.println("Class : bronze Class");
			} else {
				System.out.println("평가점수 : " + (grade1 + grade2 + grade3));
				System.out.println("Class : Normal Class");
			}

		}
		else
			System.out.println("다시 입력하세요");

	}*/
