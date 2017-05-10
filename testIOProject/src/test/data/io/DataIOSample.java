package test.data.io;

import java.io.*;
import java.util.Scanner;

public class DataIOSample {
	private Scanner sc = new Scanner(System.in);
	
	public DataIOSample(){
		
	}
	
	public void testDataOutputStream(){
//		DataOutputStream dout = null;
		
		try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("member.dat"));) {
//			dout = new DataOutputStream(new FileOutputStream("member.dat"));
			
			for(int count =1; count <=3; count++){
				System.out.print("�̸� : ");
				dout.writeUTF(sc.next());
				System.out.print("���� : ");
				dout.writeInt(sc.nextInt());
				System.out.print("����(��M/��F) : ");
				dout.writeChar(sc.next().toUpperCase().charAt(0));
				System.out.print("����Ʈ����(�Ҽ��� ù°�ڸ����� �Է�) : ");
				dout.writeDouble(sc.nextDouble());
			}
			
			System.out.println("member.dat ���Ͽ� ���� �Ϸ��");
			
		} catch (Exception e) {
			e.printStackTrace();
		} /*finally {
			try {
				dout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	private class Member{
		private String name;
		private int age;
		private char gender;
		private double point;
		
		public Member(){}

		public Member(String name, int age, char gender, double point) {
			super();
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.point = point;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public double getPoint() {
			return point;
		}

		public void setPoint(double point) {
			this.point = point;
		}

		@Override
		public String toString() {
			return name + ", " + age + ", " + gender + ", " + point;
		}
		
		
	}
	
	public void testDataInputStream(){
		DataInputStream din = null;
		Member[] marray = new Member[3];
		
		
		try {
			din = new DataInputStream(new FileInputStream("member.dat"));
			
			for (int i = 0; i < marray.length; i++){
				marray[i] = new Member();
				marray[i].setName(din.readUTF());
				marray[i].setAge(din.readInt());
				marray[i].setGender(din.readChar());
				marray[i].setPoint(din.readDouble());
				
				System.out.println(i+1 + " : " + marray[i].toString());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
