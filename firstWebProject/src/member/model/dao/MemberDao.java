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
			
			if(rset.next()) {
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
}
