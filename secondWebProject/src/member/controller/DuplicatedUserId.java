package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class DuplicatedUserId
 */
@WebServlet("/dupid")
public class DuplicatedUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DuplicatedUserId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 아이디 중복 체크 처리용 컨트롤러
		//System.out.println("아이디 중복 체크 서블릿 연결됨.");
		
		String userId = request.getParameter("userid");
		//System.out.println("userId : " + userId);
		
		int result = new MemberService().checkUserId(userId);
		
		PrintWriter clientOut = response.getWriter();
		if(result == 0){
			clientOut.append("ok");
			clientOut.flush();
		}
		else{
			clientOut.append("fail");
			clientOut.flush();
		}
		
		clientOut.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
