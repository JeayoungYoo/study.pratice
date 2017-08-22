package board.model.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.vo.Board;

public class BoardDao {
	public BoardDao() {
	}

	public int getListCount() {
		int listCount = 0;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			listCount = session.selectOne("Board.getListCount");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return listCount;
	}

	public ArrayList<Board> selectTopReadCount() {
		List<Board> list = null;

		SqlSession session = null;
		try {

			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			list = session.selectList("Board.selectTopReadCount");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return (ArrayList<Board>) list;
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		// 페이지 단위로 게시글 목록 조회용 메소드
		List<Board> list = null;

		int startRow = (currentPage - 1) * limit + 1;
		int endRow = startRow + limit - 1;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("startRow", startRow);
			map.put("endRow", endRow);
			list = session.selectList("Board.selectList", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return (ArrayList<Board>) list;
	}

	public int insertBoard(Board b) {
		int result = 0;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			result = session.insert("Board.insertBoard", b);
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

	public Board selectBoard(int boardNum) {
		Board board = null;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			board = session.selectOne("Board.selectBoard", boardNum);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return board;
	}

	public int addReadCount(int boardNum) {
		int result = 0;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			result = session.update("Board.addReadCount", boardNum);
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

	public int deleteBoard(int boardNum) {
		int result = 0;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			result = session.update("Board.deleteBoard", boardNum);
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

	public int insertReply(Board originBoard, Board replyBoard) {
		int result = 0;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			if (replyBoard.getBoardLevel() == 1)
				result = session.update("Board.insertReply1", replyBoard);
			if (replyBoard.getBoardLevel() == 2)
				result = session.update("Board.insertReply2", replyBoard);
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

	public int updateReplySeq(Board replyBoard) {
		int result = 0;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			result = session.update("Board.updateReplySeq", replyBoard);
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

	public int updateReply(Board board) {
		int result = 0;

		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			result = session.update("Board.updateReply", board);
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

	public int updateBoard(Board board) {
		int result = 0;
		SqlSession session = null;
		try {
			session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"))
					.openSession(false);

			result = session.update("Board.updateBoard", board);
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
