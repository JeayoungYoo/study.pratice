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
				System.out.print("사원명 입력 : ");
				emp[inp].setName(br.readLine());
				System.out.print("나이 입력 : ");
				emp[inp].setAge(Integer.parseInt(br.readLine()));
				System.out.print("봉급 입력 : ");
				emp[inp].setPay(Long.parseLong(br.readLine()));
				System.out.print("세금 입력 : ");
				emp[inp].setTax(Double.parseDouble(br.readLine()));

			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("사원명 : " + emp[inp].getName() + ", 나이 : " + emp[inp].getAge() + ", 급여 : "
					+ emp[inp].getPay() + ", 세율 : " + (int) Math.round(emp[inp].getTax() * 100) / 100.0);
			listA.add(emp[inp]);

			System.out.print("추가로 입력하시겠습니까 ?");
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
