package test.set;

import java.util.*;

public class TestLinkedHashSet {

	public static void main(String[] args) {
		// LinkedHashSet : ���� ������ �����Ǵ� Set
		LinkedHashSet lset = new LinkedHashSet();
		
		lset.add("apple");
		lset.add("banana");
		lset.add(123);
		lset.add(54.7);
		lset.add("apple");
		System.out.println(lset);
		System.out.println("-----------------------");
		
		//��ü �迭�� ���� ó�� : for�� ���
		Object[] objArr = lset.toArray();
		for (int i=0; i<objArr.length; i++)
			System.out.println(objArr[i]);
		
		System.out.println("-----------------------");
		// for ~ each�� ���
		
		for (Object obj : objArr)
			System.out.println(obj);
		
		System.out.println("-----------------------");
		
		//������� ���� ó��
		Iterator iter = lset.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());

	}

}
