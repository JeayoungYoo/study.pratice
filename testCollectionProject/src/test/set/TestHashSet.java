package test.set;

import java.util.*;

public class TestHashSet {

	public static void main(String[] args) {
		// HashSet test
		HashSet hset = new HashSet();
		hset.add(new String("apple"));
		hset.add("banana");
		hset.add(new Integer(123)); // Boxing 처리
		hset.add(456); // AutoBoxing 처리함
		hset.add(3.15); // AutoBoxing 처리됨
		hset.add(new Double(54.7));
		
		System.out.println(hset); // 저장 순서 유지 안 됨
		// 중복 허용 안 함
		hset.add("apple");
		System.out.println(hset); // 저장 순서 유지 안 됨
		
		// 저장된 객체를 연속으로 처리해야 할 경우
		// 첫번째는 목록(Iterator) 을 이용 하는 방법
		
		Iterator iter = hset.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		// 두번째는 Object[]로 바꾸어 이용하는 방법
		Object[] objArr = hset.toArray();
		for(int i=0; i<objArr.length; i++)
			System.out.println(i+1 + "번째 : " + objArr[i]);
		
		// 객체 배열과 컬렉션은 for ~ each문으로 사용할 수 있다.
		
		for(Object obj : objArr)
			System.out.println(obj);
		System.out.println("저장 객체 수 : " + hset.size());
		hset.remove("apple");
		System.out.println(hset);
		
		System.out.println("포함 확인 : "+ hset.contains("banana"));
		hset.clear();
		System.out.println("빈 공간 확인 : " + hset.isEmpty());
		

	}

}
