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
		case 1: yo = "�Ͽ���";
		case 2: yo = "������";
		case 3: yo = "ȭ����";
		case 4: yo = "������";
		case 5: yo = "�����";
		case 6: yo = "�ݿ���";
		case 7: yo = "�����";
		}
		
		System.out.printf(year + "�� " + month + "�� " + date + "�� " + yo);
	}
}
