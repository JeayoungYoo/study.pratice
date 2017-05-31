package ncs.test4;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Notice  implements Serializable {
	private int no;
	private String title;
	private Calendar date;
	private String writer;
	private String content;
	public Notice() {
		super();
	}
	public Notice(int no, String title, Calendar date, String writer, String content) {
		super();
		this.no = no;
		this.title = title;
		this.date = date;
		this.writer = writer;
		this.content = content;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Calendar getDate() {
		return date;
	}
	public void setDate(Calendar date) {
		this.date = date;
	}
	public String getWriter() {
		return writer;
	}
	public void setWinter(String winter) {
		this.writer = winter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Notice [no=" + no + ", title=" + title + ", date=" + date + ", winter=" + writer + ", content="
				+ content + "]";
	}
	
	
}
