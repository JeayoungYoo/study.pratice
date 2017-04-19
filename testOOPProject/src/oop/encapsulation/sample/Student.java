package oop.encapsulation.sample;

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
	private int phone;//��ȭ��ȣ
	private String professor;//��������
	
	
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
	
	//����Լ�(Method)
	//���������� [static]��ȯ�ڷ��� �޼ҵ��̸�(�ڷ��� �Ű�����){  ó������}
	public void setSno(int no){
		System.out.println("this �� ���� ��ü�� �ּ� : " + this.hashCode());
		this.sno = no;
	}
	
	public void printInformaiton(){
		System.out.println(this.sno + ", " + this.name + ", " + this.major + ", " + this.gender + ", " + this.score + ", " + this.phone + ", " + this.address + ", " + this.professor );
	}
		public Student (int sno, String name, String major, char gender, double score, String address, int phone, String professor){
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
