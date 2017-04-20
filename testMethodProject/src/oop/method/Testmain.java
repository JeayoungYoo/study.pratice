package oop.method;

public class Testmain {
	public static void main(String[] args){
		NonStaticSample nss = new NonStaticSample();
		
		int a[], b[];
		System.out.println(nss.intArrayAllocation(42));
		nss.display(new int[]{10,20,30});
		int[] temp = nss.swap(new int[]{20,10,2,8,6},1,4);
		for (int e : temp){
			System.out.print("["+e+"]");
		}
		System.out.println();
		
		a=nss.sortDescending(new int[]{48 ,18, 28, 38, 2});
		nss.display(a);
		
		b=nss.sortAscending(new int[]{48, 18, 28, 38, 2});
		nss.display(b);
		
		System.out.println("문자열에 포함된 문자의 갯수 : " + nss.countChar("javasibalssibal", 's'));
		
		System.out.println("두 정수 사이의 값들의 합계 : "+ nss.totalValue(52, 100));
		
		System.out.println("문자열의 위치의 문자 : " + nss.pCharAt("java programming", 6));
		
		System.out.println("두 문자열 합치기 : " + nss.pConcat("자바는 ", "어려워."));
	}
}
