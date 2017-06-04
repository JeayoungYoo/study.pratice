package ncs.test4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class NoticeTest {

	public static void main(String[] args) {
		
		Object[] obArray = new Notice[3];
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("����� ���������� �Է��Ͻÿ�. (3�� �ݺ� �Է� ó����)");
		
		/*String title=null, writer=null, contents=null;
		for (int i=0; i<obArray.length; i++) {
			System.out.print("���� : ");
			title = sc.nextLine();
			System.out.print("�ۼ��� : ");
			writer = sc.next();
			System.out.print("���� : ");
			contents = sc.nextLine()+sc.nextLine();
			System.out.println("��¥�Է�(yyyy,mm,dd) : ");
			String date = sc.nextLine();
			String[] date2 = date.split(",");
			obArray[i] = new Notice(i+1, title, new GregorianCalendar(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(date2[2])), writer, contents);
		}*/
		
//		new NoticeTest().fileSave(obArray);
		
		ArrayList<Notice> list = new NoticeTest().fileRead();
		for (Notice no : list)
			System.out.println(no);

	}
	
	public void fileSave(Object[] array) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("notice.dat"))) {
			for (Object object : array) {
				oos.writeObject(object);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Notice> fileRead() {
		List<Notice> list = null;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("notice.dat"))) {
			list = ((List<Notice>) ois.readObject());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
