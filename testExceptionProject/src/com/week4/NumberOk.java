package com.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class NumberOk {
	Random r = new Random();
	int ran = r.nextInt(99)+1;
	
	public static void main(String[] args) {
		NumberOk no = new NumberOk();
		int cnt=0;
		do{
			if (no.questionNumber(no.getNumber())==1){
				System.out.println("Ů�ϴ�");
				cnt++;
			}
			if (no.questionNumber(no.getNumber())==-1){
				System.out.println("�۽��ϴ�");
				cnt++;
			}
			if (no.questionNumber(no.getNumber())==0)
			{
				System.out.println(cnt + "��°�� �¾ҽ��ϴ�.");
				break;
			}
		
		}while(true);

	}
	
	public int getNumber(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ڸ� �Է����ּ���");
		try {
			return br.read();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int questionNumber (int a){
		a = this.getNumber();
		if (a == ran)
			return 0;
		else if (a < ran)
			return -1;
		else
			return 1;
			
		}
	}


