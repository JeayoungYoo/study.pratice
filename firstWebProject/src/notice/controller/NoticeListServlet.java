package notice.controller;

import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/nlist")
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공지글 전체 조회 서비스 처리용 컨트롤러
		response.setContentType("text/html; charset=utf-8");
		
		ArrayList<Notice> list = new NoticeService().selectList();
//		System.out.println(list);
		if (list != null && list.size() > 0) {
			// 절대경로 사용 못 함
			RequestDispatcher view = request.getRequestDispatcher("views/notice/noticeListView.jsp");
			request.setAttribute("list", list);
			view.forward(request, response);
		} else {
			response.sendRedirect("/views/notice/noticeError.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
