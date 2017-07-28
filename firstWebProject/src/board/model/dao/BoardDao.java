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

		/*
		 * String query =
		 * "SELECT * FROM (SELECT ROWNUM rnum, BOARD_NUM, BOARD_TITLE, BOARD_WRITER, "
		 * + "BOARD_CONTENT, BOARD_ORIGINAL_FILENAME, BOARD_RENAME_FILENAME, " +
		 * "BOARD_DATE, BOARD_LEVEL, BOARD_REPLY_REF, BOARD_REPLY_SEQ, " +
		 * "BOARD_READ_COUNT FROM (SELECT * FROM BOARD ORDER BY BOARD_REPLY_REF DESC)) "
		 * + "WHERE rnum >= ? AND rnum <= ?";
		 */

		String query = "SELECT T.* FROM (SELECT ROWNUM RNUM, T.* FROM "
				+ "(SELECT * FROM BOARD ORDER BY BOARD_REF DESC, BOARD_REPLY_REF DESC, BOARD_LEVEL ASC, BOARD_REPLY_SEQ ASC) T) T WHERE RNUM >= ? AND RNUM <= ?";

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
					b.setBoardRef(rset.getInt("BOARD_REF"));
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

	public int insertBoard(Connection con, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "INSERT INTO BOARD VALUES ((SELECT MAX(BOARD_NUM) FROM BOARD) + 1,"
				+ " ?, ?, ?, ?, ?, DEFAULT, DEFAULT, (SELECT MAX(BOARD_NUM) FROM BOARD) + 1, NULL, DEFAULT, DEFAULT)";

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
					b.setBoardRef(rset.getInt("BOARD_REF"));
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
		int result = 0;
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

	public int deleteBoard(Connection con, int boardNum) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = null;

		try {
			query = "DELETE FROM BOARD WHERE BOARD_NUM = ?";
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

	public int updateReplySeq(Connection con, Board replyB) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "UPDATE BOARD SET BOARD_REPLY_REF = BOARD_REPLY_SEQ + 1"
				+ " WHERE BOARD_REF = ?  AND BOARD_LEVEL = ? AND BOARD_REPLY_REF = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, replyB.getBoardRef());
			pstmt.setInt(2, replyB.getBoardLevel());
			pstmt.setInt(3, replyB.getBoardReplyRef());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertReply(Board replyB, Board originB, Connection con) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = null;

		if (replyB.getBoardLevel() == 1) {
			query = "insert into board values " + "((select max(board_num) + 1 from board), "
					+ "?, ?, ?, NULL, NULL, sysdate, ?, ?, " + "(select max(board_num) + 1 from board), "
					+ "1, default)";
		}

		if (replyB.getBoardLevel() == 2) {
			query = "insert into board values " + "((select max(board_num) + 1 from board), "
					+ "?, ?, ?, NULL, NULL, sysdate, ?, ?, ?, " + "1, default)";
		}

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, replyB.getBoardTitle());
			pstmt.setString(2, replyB.getBoardWriter());
			pstmt.setString(3, replyB.getBoardContent());
			pstmt.setInt(4, replyB.getBoardLevel());
			pstmt.setInt(5, replyB.getBoardRef());

			if (replyB.getBoardLevel() == 2)
				pstmt.setInt(6, replyB.getBoardReplyRef());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateBoard(Connection con, Board board) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "UPDATE BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ?, BOARD_ORIGINAL_FILENAME = ?, BOARD_RENAME_FILENAME = ? WHERE BOARD_NUM = ?";
		System.out.println("다오 업데이트 콘텐츠 : " + board.toString());
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setString(3, board.getBoardOriginalFileName());
			pstmt.setString(4, board.getBoardRenameFileName());
			pstmt.setInt(5, board.getBoardNum());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateReply(Connection con, Board board) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update board " + "set board_title = ?, " + "board_content = ? " + "where board_num = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getBoardNum());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Board> selectList(Connection con) {
		ArrayList<Board> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM (SELECT * FROM BOARD ORDER BY BOARD_READ_COUNT DESC) WHERE BOARD_LEVEL = 0 AND ROWNUM < 6";

		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);

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
					b.setBoardRef(rset.getInt("BOARD_REF"));
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
			close(stmt);
		}

		return list;
	}
}
