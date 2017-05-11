package test.list;

import java.util.*;

public class TestArrayList {

	public static void main(String[] args) {
		// ArrayList test
		ArrayList alist = new ArrayList();
		
		alist.add("java");
		alist.add("oracle");
		alist.add("java");
		
		System.out.println(alist);
		
		for(int i=0; i<alist.size(); i++){
			System.out.println(i + " : " + alist.get(i));
		}
		
		// ������ �ִ� �迭�̳� ����Ʈ�� for~each �� ��� �����ϴ�
		for(Object obj : alist)
			System.out.println(obj);
		
		alist.add(1, "jdbc");
		System.out.println(alist);
		
		alist.set(3, "element");
		System.out.println(alist);
		
		alist.remove(2);
		System.out.println(alist);
	}

}
