/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.44
 * Generated at: 2017-07-27 07:38:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import board.model.vo.Board;
import member.model.vo.Member;

public final class boardUpdateForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/board/../../footer.html", Long.valueOf(1500886253056L));
    _jspx_dependants.put("/views/board/../../header.jsp", Long.valueOf(1500977310956L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("board.model.vo.Board");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	Board b = (Board) request.getAttribute("board");
	int currentPage = ((Integer)request.getAttribute("page")).intValue();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>boardUpdateForm</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction showFile(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!--  html commecnt tag -->\r\n");

	Member member = (Member) session.getAttribute("member");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>first</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\tform.login, table.login { float : right; }\r\n");
      out.write("\tul li a {\r\n");
      out.write("\t\tdisplay : block;\r\n");
      out.write("\t\twidth : 120px;\r\n");
      out.write("\t\theight : 35px;\r\n");
      out.write("\t\tbackground : orange;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tul li a:hover {\r\n");
      out.write("\t\tbackground : olive;\t\t\r\n");
      out.write("\t\tcolor : white;\r\n");
      out.write("\t\ttext-shadow : 2px 2px 5px black;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tul li {\r\n");
      out.write("\t\tlist-style : none;\r\n");
      out.write("\t\tfloat : left;\r\n");
      out.write("\t\tmargin-right : 5px;\r\n");
      out.write("\t\tpadding-top : 5px;\r\n");
      out.write("\t\ttext-align : center;\r\n");
      out.write("\t\tfont-size : 16pt;\r\n");
      out.write("\t\tfont-weight : bold;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t<h1>firstWebProject</h1>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<hr>\r\n");
      out.write("\t");

		if(member == null) {  // 로그인 하지 않았다면
			
		
	
      out.write("\r\n");
      out.write("\t<form action=\"login\" method=\"post\" class=\"login\">\r\n");
      out.write("\t\t<table class=\"login\" width=\"250\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"yellow\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>아이디 :</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"userid\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>암호 :</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\" name=\"userpwd\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"로그인\">\r\n");
      out.write("\t\t\t\t\t&nbsp; &nbsp; <a href=\"views/member/enroll.html\">회원가입</a></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" align=\"center\">아이디/암호가 기억나지 않는다면</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t<table class=\"login\" width=\"250\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"yellow\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>");
      out.print( member.getName() );
      out.write("님</td>\r\n");
      out.write("\t\t\t\t<td><a href=\"/first/logout\">로그아웃</a></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" align=\"center\">\r\n");
      out.write("\t\t\t\t<a href=\"/first/views/member/myinfo.jsp\">내 정보보기</a>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" align=\"center\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<nav>\r\n");
      out.write("\t\t<ul>\r\n");
      out.write("\t\t\t<li><a href=\"/first/nlist\">공지사항</a></li>\r\n");
      out.write("\t\t\t<li><a href=\"/first/blist?page=1\">게시판</a></li>\r\n");
      out.write("\t\t\t<li><a>etc</a></li>\r\n");
      out.write("\t\t\t<li><a>etc</a></li>\t\t\t\r\n");
      out.write("\t\t</ul>\t\r\n");
      out.write("\t</nav>\r\n");
      out.write("\t<hr style=\"clear:both;\">\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\t<h1 align=\"center\">");
      out.print(b.getBoardNum());
      out.write("번글 수정 페이지\r\n");
      out.write("\t</h1>\r\n");
      out.write("\t<form action=\"/first/bupdate\" method=\"post\"\r\n");
      out.write("\t\tenctype=\"multipart/form-data\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"bnum\" value=\"");
      out.print(b.getBoardNum());
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"page\" value=\"");
      out.print(currentPage);
      out.write("\">\r\n");
      out.write("\t\t<table align=\"center\" width=\"600\" bgcolor=\"yellow\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>제목</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" size=\"50\" name=\"btitle\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(b.getBoardTitle());
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>작성자</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"bwriter\" readonly\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(member.getId());
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>첨부파일</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");

						if (b.getBoardOriginalFileName() == null) {
					
      out.write(" <input type=\"file\"\r\n");
      out.write("\t\t\t\t\tname=\"bfile\"> ");

 	} else {
 
      out.write(' ');
      out.print(b.getBoardOriginalFileName());
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div id=\"addFile\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"file\" name=\"bfile\">\r\n");
      out.write("\t\t\t\t\t</div> ");

 	}
 
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>내용</td>\r\n");
      out.write("\t\t\t\t<td><textarea rows=\"7\" cols=\"50\" name=\"bcontent\">");
      out.print(b.getBoardContent());
      out.write("</textarea></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" align=\"center\"><input type=\"submit\"\r\n");
      out.write("\t\t\t\t\tvalue=\"등록하기\"> &nbsp; <input type=\"reset\" value=\"등록취소\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<hr style=\"border:dashed 3px blue;\">\r\n");
      out.write("\t<div style=\"text-align:center;color:gray;\">\r\n");
      out.write("\t\tcopyright@kh.org 2017. 7. 24<br>\r\n");
      out.write("\t\tweb service test first project\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
