package com.oop.array2.model;

//public Ŭ������
public class Student /*extends AbstractSample */ /*FinalSample*/{
	//Ŭ����(class) : ����ü + ���ȱ��
	//����ü : �ڷ����� �ٸ� �������� ����(�迭ó�� ���� �Ҵ��)
	//���ȱ��(�������� ���) : Ŭ���� �ۿ��� Ŭ���� �ȿ� �ִ�
	//�������(�ʵ�: Field)�� ������ �� �ϰ� �ϴ� ���� ��Ģ��
	//ĸ��ȭ(Encapsulation) : ��� �ʵ带 private ������
	
	//�ʵ� ���� : ���������� �ڷ��� ������ [= �ʱⰪ];
	private int sno;//�й�
	private String name;//�̸�
	private String major;//����
	private char gender;//����
	private double score;//����
	private String address;//�ּ�
	private String phone;//��ȭ��ȣ
	private String professor;//��������
	
	
	public void setSno(int sno) {
		this.sno = sno;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	//�������Լ�(Constructor)
	//�⺻(default) ������
	public Student(){
		System.out.println("this �� ���� ��ü�� �ּ� : " + this.hashCode());
	}
	//�Ű������� �ִ� ������ : �����ε�(overloading) ������
	public Student(int sno, String name, String major){
		this.sno = sno;
		this.name = name;
		this.major = major;
		System.out.println("this �� ���� ��ü�� �ּ� : " + this.hashCode());
		
	}
	
/*	public int calculator(){
		int sum=0;
		return sum= (sum+score);
	}*/
	
	//����Լ�(Method)
	//���������� [static]��ȯ�ڷ��� �޼ҵ��̸�(�ڷ��� �Ű�����){  ó������}

	public int getSno() {
		return sno;
	}
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	public char getGender() {
		return gender;
	}
	public double getScore() {
		return score;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getProfessor() {
		return professor;
	}
	public void printInformaiton(){
		System.out.println(this.sno + ", " + this.name + ", " + this.major + ", " + this.gender + ", " + this.score + ", " + this.phone + ", " + this.address + ", " + this.professor );
	}
		public Student (int sno, String name, String major, char gender, double score, String address, String phone, String professor){
		this.sno = sno;
		this.name = name;
		this.major = major;
		this.gender = gender;
		this.score = score;
		this.address = address;
		this.phone = phone;
		this.professor = professor;
	}
}
