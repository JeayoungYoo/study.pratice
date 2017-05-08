package test.file;

import java.io.*;
import java.util.*;

public class TestFileReader {
	private Scanner sc = new Scanner(System.in);

	public void testFileRead() {
		System.out.print("읽어들일 파일명 : ");
		FileReader fr = null;
		String fileName = sc.next();

		char[] readDate = new char[(int) new File(fileName).length()];

		try {
			fr = new FileReader(fileName);
			fr.read(readDate);

			System.out.println("읽은 값들 확인");
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
		System.out.print("읽어들일 파일명 : ");
		BufferedReader fr = null;
		String fileName = sc.next();

		char[] readDate = new char[(int) new File(fileName).length()];

		try {
			fr = new BufferedReader(new FileReader(fileName));
			fr.read(readDate);

			System.out.println("읽은 값들 확인");
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
