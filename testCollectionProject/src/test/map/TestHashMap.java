package test.map;

import java.util.*;

import practice2.Book;
import test.list.Person;

public class TestHashMap {

	public static void main(String[] args) {
		// HashMap test
		HashMap hmap = new HashMap();
		
		hmap.put("one", new Person("홍길동", 25, 123.5));
		hmap.put("23", new Book("23", 1, "해리포터5", "J&K롤링"));
		
		System.out.println(hmap.size() + "개 저장");
		System.out.println(hmap);
		
		//key는 set 구조로 처리됨 : 중복 허용  안 됨
		hmap.put("one", "java collection framework");
		System.out.println(hmap.size() + "개 저장");
		System.out.println(hmap);
		
		//value 는 list 구조로 저장됨 : 중복 허용됨
		hmap.put(77, "java collection framework");
		System.out.println(hmap.size() + "개 저장");
		System.out.println(hmap);
		System.out.println(hmap.get(77));
		
		hmap.replace(77, new Person("홍길동", 25, 123.5));
		System.out.println(hmap.get(77));
		
		//연속으로 처리를 원할 경우
		//1. 키를 set 으로 바꾼 다음, iterator 사용
		/*Set keys = hmap.keySet();
		Iterator keyIter = keys.iterator();*/
		System.out.println("key를 iterator 처리한 경우 -------------");
		Iterator keyIter = hmap.keySet().iterator();
		while (keyIter.hasNext()){
			Object key = keyIter.next();
			System.out.println(hmap.get(key));
		}
		
		
		//2. value 를 collection 으로 바꾼 다음, iterator 또는 toArray 사용
		System.out.println("value 객체를 collection 으로 바꾼 경우 -------------");
		/*Collection values = hmap.values();
		Iterator valueIter = values.iterator();*/
		
		Iterator valueIter = hmap.values().iterator();
		
		while(valueIter.hasNext()){
			System.out.println(valueIter.next());
		}
		
		System.out.println("value 객체를 collection 으로 바꾼 다음 배열로  -------------");
		/*Collection valueList = hmap.values();
		Object[] valueArr = valueList.toArray();*/
		
		Object[] valueArr = hmap.values().toArray();
		
		System.out.println("객체 수 : " + valueArr.length);
		
		for (Object obj : valueArr)
			System.out.println(obj);

	}

}
