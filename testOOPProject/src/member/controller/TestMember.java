package member.controller;

import java.util.*;

import member.model.vo.Member;

public class TestMember {

	public static void main(String[] args) {
		
		
		Member mem1 = new Member();
		Member mem2 = new Member("ruew12", "*******", "유재영");
		Member mem3 = new Member("ruew12", "*******", "유재영", 30, 'M');
		Member mem4 = new Member("ruew12", "*******", "유재영", 30, 'M', new GregorianCalendar(1988, 11, 15).getTime(), "ruew12@gmail.com", "01044202250", new String[]{"게임", "독서"});
		
		mem1.information();
		mem2.information();
		mem3.information();
		mem4.information();
		

	}

}
