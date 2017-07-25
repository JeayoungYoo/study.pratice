package board.model.vo;

import java.sql.Date;

public class Board {
	
	private int boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String boardOriginalFileName;
	private String boardRenameFileName;
	private Date boardDate;
	private int boardLevel;
	private int boardReplyRef;
	private int boardReplySeq;
	private int boardReadCount;
	public Board() {
		super();
	}
	
	



	public Board(String boardTitle, String boardWriter, String boardContent, String boardOriginalFileName,
			String boardRenameFileName) {
		super();
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardOriginalFileName = boardOriginalFileName;
		this.boardRenameFileName = boardRenameFileName;
	}





	public Board(int boardNum, String boardTitle, String boardWriter, String boardContent, String boardOriginalFileName,
			String boardRenameFileName, Date boardDate, int boardLevel, int boardReplyRef, int boardReplySeq,
			int boardReadCount) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardOriginalFileName = boardOriginalFileName;
		this.boardRenameFileName = boardRenameFileName;
		this.boardDate = boardDate;
		this.boardLevel = boardLevel;
		this.boardReplyRef = boardReplyRef;
		this.boardReplySeq = boardReplySeq;
		this.boardReadCount = boardReadCount;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardOriginalFileName() {
		return boardOriginalFileName;
	}
	public void setBoardOriginalFileName(String boardOriginalFileName) {
		this.boardOriginalFileName = boardOriginalFileName;
	}
	public String getBoardRenameFileName() {
		return boardRenameFileName;
	}
	public void setBoardRenameFileName(String boardRenameFileName) {
		this.boardRenameFileName = boardRenameFileName;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardLevel() {
		return boardLevel;
	}
	public void setBoardLevel(int boardLevel) {
		this.boardLevel = boardLevel;
	}
	public int getBoardReplyRef() {
		return boardReplyRef;
	}
	public void setBoardReplyRef(int boardReplyRef) {
		this.boardReplyRef = boardReplyRef;
	}
	public int getBoardReplySeq() {
		return boardReplySeq;
	}
	public void setBoardReplySeq(int boardReplySeq) {
		this.boardReplySeq = boardReplySeq;
	}
	public int getBoardReadCount() {
		return boardReadCount;
	}
	public void setBoardReadCount(int boardReadCount) {
		this.boardReadCount = boardReadCount;
	}
	@Override
	public String toString() {
		return "Board [boardNum=" + boardNum + ", boardTitle=" + boardTitle + ", boardWriter=" + boardWriter
				+ ", boardContent=" + boardContent + ", boardOriginalFileName=" + boardOriginalFileName
				+ ", boardRenameFileName=" + boardRenameFileName + ", boardDate=" + boardDate + ", boardLevel="
				+ boardLevel + ", boardReplyRef=" + boardReplyRef + ", boardReplySeq=" + boardReplySeq
				+ ", boardReadCount=" + boardReadCount + "]";
	}
	
	
	
}
