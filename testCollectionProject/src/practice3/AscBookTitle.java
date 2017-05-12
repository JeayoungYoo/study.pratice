package practice3;

import practice2.Book;
import test.list.Person;

public class AscBookTitle implements java.util.Comparator {

	@Override
	public int compare(Object obj1, Object obj2){
		int result = 0;
		if(obj1 instanceof Book && obj2 instanceof Book){
			Book p1 = (Book)obj1;
			Book p2 = (Book)obj2;
			
			result = (p1.getTitle().compareTo(p2.getTitle()));
		}
		return result;
	}

}
