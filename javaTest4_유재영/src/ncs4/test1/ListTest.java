package ncs4.test1;

import java.util.*;

public class ListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Random r = new Random();
		
		for (int i=0; i<10 ; i++) {
			list.add(r.nextInt(99)+1);
		}
		
		list.sort(new Decending());
		
		new ListTest().display(list);

	}
	
	public void display (List list) {
		System.out.println(list);
	}

}
