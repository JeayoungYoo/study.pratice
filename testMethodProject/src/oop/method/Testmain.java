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
		
		System.out.println("���ڿ��� ���Ե� ������ ���� : " + nss.countChar("javasibalssibal", 's'));
		
		System.out.println("�� ���� ������ ������ �հ� : "+ nss.totalValue(52, 100));
		
		System.out.println("���ڿ��� ��ġ�� ���� : " + nss.pCharAt("java programming", 6));
		
		System.out.println("�� ���ڿ� ��ġ�� : " + nss.pConcat("�ڹٴ� ", "�����."));
	}
}
