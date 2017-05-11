package test.set;

import java.util.*;

public class TestLinkedHashSet {

	public static void main(String[] args) {
		// LinkedHashSet : 저장 순서가 유지되는 Set
		LinkedHashSet lset = new LinkedHashSet();
		
		lset.add("apple");
		lset.add("banana");
		lset.add(123);
		lset.add(54.7);
		lset.add("apple");
		System.out.println(lset);
		System.out.println("-----------------------");
		
		//객체 배열로 연속 처리 : for문 사용
		Object[] objArr = lset.toArray();
		for (int i=0; i<objArr.length; i++)
			System.out.println(objArr[i]);
		
		System.out.println("-----------------------");
		// for ~ each문 사용
		
		for (Object obj : objArr)
			System.out.println(obj);
		
		System.out.println("-----------------------");
		
		//목록으로 연속 처리
		Iterator iter = lset.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());

	}

}
