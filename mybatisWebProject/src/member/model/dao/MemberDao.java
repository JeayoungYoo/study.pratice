package member.model.dao;

import java.sql.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.model.vo.Member;

public class MemberDao {
	public MemberDao(){}

	public Member selectMember(Member mb) {
		Member member = null;
		// mybatis를 사용하기 위한 sqlsession 사용 준비
		SqlSession session = null;
		
		try {
			// Mybatic config 파일의 내용을 읽어서, db 연결하고 statement 객체 생성 처리와 동일한 의미를 가진 코드임
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			// Mapper 파일에 작성된 쿼리문 실행시키고 결과 받음
			member = session.selectOne("Member.loginCheck", mb);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(session != null) {
				session.close();
			}
			
		}
		return member;
	}

	public int insertMember(Member m) {
		int result = 0;
		SqlSession session = null;
	
		
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.insert("Member.insertMember", m);
			if(result > 0){
				session.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}

	public int updateMember(Member m) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.update("Member.updateMember", m);
			if(result > 0){
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}					
		return result;
	}

	public int deleteMember(String userId) {
		int result = 0;
		SqlSession session = null;
		
		
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.delete("Member.deleteMember", userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}				
					
		return result;
	}

	public int checkUserId(String userId) {
		int result = 0;
		SqlSession session = null;
		
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession(false);
			result = session.selectOne("Member.countMember", userId);
			
		} catch (Exception e) {
			
		} finally {
			session.close();
		}
		
		return result;
	}
	
	
}









