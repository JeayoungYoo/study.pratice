package test.file;

import java.io.*;

import java.util.Scanner;

public class TestFileInputStream {
	public void testFileRead(){
		Scanner sc = new Scanner(System.in);
		FileInputStream fin = null;
		
		System.out.print("�о���� ���ϸ� : ");
		String fileName = sc.next();
		
		/*File readFile = new File(fileName);
		long fileSize = readFile.length();
		
		byte[] readData = new byte[(int)fileSize];*/
		
		byte[] readDate = new byte[(int)new File(fileName).length()];
		
		try {
			fin = new FileInputStream(fileName);
			fin.read(readDate);
			
			System.out.println("���� ���� Ȯ��");
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
		System.out.print("�о���� ���ϸ� : ");
		BufferedInputStream fin = null;
		String fileName = sc.next();
		
		
		
		byte[] readDate = new byte[(int)new File(fileName).length()];
		
		try {
			fin = new BufferedInputStream(new FileInputStream(fileName));
			fin.read(readDate);
			
			System.out.println("���� ���� Ȯ��");
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
		// ���Ϸ� ���� �����͸� �о���̴� FileInputStream �׽�Ʈ
		// new TestFileInputStream().testFileRead();
		new TestFileInputStream().testBufferedFileInput();
	}

}
