package com.week4;

public class ExamString {
	public String preChar(String s){
		
		StringBuffer sb = new StringBuffer(s);
		sb.setCharAt(0, s.toUpperCase().charAt(0));
		String re = sb.toString();
		
		return re;
	}
	
	public int charSu (String s, char ch){
		int cnt=0;
		for (int i=0; i<s.length(); i++){
			if (s.charAt(i)==ch)
				cnt++;
		}
		return cnt;
	}
}
