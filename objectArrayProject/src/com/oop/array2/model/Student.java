package com.oop.array2.model;

//public 클래스임
public class Student /*extends AbstractSample */ /*FinalSample*/{
	//클래스(class) : 구조체 + 보안기능
	//구조체 : 자료형이 다른 변수들의 묶음(배열처럼 연속 할당됨)
	//보안기능(접근제한 기능) : 클래스 밖에서 클래스 안에 있는
	//멤버변수(필드: Field)에 접근을 못 하게 하는 것이 원칙임
	//캡슐화(Encapsulation) : 모든 필드를 private 지정함
	
	//필드 선언 : 접근제한자 자료형 변수명 [= 초기값];
	private int sno;//학번
	private String name;//이름
	private String major;//전공
	private char gender;//성별
	private double score;//학점
	private String address;//주소
	private String phone;//전화번호
	private String professor;//지도교수
	
	
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
	//생성자함수(Constructor)
	//기본(default) 생성자
	public Student(){
		System.out.println("this 가 받은 객체의 주소 : " + this.hashCode());
	}
	//매개변수가 있는 생성자 : 오버로딩(overloading) 가능함
	public Student(int sno, String name, String major){
		this.sno = sno;
		this.name = name;
		this.major = major;
		System.out.println("this 가 받은 객체의 주소 : " + this.hashCode());
		
	}
	
/*	public int calculator(){
		int sum=0;
		return sum= (sum+score);
	}*/
	
	//멤버함수(Method)
	//접근제한자 [static]반환자료형 메소드이름(자료형 매개변수){  처리내용}

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
