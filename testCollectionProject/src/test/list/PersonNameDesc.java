package test.list;

import java.util.Comparator;

public class PersonNameDesc implements Comparator {
	public PersonNameDesc(){}

	@Override
	public int compare(Object obj1, Object obj2){
		int result = 0;
		if(obj1 instanceof Person && obj2 instanceof Person){
			Person p1 = (Person)obj1;
			Person p2 = (Person)obj2;
			result = (p1.getName().compareTo(p2.getName()));
		}
		return -result;
	}
}
