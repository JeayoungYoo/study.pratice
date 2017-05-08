package test.file;

import java.io.*;

import java.util.Scanner;

public class TestFileInputStream {
	public void testFileRead(){
		Scanner sc = new Scanner(System.in);
		FileInputStream fin = null;
		
		System.out.print("읽어들일 파일명 : ");
		String fileName = sc.next();
		
		/*File readFile = new File(fileName);
		long fileSize = readFile.length();
		
		byte[] readData = new byte[(int)fileSize];*/
		
		byte[] readDate = new byte[(int)new File(fileName).length()];
		
		try {
			fin = new FileInputStream(fileName);
			fin.read(readDate);
			
			System.out.println("읽은 값들 확인");
			System.out.println(new String(readDate));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
	
	public void testBufferedFileInput(){
		Scanner sc = new Scanner(System.in);
		System.out.print("읽어들일 파일명 : ");
		BufferedInputStream fin = null;
		String fileName = sc.next();
		
		
		
		byte[] readDate = new byte[(int)new File(fileName).length()];
		
		try {
			fin = new BufferedInputStream(new FileInputStream(fileName));
			fin.read(readDate);
			
			System.out.println("읽은 값들 확인");
			System.out.println(new String(readDate));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
		}
	}
		
	public static void main(String[] args) {
		// 파일로 부터 데이터를 읽어들이는 FileInputStream 테스트
		// new TestFileInputStream().testFileRead();
		new TestFileInputStream().testBufferedFileInput();
	}

}
