package member.model.service;

import java.sql.*;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	public MemberService(){}
	
	public Member selectMember(Member mb){
		return new MemberDao().selectMember(mb);
	}

	public int insertMember(Member m) {
		return new MemberDao().insertMember(m);
	}

	public int updateMember(Member m) {
		return new MemberDao().updateMember(m);
	}

	public int deleteMember(String userId) {
		return new MemberDao().deleteMember(userId);
	}

	public int checkUserId(String userId) {
		return 
			new MemberDao().checkUserId(userId);
	}
}






