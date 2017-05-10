package io.silsub2;

import java.io.*;
import java.util.Scanner;



public class SungjukProcess {
	
	private Scanner sc = new Scanner(System.in);
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;

	
	public void sungjukSaver(){
		DataOutputStream dout = null;

		
		try {
			dout = new DataOutputStream(new FileOutputStream("score.dat", true));
			
			do{
				System.out.print("국어 : ");
				kor = sc.nextInt();
				dout.writeInt(kor);
				System.out.print("영어 : ");
				eng = sc.nextInt();
				dout.writeInt(eng);
				System.out.print("수학 : ");
				math = sc.nextInt();
				dout.writeInt(math);
				sum = kor + eng + math;
				avg = (double)sum/3;
				dout.writeInt(sum);
				dout.writeDouble(avg);
				
				System.out.println("계속 저장하시겠습니까(y/n)?");
				if(sc.next().toUpperCase().charAt(0)=='N')
					break;
				
			}while(true);
			
			System.out.println("score.dat 파일에 저장 완료됨");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void scoreRead(){
		DataInputStream din = null;
		int totalSum=0, count=0;
		double totalAvg=0;
		
		try {
			din = new DataInputStream(new FileInputStream("score.dat"));
			
			do {
				int kor = din.readInt();
				int eng = din.readInt();
				int math = din.readInt();
				int sum = din.readInt();
				double avg = din.readDouble();
				totalSum += sum;
				totalAvg += avg;
				count++;
				System.out.printf("%d %d %d %d %.2f \n", kor, eng, math, sum, avg);
			} while (true);
		} catch (EOFException e) {
			System.out.printf("%5d%5d%7.2f\n", count, totalSum, totalAvg/count);
			
			System.out.println("score.dat 파일 읽기 완료...");
		} catch (IOException e) {
			System.out.println("score.dat 파일 읽기 실패...");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public SungjukProcess(int kor, int eng, int math, int sum, double avg) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = sum;
		this.avg = avg;
	}

	public SungjukProcess() {
		
	}

	@Override
	public String toString() {
		return kor + ", " + eng + ", " + math + ", " + sum + ", " + avg;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public static void main(String[] args) {
		SungjukProcess sp = new SungjukProcess();
		
		sp.sungjukSaver();
		sp.scoreRead();
		

	}

}
