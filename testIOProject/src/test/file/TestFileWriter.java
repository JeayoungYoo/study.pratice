package test.file;
import java.io.*;
import java.util.*;

public class TestFileWriter {
	
	private Scanner sc = new Scanner(System.in);
	
	public void testFileWriter(){
		FileWriter fw = null;
		
		System.out.print("������ ���ϸ� : ");
		String fileName = sc.next();
		sc.hasNextLine();
		
		try {
			fw = new FileWriter(fileName);
			System.out.println(fileName + "�� ����� ������ �Է��ϼ���");
			System.out.println("exit �Է½� �����...");
			
			do{
				String str = sc.nextLine();
				if (str.equals("exit"))
					break;
				fw.write(str + "\n");
			}while(true);
			
			System.out.println(fileName + "�� ������ �Ϸ�Ǿ����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void testBufferedWriter(){
		BufferedWriter fw = null;
		
		System.out.print("������ ���ϸ� : ");
		String fileName = sc.next();
		sc.hasNextLine();
		
		try {
			fw = new BufferedWriter(new FileWriter(fileName, true));
			System.out.println(fileName + "�� ����� ������ �Է��ϼ���");
			System.out.println("exit �Է½� �����...");
			
			do{
				String str = sc.nextLine();
				if (str.equals("exit"))
					break;
				fw.write(str + "\n");
			}while(true);
			
			System.out.println(fileName + "�� ������ �Ϸ�Ǿ����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
//		new TestFileWriter().testFileWriter();
		new TestFileWriter().testBufferedWriter();
	}
}
