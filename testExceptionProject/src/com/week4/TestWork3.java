package com.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestWork3 {

	public static void input() {
		List listA = new ArrayList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Employee[] emp = new Employee[5];
		int inp = 0;
		Employee temp = new Employee();
		while (true) {

			try {
				emp[inp] = new Employee();
				System.out.print("����� �Է� : ");
				emp[inp].setName(br.readLine());
				System.out.print("���� �Է� : ");
				emp[inp].setAge(Integer.parseInt(br.readLine()));
				System.out.print("���� �Է� : ");
				emp[inp].setPay(Long.parseLong(br.readLine()));
				System.out.print("���� �Է� : ");
				emp[inp].setTax(Double.parseDouble(br.readLine()));

			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("����� : " + emp[inp].getName() + ", ���� : " + emp[inp].getAge() + ", �޿� : "
					+ emp[inp].getPay() + ", ���� : " + (int) Math.round(emp[inp].getTax() * 100) / 100.0);
			listA.add(emp[inp]);

			System.out.print("�߰��� �Է��Ͻðڽ��ϱ� ?");
			try {
				if (br.readLine().toUpperCase().charAt(0) == 'N') {
					
					
					
					break;

				} else
					inp++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		input();

	}
}
