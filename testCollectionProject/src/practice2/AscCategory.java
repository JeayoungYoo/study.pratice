package practice2;

import test.list.Person;

public class AscCategory implements java.util.Comparator {

	@Override
	public int compare(Object obj1, Object obj2){
		int result = 0;
		if(obj1 instanceof Book && obj2 instanceof Book){
			Book p1 = (Book)obj1;
			Book p2 = (Book)obj2;
			result = (p1.getCategory() > p2.getCategory()) ? 1 : (p1.getCategory() == p2.getCategory()) ? 0 : -1;
		}
		return result;
	}

}
