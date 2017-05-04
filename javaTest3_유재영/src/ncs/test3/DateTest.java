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
		case 1 : a = "�Ͽ���";
		case 2 : a = "������";
		case 3 : a = "ȭ����";
		case 4 : a = "������";
		case 5 : a = "�����";
		case 6 : a = "�ݿ���";
		case 7 : a = "�����";
		
		}
		System.out.println("���� : " + gc.get(Calendar.YEAR) + "�� " + gc.get(Calendar.MONTH)+ "�� " + gc.get(Calendar.DATE) + "�� " + a);
		System.out.println("���� : " + year + "�� " + month + "�� " + date + "��");
		System.out.println("���� : " + (year-gc.get(Calendar.YEAR)) + " ��");
		

	}

}
