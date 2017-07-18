package member.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	
	public MemberService() {
	}
	
	public Member selectMember(String userId, String userPwd){
		Connection con = getConnection();
		Member loginMember = new MemberDao().selectMember(con, userId, userPwd);
		close(con);
		
		return loginMember;
	}

}
