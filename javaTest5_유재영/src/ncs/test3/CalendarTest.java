package ncs.test3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarTest {

	public static void main(String[] args) {
		Calendar cl = new GregorianCalendar();
		Scanner sc = new Scanner(System.in);
		int year, month, date;
		System.out.println("��¥�� �Է��Ͻÿ�.");
		System.out.print("�� : ");
		year = sc.nextInt();
		System.out.print("�� : ");
		month = sc.nextInt()-1;
		System.out.print("�� : ");
		date = sc.nextInt();
		cl.set(year, month, date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY'��' MM'��' dd'��'");
		String a = "";
		switch(cl.get(cl.DAY_OF_WEEK)){
		case 1 : a = "�Ͽ���"; break;
		case 2 : a = "������"; break;
		case 3 : a = "ȭ����"; break;
		case 4 : a = "������"; break;
		case 5 : a = "�����"; break;
		case 6 : a = "�ݿ���"; break;
		case 7 : a = "�����"; break;
		}
		String fmT = sdf.format(cl.getTime());
		
		
		System.out.println("�Էµ� ��¥�� ���� ������ �Ʒ��� �����ϴ�");
		System.out.println(fmT + " " + a);
		
	}

}
