package ncs4.test1;

public class Decending implements java.util.Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2)*-1;
	}


}
