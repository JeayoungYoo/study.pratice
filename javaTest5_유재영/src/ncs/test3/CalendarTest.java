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
		System.out.println("날짜를 입력하시오.");
		System.out.print("년 : ");
		year = sc.nextInt();
		System.out.print("월 : ");
		month = sc.nextInt()-1;
		System.out.print("일 : ");
		date = sc.nextInt();
		cl.set(year, month, date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY'년' MM'월' dd'일'");
		String a = "";
		switch(cl.get(cl.DAY_OF_WEEK)){
		case 1 : a = "일요일"; break;
		case 2 : a = "월요일"; break;
		case 3 : a = "화요일"; break;
		case 4 : a = "수요일"; break;
		case 5 : a = "목요일"; break;
		case 6 : a = "금요일"; break;
		case 7 : a = "토요일"; break;
		}
		String fmT = sdf.format(cl.getTime());
		
		
		System.out.println("입력된 날짜에 대한 정보는 아래와 같습니다");
		System.out.println(fmT + " " + a);
		
	}

}
