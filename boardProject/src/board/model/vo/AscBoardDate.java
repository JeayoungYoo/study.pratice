package board.model.vo;

import java.util.Comparator;

public class AscBoardDate implements Comparator {

	public AscBoardDate() {
		
	}

	@Override
	public int compare(Object o1, Object o2) {
		int result = 0;
		if (o1 instanceof Board && o2 instanceof Board) {
			Board p1 = (Board) o1;
			Board p2 = (Board) o2;
			
			result = p1.getBoardDate().compareTo(p2.getBoardDate());
		}
		return result;
	}
}
