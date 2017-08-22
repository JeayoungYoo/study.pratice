package notice.model.service;


import java.sql.Connection;
import java.util.*;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

public class NoticeService {
	public NoticeService(){}
	
	public ArrayList<Notice> selectList(){
		return new NoticeDao().selectList();
	}
	
	public HashMap<Integer, Notice> selectMap(){
		return new NoticeDao().selectMap();
	}
	
	public Notice selectOne(int noticeNo){
		return new NoticeDao().selectOne(noticeNo);
	}
	
	public ArrayList<Notice> selectTitle(String keyword){
		return new NoticeDao().selectTitle(keyword);
	}
	
	public int insertNotice(Notice n){
		return new NoticeDao().insertNotice(n);
	}
	
	public int updateNotice(Notice n){
		return new NoticeDao().updateNotice(n);
	}
	
	public int deleteNotice(int noticeNo){
		return new NoticeDao().deleteNotice(noticeNo);
	}
}
