package ncs.test4;

import java.util.Scanner;

public class NoticeTest {

	public static void main(String[] args) {
		Object[] obArray = new Object[3];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("등록할 공지사항을 입력하시오. (3번 반복 입력 처리함)");
		
		String title=null, author=null, contents=null;
		for (int i=0; i<obArray.length; i++) {
			System.out.print("제목 : ");
			title = sc.nextLine();
			System.out.print("작성자 : ");
			author = sc.next();
			System.out.print("내용 : ");
			contents = sc.nextLine() + sc.nextLine();
			
//			obArray[i] = new Object(title, author, contents);
		}

	}

}
