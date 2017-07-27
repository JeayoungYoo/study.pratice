package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;



/**
 * Servlet implementation class MemberIdCheckServlet
 */
@WebServlet("/dupid")
public class MemberIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디 중복 체크 처리용 컨트롤러
		System.out.println("아이디 중복 체크 서블릿 연결됨.");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain; utf-8");
		
		String userId = request.getParameter("userid");
		
		Member m = new MemberService().selectMember(userId);
		
		if (m != null) {
			response.getWriter().append("1");
		} else {
			response.getWriter().append("2");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
