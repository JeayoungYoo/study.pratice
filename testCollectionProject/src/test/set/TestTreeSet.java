package test.set;

import java.util.*;

public class TestTreeSet {

	public static void main(String[] args) {
		// TreeSet test
//		TreeSet tset = new TreeSet();
		Set tset = new TreeSet();
		
		tset.add("orange");
		tset.add("banana");
		tset.add("apple");
		tset.add("grape");
		
		System.out.println(tset);
		
		Set descendSet = ((TreeSet)tset).descendingSet();
		System.out.println(descendSet);
		
//		System.out.println(tset.descendingSet());

	}

}
