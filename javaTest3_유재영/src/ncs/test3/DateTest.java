package ncs.test3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
		Calendar today = new GregorianCalendar();
		Calendar when = new GregorianCalendar();
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY'��' MM'��' dd'��'");
		when.set(1988, 10, 15);
		String a = "";
		switch(when.get(when.DAY_OF_WEEK)){
		case 1 : a = "�Ͽ���"; break;
		case 2 : a = "������"; break;
		case 3 : a = "ȭ����"; break;
		case 4 : a = "������"; break;
		case 5 : a = "�����"; break;
		case 6 : a = "�ݿ���"; break;
		case 7 : a = "�����"; break;
		}
		String fmT = sdf.format(today.getTime());
		String birT = sdf.format(when.getTime());
		System.out.println("���� : " + birT + a);
		System.out.println("���� : " + fmT);
		System.out.println("���� : " + (today.get(Calendar.YEAR)-when.get(Calendar.YEAR)+1) + " ��");
		
		/*System.out.println("���� : " + gc.get(Calendar.YEAR) + "�� " + gc.get(Calendar.MONTH)+ "�� " + gc.get(Calendar.DATE) + "�� " + a);
		System.out.println("���� : " + year + "�� " + month + "�� " + date + "��");
		System.out.println("���� : " + (year-gc.get(Calendar.YEAR)) + " ��");*/
		

	}

}
