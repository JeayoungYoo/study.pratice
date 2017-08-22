package notice.model.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import notice.model.vo.Notice;

public class NoticeDao {
	public NoticeDao() {
	}

	public ArrayList<Notice> selectList() {
		List<Notice> list = null;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			list = session.selectList("Notice.selectList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return (ArrayList<Notice>) list;
	}

	public HashMap<Integer, Notice> selectMap() {
		Map<Integer, Notice> listMap = null;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			listMap = session.selectMap("Notice.selectMap", "noticeNo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return (HashMap<Integer, Notice>) listMap;
	}

	public Notice selectOne(int noticeNo) {
		Notice notice = null;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			notice = session.selectOne("Notice.selectOne", noticeNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return notice;
	}

	public ArrayList<Notice> selectTitle(String keyword) {
		List<Notice> list = null;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			list = session.selectList("Notice.selectTitle", keyword);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return (ArrayList<Notice>) list;
	}

	public int insertNotice(Notice n) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			result = session.insert("Notice.insertNotice", n);
			if (result > 0)
				session.commit();
			else
				session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	public int updateNotice(Notice n) {
		int result = 0;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			result = session.update("Notice.updateNotice", n);
			if (result > 0)
				session.commit();
			else
				session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	public int deleteNotice(int noticeNo) {
		int result = 0;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			result = session.delete("Notice.deleteNotice", noticeNo);
			if (result > 0)
				session.commit();
			else
				session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}
}
