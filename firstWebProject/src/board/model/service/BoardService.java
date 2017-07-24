package board.model.service;

import java.util.*;
import java.sql.*;

import board.model.vo.Board;
import board.model.dao.BoardDao;

import static common.JDBCTemplate.*;

public class BoardService {

	public int getListCount() {
		Connection con = getConnection();
		int listCount = new BoardDao().getListCount(con);
		
		close(con);
		return listCount;
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		ArrayList<Board> list = new BoardDao().selectList(con, currentPage, limit);
		close(con);
		return list;
	}

}
