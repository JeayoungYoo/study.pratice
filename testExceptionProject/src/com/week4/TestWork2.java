package com.week4;

public class TestWork2 {

	public static void main(String[] args) {
		String input = "J a v a  P r o g r a m ";
		System.out.println(input);
		
		String[] as = input.split(" ");
		char[] ac = new char[(as.length)];
		int cnt=0;
		
		for (int i=0; i<as.length; i++){
			ac[i] = as[i].charAt(0);
			cnt++;
			System.out.print(ac[i]);
		}
		
//		for (int i=0; i<arrC.length; i++){
//			
//		}
		
		
		

	}

}
