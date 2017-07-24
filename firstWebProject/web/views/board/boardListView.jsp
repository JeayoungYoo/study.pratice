<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="boardError.jsp"%>
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
<title>BoardListView</title>
</head>
<body>
<h1 align="center">게시글 목록</h1>
<br>
<h3 align="center">
총 게시글 갯수 : <%= listCount %>
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
<%= b.getBoardTitle() %>
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

<% } %>
</table>

</h3>
</body>
</html>