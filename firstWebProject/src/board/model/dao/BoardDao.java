package board.model.dao;

import java.sql.*;

import java.util.ArrayList;

import board.model.vo.Board;
import static common.JDBCTemplate.*;

public class BoardDao {

	public int getListCount(Connection con) {
		int listCount = 0;

		Statement stmt = null;
		ResultSet rset = null;

		String query = "SELECT count(*) from board";

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				listCount = rset.getInt(1);
				// select 절의 첫번째 항목을 뜻함

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}

		return listCount;
	}

	public ArrayList<Board> selectList(Connection con, int currentPage, int limit) {
		// 페이지 단위로 게시글 조회용 메소드
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println("dao커런트" + currentPage);
		String query = "SELECT * FROM (SELECT ROWNUM rnum, BOARD_NUM, BOARD_TITLE, BOARD_WRITER, "
				+ "BOARD_CONTENT, BOARD_ORIGINAL_FILENAME, BOARD_RENAME_FILENAME, "
				+ "BOARD_DATE, BOARD_LEVEL, BOARD_REPLY_REF, BOARD_REPLY_SEQ, "
				+ "BOARD_READ_COUNT FROM (SELECT * FROM BOARD ORDER BY BOARD_REPLY_REF DESC)) "
				+ "WHERE rnum >= ? AND rnum <= ?";

		// String query = "SELECT t.* FROM (SELECT ROWNUM, t.* FROM (SELECT *
		// FROM BOARD ORDER BY BOARD_REPLY_REF DESC) t) t WHERE ROWNUM >= ? AND
		// ROWNUM <= ?";

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		System.out.println("dao start" + startRow + "dao end" + endRow);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);

			rset = pstmt.executeQuery();
			System.out.println("rset" + rset);
			if (rset != null) {
				list = new ArrayList<Board>();
				System.out.println("list" + list);
				while (rset.next()) {
					Board b = new Board();
					b.setBoardNum(rset.getInt("BOARD_NUM"));
					b.setBoardTitle(rset.getString("BOARD_TITLE"));
					b.setBoardWriter(rset.getString("BOARD_WRITER"));
					b.setBoardContent(rset.getString("BOARD_CONTENT"));
					b.setBoardOriginalFileName(rset.getString("BOARD_ORIGINAL_FILENAME"));
					b.setBoardRenameFileName(rset.getString("BOARD_RENAME_FILENAME"));
					b.setBoardDate(rset.getDate("BOARD_DATE"));
					b.setBoardLevel(rset.getInt("BOARD_LEVEL"));
					b.setBoardReplyRef(rset.getInt("BOARD_REPLY_REF"));
					b.setBoardReplySeq(rset.getInt("BOARD_REPLY_SEQ"));
					b.setBoardReadCount(rset.getInt("BOARD_READ_COUNT"));
					System.out.println("b : " + b);
					list.add(b);
				}
			}
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int insertBoard(Connection con, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "INSERT INTO BOARD VALUES ((SELECT MAX(BOARD_NUM) FROM BOARD) + 1,"
				+ " ?, ?, ?, ?, ?, DEFAULT, DEFAULT, (SELECT MAX(BOARD_NUM) FROM BOARD) + 1, DEFAULT, DEFAULT)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardWriter());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setString(4, board.getBoardOriginalFileName());
			pstmt.setString(5, board.getBoardRenameFileName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Board selectBoard(Connection con, int boardNum) {
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM BOARD WHERE BOARD_NUM = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNum);

			rset = pstmt.executeQuery();
			if (rset != null) {
				if (rset.next()) {
					b = new Board();
					b.setBoardNum(rset.getInt("BOARD_NUM"));
					b.setBoardTitle(rset.getString("BOARD_TITLE"));
					b.setBoardWriter(rset.getString("BOARD_WRITER"));
					b.setBoardContent(rset.getString("BOARD_CONTENT"));
					b.setBoardOriginalFileName(rset.getString("BOARD_ORIGINAL_FILENAME"));
					b.setBoardRenameFileName(rset.getString("BOARD_RENAME_FILENAME"));
					b.setBoardDate(rset.getDate("BOARD_DATE"));
					b.setBoardLevel(rset.getInt("BOARD_LEVEL"));
					b.setBoardReplyRef(rset.getInt("BOARD_REPLY_REF"));
					b.setBoardReplySeq(rset.getInt("BOARD_REPLY_SEQ"));
					b.setBoardReadCount(rset.getInt("BOARD_READ_COUNT"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return b;
	}

	public int addReadCount(Connection con, int boardNum) {
		int result = 0 ;
		PreparedStatement pstmt = null;
		
		String query = "UPDATE BOARD SET BOARD_READ_COUNT = BOARD_READ_COUNT + 1 WHERE BOARD_NUM = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, boardNum);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteBoard(Connection con, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = null;
		
		

		try {
			if (board.getBoardLevel() == 0)
				query = "DELETE FROM BOARD WHERE BOARD_NUM = ? ";
			else if (board.getBoardLevel() == 1)
				query = ;
			else if (board.getBoardLevel() == 2)
				query = ;
			
			
			
			pstmt = con.prepareStatement(query);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
