<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="boardError.jsp"%>
<%@ page import="board.model.vo.Board, java.util.ArrayList, java.sql.Date"%>

<%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
	System.out.print(maxPage +", " + endPage);
	System.out.print(currentPage + ", " + startPage);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardListView</title>
<script type="text/javascript">
	function showInsertForm(){
		location.href = "/first/views/board/boardInsertForm.jsp"		
	}
</script>
</head>
<%@ include file="../../header.jsp" %>
<body>
<h1 align="center">게시글 목록</h1>
<br>
<h3 align="center">
총 게시글 갯수 : <%= listCount %>
<% if(member != null) {%>
&nbsp; &nbsp; &nbsp; <button onclick="showInsertForm();">글쓰기</button>
<% } %>
<table align="center" border="1" cellspacing="0" width="700">
<tr><th>글번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th><th>첨부파일</th></tr>
<%
	for (Board b : list) {
%>
<tr><td><%= b.getBoardNum() %></td>
<%-- 답글일 때는 들여쓰기 함 --%>
<td>
<% if (b.getBoardLevel() == 1) { %>
	&nbsp;&nbsp; →
<% } else if (b.getBoardLevel() == 2) { // if close %>
	&nbsp;&nbsp;&nbsp;&nbsp; →
<% } %>
<%-- 로그인한 사용자만 상세보기할 수 있게 처리함 --%>
<% if(member != null) { %>
	<a href="/first/bdetail?bnum=<%= b.getBoardNum() %>&page=<%= currentPage %>"><%= b.getBoardTitle() %></a>
<% } else { %>
	<%= b.getBoardTitle() %>
<% } %>

</td>
<td><%= b.getBoardWriter() %></td>
<td><%= b.getBoardDate() %></td>
<td><%= b.getBoardReadCount() %></td>
<td>
<% if (b.getBoardOriginalFileName() == null) { %>

<% } else { %>
	＠
<% } %> 
</td></tr>

<% } // for close %>
<%-- 페이지 번호 처리 --%>
<tr align="center" height="20">
	<td colspan="6">
		<% if (currentPage <= 1) { %>
			[이전] &nbsp;
		<% } else { %>
			<a href="/first/blist?page=<%= currentPage - 1 %>">[이전]</a> &nbsp;
		<% } %>
		<%-- 페이지 숫자 보여주기 --%>
		<% for (int p = startPage; p <= endPage; p++) {
			if(p == currentPage) { %>
			<font color="red" size="4"><b>[<%= p %>]</b></font>
		<% } else { %>
		<a href="/first/blist?page=<%= p %>"><%= p %></a>
		<% } %>
		<% } %>
		<% if (currentPage >= maxPage ) { %>
			[다음] &nbsp;
		<% } else { %>
			<a href="/first/blist?page=<%= currentPage + 1 %>">[다음]</a>
		<% } %>
	</td>
	
</table>

</h3>
</body>
</html>