package com.week4;

public class TestWork2 {

	public static void main(String[] args) {
		String input = "J a v a  P r o g r a m ";
		System.out.println(input);
		System.out.println(input.replace(" ", ""));
		
		String[] as = input.split(" ");
		char[] ac = input.replace(" ", "").toCharArray();
		
		System.out.println("토큰 처리 후 문자의 갯수 : " + ac.length);
		
		input = "";
		for (int i=0; i<ac.length; i++){
			System.out.print(ac[i]);
			input += ac[i];
		}
		System.out.println();
		System.out.println(input);
		}

}
