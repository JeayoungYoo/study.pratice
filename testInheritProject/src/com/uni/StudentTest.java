package com.uni;

public class StudentTest {

	public static void main(String[] args) {
		Student[] st = new Student[3];
		st[0] = new Student("ȫ�浿", 15, 171, 81, "201101", "����");
		st[1] = new Student("�ѻ��", 13, 183, 72, "201102", "����");
		st[2] = new Student("�Ӱ���", 16, 175, 65, "201103", "����");
		
		for(int i=0; i<st.length; i++){
			System.out.println(st[i].printInformation());
		}

	}

}
