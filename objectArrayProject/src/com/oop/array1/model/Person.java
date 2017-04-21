package com.oop.array1.model;

public class Person {
	//Field(�������)
	//���������� ����� �ڷ��� ������[= �ʱⰪ];   ==> ����ʵ常�鶩 �ٷ� �ʱ�ȭ ��Ŵ
	private String name;
	private int age;
	private double height;
	private double weight;
	private double property;
		
	//Constructor(������)
	//public Ŭ������([�ڷ��� �Ű�����]){�ʵ� = �ʱⰪ;}
	public Person(){}

	public Person(String name, int age, double height, double weight, double property) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	//Method(����Լ�)
	//setter : �ʵ尪 ���� ó���� ����ϴ� �޼ҵ�
	//public void set�ʵ��(�ڷ��� �Ű�����){�ʵ� = ���氪;}
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

	//getter : �ʵ尪�� ��ȸ�� �޼ҵ�
	//public ��ȯ�ڷ��� get�ʵ��(){ return �ʵ尪; }
	
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
	
	//���������� ����� ��ȯ�ڷ��� �޼ҵ��([�ڷ��� �Ű�������]){}
	public void displayPerson(){
		System.out.println(name + ", " + age + ", " + height + ", " + weight);
	}
	
	
}
