package board.model.vo;

import java.util.Comparator;

public class DescBoardTitle implements Comparator {
	
	public DescBoardTitle() {
		
	}

	@Override
	public int compare(Object o1, Object o2) {
		int result = 0;
		if (o1 instanceof Board && o2 instanceof Board) {
			Board p1 = (Board) o1;
			Board p2 = (Board) o2;
			
			result = p1.getBoardTitle().compareTo(p2.getBoardTitle());
		}
		return -result;
	}

}