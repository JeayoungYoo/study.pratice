package board.model.service;

import java.util.*;
import java.sql.*;

import board.model.vo.Board;
import board.model.dao.BoardDao;


public class BoardService {
	public BoardService(){}

	public int getListCount() {
		return new BoardDao().getListCount();
	}
	
	public ArrayList<Board> selectTopReadCount(){
		return new BoardDao().selectTopReadCount();
	}

	public ArrayList<Board> selectList(int currentPage, 
			int limit) {
		return new BoardDao().selectList(currentPage, limit);
	}

	public int insertBoard(Board b) {
		return new BoardDao().insertBoard(b);
	}
	
	public Board selectBoard(int boardNum){
		return new BoardDao().selectBoard(boardNum);
	}

	public int addReadCount(int boardNum) {
		return new BoardDao().addReadCount(boardNum);
	}

	public int deleteBoard(int boardNum) {
		return new BoardDao().deleteBoard(boardNum);
	}

	public int insertReply(Board originBoard, Board replyBoard) {
		return new BoardDao().insertReply(originBoard, replyBoard);
	}

	public int updateReplySeq(Board replyBoard) {
		return new BoardDao().updateReplySeq(replyBoard);
	}

	public int updateReply(Board board) {
		return new BoardDao().updateReply(board);
	}

	public int updateBoard(Board board) {
		return new BoardDao().updateBoard(board);
	}
}




