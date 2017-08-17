<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="boardError.jsp" %>
<%@ page import="board.model.vo.Board, java.util.ArrayList, java.sql.Date" %>    
<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardListView</title>
<script type="text/javascript">
	function showInsertForm(){
		location.href = "views/board/boardInsertForm.jsp";
	}
</script>
</head>
<body>
<%@ include file="../../header.jsp" %>
<h1 align="center">게시글 목록</h1>
<h3 align="center">총 게시글 갯수 : <%= listCount %>
<c:if test="${ !empty sessionScope.member }">
&nbsp; &nbsp; &nbsp; <button onclick="showInsertForm();">글쓰기</button>
</c:if></h3>
<table align="center" border="1" cellspacing="0" width="700">
<tr><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th>
<th>조회수</th><th>첨부파일</th></tr>
<%
	for(Board b : list){
%>
<tr><td align="center"><%= b.getBoardNum() %></td>
<%-- 답글일 때는 들여쓰기함 --%>
<td>
	<% if(b.getBoardLevel() == 1){  //원글의 답글일 때 %>
	 &nbsp; &nbsp; ▶ 
	<% }else if(b.getBoardLevel() == 2){ //답글의 답글일 때 %>
	 &nbsp; &nbsp; &nbsp; &nbsp; ▶▶ 
	<% } %>
	<%-- 로그인한 사용자만 상세보기할 수 있게 처리함 --%>
	<c:if test="${ !empty sessionScope.member }">
		<a href="/second/bdetail?bnum=<%= b.getBoardNum() %>&page=<%= currentPage %>"><%= b.getBoardTitle() %></a>
	</c:if>
	<c:if test="${ empty sessionScope.member }">
		<%= b.getBoardTitle() %>
	</c:if>
</td>
<td align="center"><%= b.getBoardWriter() %></td>
<td align="center"><%= b.getBoardDate() %></td>
<td align="center"><%= b.getBoardReadCount() %></td>
<td align="center">
	<% if(b.getBoardOriginalFileName() != null){  //원글의 답글일 때 %>
		 ◎
	<% }else{ %>
		&nbsp;
	<% } %>	 
</td></tr>
<%  } //for close  %>
<%-- 페이지 번호 처리 --%>
<tr align="center" height="20">
<td colspan="6">
	<%  if(currentPage <= 1){	%>
		[이전] &nbsp;
	<%  }else{ %>
		<a href="/second/blist?page=<%= currentPage - 1 %>">[이전]</a> &nbsp;
	<%  } %>
	<%-- 페이지 숫자 보여주기 --%>
	<%  for(int p = startPage; p <= endPage; p++){ 
			if(p == currentPage){
	%><font color="red" size="4"><b>[<%= p %>]</b></font>
	<%     }else{ %>
		<a href="/second/blist?page=<%= p %>"><%= p %></a>
	<%  }} //else and for close %>
	<% if(currentPage >= maxPage){ %>
		[다음]
	<% }else{ %>
		<a href="/second/blist?page=<%= currentPage + 1 %>">[다음]</a>
	<% } %>
</td>
</tr>
</table>
<br>
<h4 align="center"><a href="/second/index.jsp">시작페이지로 이동</a></h4>
<br>
<%@ include file="../../footer.html" %>
</body>
</html>





