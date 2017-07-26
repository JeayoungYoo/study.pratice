package board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardReplyServlet
 */
@WebServlet("/breply")
public class BoardReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardReplyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 게시글 원글 추가 등록 처리용 컨트롤러
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int boardNum = Integer.parseInt(request.getParameter("bnum"));
		
		String boardTitle = request.getParameter("btitle");
		String boardContent = request.getParameter("bcontent");
		String boardWriter = request.getParameter("bwriter");

		BoardService bservice = new BoardService();
		// 원글 정보 조회
		Board originB = bservice.selectBoard(boardNum);
		
		// 답글 객체 생성
		Board replyB = new Board();
		replyB.setBoardContent(boardContent);
		replyB.setBoardTitle(boardTitle);
		replyB.setBoardWriter(boardWriter);
		replyB.setBoardLevel(originB.getBoardLevel() + 1);
		replyB.setBoardRef(originB.getBoardRef());
						
		if (replyB.getBoardLevel() == 2)
			replyB.setBoardReplyRef(originB.getBoardNum());
		
		replyB.setBoardReplySeq(1);
		
		// 같은 레벨의 기존 답글의 seq 1 증가 처리함
		bservice.updateReplySeq(replyB);
		
		if(bservice.insertReply(originB, replyB) > 0) {
			response.sendRedirect("/first/blist?page=" + currentPage);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/board/boardError.jsp");
			request.setAttribute("message", "댓글 달기 실패!");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
