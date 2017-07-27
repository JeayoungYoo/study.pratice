package board.model.service;

import java.util.*;
import java.sql.*;

import board.model.vo.Board;
import notice.model.dao.NoticeDao;
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

	public int insertBoard(Board board) {
		Connection con = getConnection();
		int result = new BoardDao().insertBoard(con, board);
		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	public Board selectBoard(int boardNum) {
		Connection con = getConnection();
		Board b = new BoardDao().selectBoard(con, boardNum);
		close(con);

		return b;
	}

	public void addReadCount(int boardNum) {
		Connection con = getConnection();
		int result = new BoardDao().addReadCount(con, boardNum);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

	}

	public int deleteBoard(int boardNum) {
		Connection con = getConnection();
		int result = new BoardDao().deleteBoard(con, boardNum);
		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	public int insertReply(Board replyB, Board originB) {
		Connection con = getConnection();
		int result = new BoardDao().insertReply(originB, replyB, con);
		
		if (result > 0)
			commit(con);
		else
			rollback(con);

		close(con);

		return result;
	}

	public void updateReplySeq(Board replyB) {
		Connection con = getConnection();
		int result = new BoardDao().updateReplySeq(con, replyB);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		
	}

	public int updateBoard(Board board) {
		
		Connection con = getConnection();
		int result = new BoardDao().updateBoard(con, board);
		
		if (result > 0)
			commit(con);
		else
			rollback(con);
		
		close(con);
		
		return result;
	}

	public int updateReply(Board board) {
		Connection con = getConnection();
		int result = new BoardDao().updateReply(con, board);
		if(result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
}
