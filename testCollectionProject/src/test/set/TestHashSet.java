package test.set;

import java.util.*;

public class TestHashSet {

	public static void main(String[] args) {
		// HashSet test
		HashSet hset = new HashSet();
		hset.add(new String("apple"));
		hset.add("banana");
		hset.add(new Integer(123)); // Boxing ó��
		hset.add(456); // AutoBoxing ó����
		hset.add(3.15); // AutoBoxing ó����
		hset.add(new Double(54.7));
		
		System.out.println(hset); // ���� ���� ���� �� ��
		// �ߺ� ��� �� ��
		hset.add("apple");
		System.out.println(hset); // ���� ���� ���� �� ��
		
		// ����� ��ü�� �������� ó���ؾ� �� ���
		// ù��°�� ���(Iterator) �� �̿� �ϴ� ���
		
		Iterator iter = hset.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		// �ι�°�� Object[]�� �ٲپ� �̿��ϴ� ���
		Object[] objArr = hset.toArray();
		for(int i=0; i<objArr.length; i++)
			System.out.println(i+1 + "��° : " + objArr[i]);
		
		// ��ü �迭�� �÷����� for ~ each������ ����� �� �ִ�.
		
		for(Object obj : objArr)
			System.out.println(obj);
		System.out.println("���� ��ü �� : " + hset.size());
		hset.remove("apple");
		System.out.println(hset);
		
		System.out.println("���� Ȯ�� : "+ hset.contains("banana"));
		hset.clear();
		System.out.println("�� ���� Ȯ�� : " + hset.isEmpty());
		

	}

}
