package ncs.test1;

import java.util.Random;

public class ArrayTest {

	public static void main(String[] args) {
		Random r = new Random();
		int [] array = new int[10];
		
		for (int i=0; i<array.length; i++){
			array[i] = r.nextInt(99)+1;
		}
		
		new ArrayTest().print(array);

	}
	
	public int sum (int[] arr){
		int sum=0;
		for (int i=0; i<arr.length; i++)
			sum =+ arr[i];
		return sum;
	}
	
	public double avg (int[] arr){
		double avg=0;
		for (int i=0; i<arr.length; i++)
			avg =+ arr[i];
		return avg/arr.length;
	}
	
	public int max (int[] arr){
		int max=0;
		for(int i=0; i<arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
			
	}
	
	public int min (int[] arr){
		int min=0;
		for(int i=0; i<arr.length; i++) {
			if (min > arr[i])
				min = arr[i];
		}
		return min;
	}
	
	public int evenCount(int[] arr){
		int evencount=0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i]%2==0)
				evencount++;
		}
		return evencount;
	}
	
	public int oddCount(int[] arr){
		int oddcount=0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i]%2!=0)
				oddcount++;
		}
		return oddcount;
	}
	
	public void print(int[] arr){
		System.out.println("�Ҵ�� �迭�� ũ�� : " + arr.length);
		System.out.print("array : ");
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + "\t");
		System.out.println();
		System.out.println("���� ū �� : " + max(arr));
		System.out.println("���� ���� �� : " + min(arr));
		System.out.println("¦���� ���� : " + evenCount(arr));
		System.out.println("Ȧ���� ���� : " + oddCount(arr));
		System.out.println("�հ� : " + sum(arr));
		System.out.println("��� : " + avg(arr));
		
	}

}
