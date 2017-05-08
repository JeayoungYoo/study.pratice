package test.file;

import java.io.*;
import java.util.*;

public class TestFileReader {
	private Scanner sc = new Scanner(System.in);

	public void testFileRead() {
		System.out.print("�о���� ���ϸ� : ");
		FileReader fr = null;
		String fileName = sc.next();

		char[] readDate = new char[(int) new File(fileName).length()];

		try {
			fr = new FileReader(fileName);
			fr.read(readDate);

			System.out.println("���� ���� Ȯ��");
			System.out.println(new String(readDate));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void testBufferedReader(){
		System.out.print("�о���� ���ϸ� : ");
		BufferedReader fr = null;
		String fileName = sc.next();

		char[] readDate = new char[(int) new File(fileName).length()];

		try {
			fr = new BufferedReader(new FileReader(fileName));
			fr.read(readDate);

			System.out.println("���� ���� Ȯ��");
			System.out.println(new String(readDate));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		new TestFileReader().testFileRead();
		new TestFileReader().testBufferedReader();
	}

}
