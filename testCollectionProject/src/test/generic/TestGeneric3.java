package test.generic;

import java.util.*;

public class TestGeneric3 {
	
	
	public void printList(List<String> list){
		/*for (String s : list)
			System.out.println(s);*/
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
	}
	
	public List<String> addList(){
		List<String> alist = new ArrayList<String>();
		alist.add("java");
		alist.add("oracle");
		alist.add("jdbc");
		
		
		return alist;
	}
	public static void main(String[] args) {
		// Generic test
		TestGeneric3 test = new TestGeneric3();
		test.printList(test.addList());		
		
		

	}

}
