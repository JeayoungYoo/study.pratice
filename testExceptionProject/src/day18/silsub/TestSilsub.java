package day18.silsub;

import java.io.*;

import java.util.Scanner;

public class TestSilsub {
	Scanner sc = new Scanner(System.in);
	
	public void silsub1(){
		System.out.print("문자열을 입력해주세요 : ");
		try{
			int count = new CharacterProcess().countAlpha(sc.nextLine());
			System.out.println("count : " + count);
		} catch (CharCheckException e){
			e.printStackTrace();
		} 
	}
	
	public void silsub2(){
		System.out.print("첫번째 정수 입력 : ");
		int a = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int b = sc.nextInt();
		
		try{
			boolean flag = new NumberProcess().checkDouble(a, b);
			if (flag == true)
				System.out.println(a + "는 " + b + "의 배수이다");
			else
				System.out.println(a + "는 " + b + "의 배수가아니다");
		} catch (NumberRangeException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new TestSilsub().silsub2();

	}

}
