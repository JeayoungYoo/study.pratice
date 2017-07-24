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
		
		String query = "SELECT * FROM (SELECT ROWNUM, BOARD_NUM, BOARD_TITLE, BOARD_WRITER, "
				+ "BOARD_CONTENT, BOARD_ORIGINAL_FILENAME, BOARD_RENAME_FILENAME, "
				+ "BOARD_DATE, BOARD_LEVEL, BOARD_REPLY_REF, BOARD_REPLY_SEQ, "
				+ "BOARD_READ_COUNT FROM (SELECT * FROM BOARD ORDER BY BOARD_REPLY_REF DESC)) "
				+ "WHERE ROWNUM >= ? AND ROWNUM <= ?";
		
		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			if (rset != null) {
				list = new ArrayList<Board>();
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
					
					list.add(b);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
