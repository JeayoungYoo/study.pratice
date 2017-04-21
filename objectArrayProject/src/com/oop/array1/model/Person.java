package com.oop.array1.model;

public class Person {
	//Field(멤버변수)
	//접근제한자 예약어 자료형 변수명[= 초기값];   ==> 상수필드만들땐 바로 초기화 시킴
	private String name;
	private int age;
	private double height;
	private double weight;
	private double property;
		
	//Constructor(생성자)
	//public 클래스명([자료형 매개변수]){필드 = 초기값;}
	public Person(){}

	public Person(String name, int age, double height, double weight, double property) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	//Method(멤버함수)
	//setter : 필드값 변경 처리를 담당하는 메소드
	//public void set필드명(자료형 매개변수){필드 = 변경값;}
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getProperty() {
		return property;
	}

	public void setProperty(double property) {
		this.property = property;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	//getter : 필드값을 조회용 메소드
	//public 반환자료형 get필드명(){ return 필드값; }
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}
	
	//접근제한자 예약어 반환자료형 메소드명([자료형 매개변수명]){}
	public void displayPerson(){
		System.out.println(name + ", " + age + ", " + height + ", " + weight);
	}
	
	
}
