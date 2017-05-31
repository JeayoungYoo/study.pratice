package ncs.test4;

import java.util.Date;

public class Notice {
	private int no;
	private String title;
	private Date date;
	private String winter;
	private String content;
	public Notice() {
		super();
	}
	public Notice(int no, String title, Date date, String winter, String content) {
		super();
		this.no = no;
		this.title = title;
		this.date = date;
		this.winter = winter;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getWinter() {
		return winter;
	}
	public void setWinter(String winter) {
		this.winter = winter;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Notice [no=" + no + ", title=" + title + ", date=" + date + ", winter=" + winter + ", content="
				+ content + "]";
	}
	
	
}
