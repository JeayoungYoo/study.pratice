package test.file;
import java.io.*;
import java.util.*;

public class TestFileWriter {
	
	private Scanner sc = new Scanner(System.in);
	
	public void testFileWriter(){
		FileWriter fw = null;
		
		System.out.print("저장할 파일명 : ");
		String fileName = sc.next();
		sc.hasNextLine();
		
		try {
			fw = new FileWriter(fileName);
			System.out.println(fileName + "에 기록할 내용을 입력하세요");
			System.out.println("exit 입력시 종료됨...");
			
			do{
				String str = sc.nextLine();
				if (str.equals("exit"))
					break;
				fw.write(str + "\n");
			}while(true);
			
			System.out.println(fileName + "에 저장이 완료되었습니다.");
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
		
		System.out.print("저장할 파일명 : ");
		String fileName = sc.next();
		sc.hasNextLine();
		
		try {
			fw = new BufferedWriter(new FileWriter(fileName, true));
			System.out.println(fileName + "에 기록할 내용을 입력하세요");
			System.out.println("exit 입력시 종료됨...");
			
			do{
				String str = sc.nextLine();
				if (str.equals("exit"))
					break;
				fw.write(str + "\n");
			}while(true);
			
			System.out.println(fileName + "에 저장이 완료되었습니다.");
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
