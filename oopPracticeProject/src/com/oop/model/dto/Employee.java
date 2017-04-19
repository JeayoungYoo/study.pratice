package com.oop.model.dto;

import java.util.Scanner;

public class Employee {
	Scanner sc = new Scanner(System.in);
	
	private int empNo;
	private String empName;
	private String dept;
	private String job;
	private int age;
	private char gender;
	private int salary;
	private double bonusPoint;
	private String phone;
	private String address;
	
	public void empInput(){
		System.out.print("�����ȣ �Է� : ");
		this.empNo = sc.nextInt();
		System.out.print("����� �Է� : ");
		this.empName = sc.next();
		System.out.print("�ҼӺμ� �Է� : ");
		this.dept = sc.next();
		System.out.print("���� �Է� : ");
		this.job = sc.next();
		System.out.print("���� �Է� : ");
		this.age = sc.nextInt();
		System.out.print("���� �Է�(m/f) : ");
		this.gender = sc.next().charAt(0);
		System.out.print("�޿� �Է� : ");
		this.salary = sc.nextInt();
		System.out.print("���ʽ� ����Ʈ �Է� : ");
		this.bonusPoint = sc.nextDouble();
		System.out.print("�ڵ��� ��ȣ �Է� : ");
		this.phone = sc.next();
		System.out.print("�ּ� �Է� : ");
		this.address = sc.nextLine();
		address = sc.nextLine();
	}
	
	public void empOutput(){
		System.out.println("�����ȣ : " + getEmpNo());
		System.out.println("����� : " + getEmpName());
		System.out.println("�ҼӺμ� : " + getDept());
		System.out.println("���� : " + getJob());
		System.out.println("���� : " + getAge());
		System.out.println("���� : " + (getGender()=='m'?"����":"����"));
		System.out.println("�޿� : " + getSalary());
		System.out.println("���ʽ�����Ʈ : " + getBonusPoint());
		System.out.println("��ȭ��ȣ : " + getPhone());
		System.out.println("�ּ� : " + getAddress());
		
		
	}
	public Employee(){
		
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public double getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(double bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	


}
