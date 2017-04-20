package oop.method;

import java.util.Random;

public class NonStaticSample {
	Random r = new Random();
	public NonStaticSample(){}
	
	public int[] intArrayAllocation (int a){
		int[] randomArr = new int[a];
		for (int i=0; i<randomArr.length; i++)
			randomArr[i]=r.nextInt(100)+1;
		
		return randomArr;
	}
	
	public void display(int[] a){
		for (int i=0;i<a.length;i++)
			System.out.print("["+a[i]+"]");
		System.out.println();
	}
	
	public int[] swap(int[] a, int beginIndex, int endIndex){
		int flag;
		
		flag = a[beginIndex];
		a[beginIndex]=a[endIndex];
		a[endIndex]=flag;
		
		return a;
		

		
	}
	
	public int[] sortDescending(int a[]){
		for (int i=0; i<a.length; i++){
			for (int j=i; j<a.length; j++){
				if (a[i]<a[j]){
					swap(a, i, j);
				}
			}
		}
		return a;
	}
	
	public int[] sortAscending(int a[]){
		for (int i=0; i<a.length; i++){
			for (int j=i; j<a.length; j++){
				if (a[i]>a[j]){
					swap(a, i, j);
				}
			}
		}
		return a;
	}
	
	
	public int countChar(String str, char in){
		int cnt=0;
		for(int i=0; i<str.length(); i++){
			if (str.charAt(i)==in)
				cnt++;				
		}
		if (cnt==0) return 0;
		else	return cnt;
	}
	
	public int totalValue(int num1, int num2){
		int max, min, sum=0;
		if (num1>num2){
			max = num1;
			min = num2;
		}
		
		else{
			max = num2;
			min = num1;
		}
		
		for (int i=min; i<=max; i++){
			sum =+ i;
		}
		return sum;
		
	}
	
	public char pCharAt(String input, int chindex){
		char ch = input.charAt(chindex);
		
		return ch;
	}
	
	public String pConcat(String input1, String input2){
		String sumStr;
		sumStr = input1 + input2;
		
		return sumStr;
	}
}
