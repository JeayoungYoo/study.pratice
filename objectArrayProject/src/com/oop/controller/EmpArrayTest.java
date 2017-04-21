package com.oop.controller;

import com.oop.model.dto.Employee;

public class EmpArrayTest {

	public static void main(String[] args) {
		Employee[] ep = new Employee[]{
				new Employee(),
				new Employee(201503, "�ڱ浿", 29, 'M', "010-1234-5678", "��⵵ �����ν�"),
				new Employee(201004, "��ö��", "���ߺ�", "����", 34, 'M', 4500000, 0.15, "010-2143-9876", "����� ����� ����� 123")
		};
		
		for (int i=0; i<ep.length; i++)
			System.out.println(ep[i].empInformation());
		System.out.println("-----------------------------------------------");
		
		ep[0].setEmpNo(201305);
		ep[0].setEmpName("�̿���");
		ep[0].setDept("�ѹ���");
		ep[0].setJob("�븮");
		ep[0].setAge(28);
		ep[0].setGender('F');
		ep[0].setSalary(3750000);
		ep[0].setBonusPoint(0.1);
		ep[0].setPhone("010-9512-7534");
		ep[0].setAddress("��⵵ ����õ");
		
		ep[1].setDept("��ȹ��");
		ep[1].setJob("���");
		ep[1].setSalary(2900000);
		ep[1].setBonusPoint(0.05);
		
		System.out.println(ep[0].empInformation());
		System.out.println(ep[1].empInformation());
		System.out.println("-----------------------------------------------");
		
		 
		int sumSalary=0;
		for (int i=0; i<ep.length; i++){
			System.out.println(ep[i].getEmpName() + "�� ���� : " + (int)(ep[i].getSalary()+(ep[i].getSalary()*ep[i].getBonusPoint()))*12);
			sumSalary += (int)(ep[i].getSalary()+(ep[i].getSalary()*ep[i].getBonusPoint()))*12;
		
		}
			
		System.out.println("-----------------------------------------------");
		
		System.out.println("�������� ������ ��� : " + sumSalary/ep.length);
//		ep[0].empInformation();
//		ep[1].empInformation();
		
	}
}
