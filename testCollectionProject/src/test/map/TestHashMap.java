package test.map;

import java.util.*;

import practice2.Book;
import test.list.Person;

public class TestHashMap {

	public static void main(String[] args) {
		// HashMap test
		HashMap hmap = new HashMap();
		
		hmap.put("one", new Person("ȫ�浿", 25, 123.5));
		hmap.put("23", new Book("23", 1, "�ظ�����5", "J&K�Ѹ�"));
		
		System.out.println(hmap.size() + "�� ����");
		System.out.println(hmap);
		
		//key�� set ������ ó���� : �ߺ� ���  �� ��
		hmap.put("one", "java collection framework");
		System.out.println(hmap.size() + "�� ����");
		System.out.println(hmap);
		
		//value �� list ������ ����� : �ߺ� ����
		hmap.put(77, "java collection framework");
		System.out.println(hmap.size() + "�� ����");
		System.out.println(hmap);
		System.out.println(hmap.get(77));
		
		hmap.replace(77, new Person("ȫ�浿", 25, 123.5));
		System.out.println(hmap.get(77));
		
		//�������� ó���� ���� ���
		//1. Ű�� set ���� �ٲ� ����, iterator ���
		/*Set keys = hmap.keySet();
		Iterator keyIter = keys.iterator();*/
		System.out.println("key�� iterator ó���� ��� -------------");
		Iterator keyIter = hmap.keySet().iterator();
		while (keyIter.hasNext()){
			Object key = keyIter.next();
			System.out.println(hmap.get(key));
		}
		
		
		//2. value �� collection ���� �ٲ� ����, iterator �Ǵ� toArray ���
		System.out.println("value ��ü�� collection ���� �ٲ� ��� -------------");
		/*Collection values = hmap.values();
		Iterator valueIter = values.iterator();*/
		
		Iterator valueIter = hmap.values().iterator();
		
		while(valueIter.hasNext()){
			System.out.println(valueIter.next());
		}
		
		System.out.println("value ��ü�� collection ���� �ٲ� ���� �迭��  -------------");
		/*Collection valueList = hmap.values();
		Object[] valueArr = valueList.toArray();*/
		
		Object[] valueArr = hmap.values().toArray();
		
		System.out.println("��ü �� : " + valueArr.length);
		
		for (Object obj : valueArr)
			System.out.println(obj);

	}

}
