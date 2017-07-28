package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.model.service.BoardService;
import board.model.vo.Board;


/**
 * Servlet implementation class BoardTop5ListServlet
 */
@WebServlet("/btlist")
public class BoardTop5ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardTop5ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Board> list = new BoardService().selectList();
				
		JSONObject json = new JSONObject();
		JSONArray jarr = new JSONArray();
		
		for(Board b : list){
			JSONObject job = new JSONObject();
			job.put("boardNum", b.getBoardNum());
			job.put("boardTitle", URLEncoder.encode(b.getBoardTitle(), "UTF-8").replace('+', ' '));
			/*job.put("userPwd", user.getUserPwd());
			//json에서 한글 깨짐을 막으려면, java.net.URLEncoder 클래스의 encode() 메소드로 인코딩 처리
			job.put("userName", URLEncoder.encode(user.getUserName() , "UTF-8"));
			job.put("age", user.getAge());
			job.put("email", user.getEmail());
			job.put("phone", user.getPhone());*/	
			jarr.add(job);
		}
		json.put("list", jarr);
		
		System.out.println(json.toJSONString());
		
		response.setContentType("application/json"); 
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
