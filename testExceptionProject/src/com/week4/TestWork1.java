package com.week4;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestWork1 {

	public static void main(String args[]){
		Calendar c = new GregorianCalendar();
		
		c.set(Calendar.YEAR, 2011);
		c.set(Calendar.MONTH, 3);
		c.set(Calendar.DATE, 21);
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int date = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR);
		int minute = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		
		String yo = null;
		switch(c.get(Calendar.DAY_OF_WEEK_IN_MONTH)){
		case 1: yo = "일요일";
		case 2: yo = "월요일";
		case 3: yo = "화요일";
		case 4: yo = "수요일";
		case 5: yo = "목요일";
		case 6: yo = "금요일";
		case 7: yo = "토요일";
		}
		
		System.out.printf(year + "년 " + month + "월 " + date + "일 " + yo);
	}
}
