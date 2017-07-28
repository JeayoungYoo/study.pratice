package member.model.dao;

import static common.JDBCTemplate.*;
import java.sql.*;

import member.model.vo.Member;

public class MemberDao {
	public MemberDao() {
	}

	public Member selectMember(Connection con, String userId, String userPwd) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWD = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				member = new Member();
				member.setId(userId);
				member.setPasswd(userPwd);
				member.setName(rset.getString("NAME"));
				member.setEmail(rset.getString("EMAIL"));
				member.setGender(rset.getString("GENDER"));
				member.setAge(rset.getInt("AGE"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setEnroll_date(rset.getDate("ENROLL_DATE"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return member;
	}

	public int insertMember(Connection con, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "INSERT INTO MEMBER VALUES (?, ?, ?, ?, ?, ?, ?, ?, DEFAULT)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPasswd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getGender());
			pstmt.setInt(6, m.getAge());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateMember(Connection con, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "UPDATE MEMBER SET PASSWD = ?, EMAIL = ?, AGE = ?, PHONE = ?, ADDRESS = ?"
		+ " WHERE ID = ?";

		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, m.getPasswd());
			pstmt.setString(2, m.getEmail());
			pstmt.setInt(3, m.getAge());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;		
	}

	public int deleteMember(Connection con, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "DELETE FROM MEMBER WHERE ID = ?";

		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;	
	}

	public int selectMember(Connection con, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(*) from member "
				+ "where id = ?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				if(rset.getInt(1) > 0)
					result = 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
