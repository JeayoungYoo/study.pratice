package io.test;

import java.util.Scanner;

import io.silsub1.MyNote;

public class TestMyNote {
	Scanner sc = new Scanner(System.in);

	public void menu() {
		MyNote mn = new MyNote();

		do {
			System.out.println("****** MyNote ******");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("4. 끝내기");

			System.out.print("메뉴 선택 : ");

			switch (sc.nextInt()) {
			case 1:
				mn.fileSave();
				break;
			case 2:
				mn.fileOpen();
				break;
			case 3:
				mn.fileEdit();
				break;
			case 4:
				return;
			}
		} while (true);
	}

	public static void main(String[] args) {
		new TestMyNote().menu();

	}

}
