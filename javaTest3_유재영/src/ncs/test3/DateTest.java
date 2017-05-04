package ncs.test3;

import java.util.*;

public class DateTest {

	public static void main(String[] args) {
		Calendar gc = new GregorianCalendar();
		int year = gc.get(Calendar.YEAR);
		int month = gc.get(Calendar.MONTH);
		int date = gc.get(Calendar.DATE);
		
		gc.set(Calendar.YEAR, 1988);
		gc.set(Calendar.MONTH, 11);
		gc.set(Calendar.DATE, 15);
		
		
		String a = "";
		switch(gc.get(Calendar.DAY_OF_WEEK_IN_MONTH)){
		case 1 : a = "일요일";
		case 2 : a = "월요일";
		case 3 : a = "화요일";
		case 4 : a = "수요일";
		case 5 : a = "목요일";
		case 6 : a = "금요일";
		case 7 : a = "토요일";
		
		}
		System.out.println("생일 : " + gc.get(Calendar.YEAR) + "년 " + gc.get(Calendar.MONTH)+ "월 " + gc.get(Calendar.DATE) + "일 " + a);
		System.out.println("현재 : " + year + "년 " + month + "월 " + date + "일");
		System.out.println("나이 : " + (year-gc.get(Calendar.YEAR)) + " 세");
		

	}

}
