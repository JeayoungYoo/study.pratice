package notice.model.dao;

import static common.JDBCTemplate.*;
import java.sql.*;
import java.util.*;
import notice.model.vo.Notice;

public class NoticeDao {

	public NoticeDao() {

	}

	public ArrayList<Notice> selectList(Connection con) {
		ArrayList<Notice> listArr = null;
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM NOTICE ORDER BY NOTICE_NO DESC";

		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset != null) {
				listArr = new ArrayList<Notice>();

				while (rset.next()) {
					n = new Notice();
					n.setNoticeNo(rset.getInt("notice_no"));
					n.setNoticeTitle(rset.getString("notice_title"));
					n.setNoticeWriter(rset.getString("notice_writer"));
					n.setNoticeDate(rset.getDate("notice_date"));
					n.setNoticeContent(rset.getString("notice_content"));
					n.setFilePath(rset.getString("file_path"));
					listArr.add(n);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println(listArr);
		return listArr;
	}

	public HashMap<Integer, Notice> selectMap(Connection con) {
		HashMap<Integer, Notice> hMap = null;
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM NOTICE";

		try {
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset != null) {
				hMap = new HashMap<Integer, Notice>();

				while (rset.next()) {
					n = new Notice();
					n.setNoticeNo(rset.getInt("notice_no"));
					n.setNoticeTitle(rset.getString("notice_title"));
					n.setNoticeWriter(rset.getString("notice_writer"));
					n.setNoticeDate(rset.getDate("notice_date"));
					n.setNoticeContent(rset.getString("notice_content"));
					n.setFilePath(rset.getString("file_path"));
					hMap.put(n.getNoticeNo(), n);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return hMap;
	}

	public Notice selectOne(Connection con, int noticeNo) {
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM NOTICE WHERE NOTICE_NO = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				n = new Notice();
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("notice_writer"));
				n.setNoticeDate(rset.getDate("notice_date"));
				n.setNoticeContent(rset.getString("notice_content"));
				n.setFilePath(rset.getString("file_path"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return n;
	}

	public ArrayList<Notice> selectTitle(Connection con, String keyword) {
		ArrayList<Notice> list = null;
		Notice n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM NOTICE WHERE NOTICE_TITLE LIKE ? ORDER BY NOTICE_NO DESC";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			if (rset != null) {
				list = new ArrayList<Notice>();
				while (rset.next()) {
					n = new Notice();
					n.setNoticeNo(rset.getInt("notice_no"));
					n.setNoticeTitle(rset.getString("notice_title"));
					n.setNoticeWriter(rset.getString("notice_writer"));
					n.setNoticeDate(rset.getDate("notice_date"));
					n.setNoticeContent(rset.getString("notice_content"));
					n.setFilePath(rset.getString("file_path"));
					list.add(n);
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

	public int insertNotice(Connection con, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "INSERT INTO NOTICE VALUES ((SELECT MAX(NOTICE_NO) FROM NOTICE) + 1, ?, ?, DEFAULT, ?, ?)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeWriter());
			pstmt.setString(3, n.getNoticeContent());
			pstmt.setString(4, n.getFilePath());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateNotice(Connection con, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "UPDATE NOTICE SET NOTICE_TITLE = ?, NOTICE_CONTENT = ?, FILE_PATH = ? WHERE NOTICE_NO = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setString(3, n.getFilePath());
			pstmt.setInt(4, n.getNoticeNo());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}

	public int deleteNotice(Connection con, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "DELETE FROM NOTICE WHERE NOTICE_NO = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;

	}
}
