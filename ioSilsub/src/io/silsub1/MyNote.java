package io.silsub1;

import java.util.*;
import java.io.*;

public class MyNote {
	private Scanner sc = new Scanner(System.in);
	
	public void fileSave(){
		System.out.println("파일에 저장할 내용을 입력하시오");
		StringBuilder sb = new StringBuilder();
		BufferedWriter bout = null;
		do{
			String str = sc.nextLine();
			if (str.equals("exit"))
				break;
			sb.append(str+"\n");
		}while(true);
		System.out.println("파일명을 입력하시오");
		String fileName = sc.next();
		sc.nextLine();
		try {
			bout = new BufferedWriter(new FileWriter(fileName, true));
			bout.write(sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void fileOpen(){
		System.out.print("읽어들일 파일명 : ");
		System.out.println();
		BufferedReader fr = null;
		String fileName = sc.next();

		char[] readDate = new char[(int) new File(fileName).length()];

		try {
			fr = new BufferedReader(new FileReader(fileName));
			

			System.out.println("읽은 값들 확인");
			
			String str = "";
			while((str = fr.readLine())!=null){
				System.out.println(str);

			}

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
	
	public void fileEdit(){
		System.out.print("수정할 파일명 : ");
		
	}
	
	public static void main(String[] args){
		new MyNote().fileOpen();
	}
	
}
