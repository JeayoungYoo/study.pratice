<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board" %>
<%
	Board board = (Board)request.getAttribute("board");
    int currentPage = ((Integer)request.getAttribute("page")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdateView</title>
</head>
<body>
<%@ include file="../../header.jsp" %>
<h1 align="center"><%= board.getBoardNum() %>번 게시글 수정페이지</h1>
<br>
<% if(board.getBoardLevel() == 0){ %>
<form action="/second/boriginup" method="post" enctype="multipart/form-data">
<input type="hidden" name="bnum" value="<%= board.getBoardNum() %>">
<input type="hidden" name="ofile" value="<%= board.getBoardOriginalFileName() %>">
<input type="hidden" name="rfile" value="<%= board.getBoardRenameFileName() %>">
<input type="hidden" name="page" value="<%= currentPage %>">
<table align="center">
	<tr><td>제목</td><td><input type="text" name="btitle" value="<%= board.getBoardTitle() %>"></td></tr>
	<tr><td>작성자</td><td><input type="text" readonly value="<%= board.getBoardWriter() %>"></td></tr>
	<tr><td>첨부파일</td>
		<td>
		<% if(board.getBoardOriginalFileName() != null){ %>
			<%= board.getBoardOriginalFileName() %> <br>
		<% } %>
		<input type="file" name="upfile">
		</td>
	</tr>
	<tr><td>내용</td><td><textarea cols="50" rows="7" name="bcontent"><%= board.getBoardContent() %></textarea></td></tr>	
	<tr><td colspan="2" align="center">
	<input type="submit" value="수정하기"> &nbsp; 
		</td></tr>
</table>
</form>
<% }else{ %>
<form action="/second/breplyup" method="post">
<input type="hidden" name="bnum" value="<%= board.getBoardNum() %>">
<input type="hidden" name="page" value="<%= currentPage %>">
<table align="center">
	<tr><td>제목</td><td><input type="text" name="btitle" value="<%= board.getBoardTitle() %>"></td></tr>
	<tr><td>작성자</td><td><input type="text" readonly value="<%= board.getBoardWriter() %>"></td></tr>
	<tr><td>내용</td><td><textarea cols="50" rows="7" name="bcontent"><%= board.getBoardContent() %></textarea></td></tr>	
	<tr><td colspan="2" align="center">
	<input type="submit" value="수정하기"> &nbsp; 
		</td></tr>
</table>
</form>
<% } %>
<h4 align="center"><a href="/second/blist?page=<%= currentPage %>">목록</a></h4>
<%@ include file="../../footer.html" %>
</body>
</html>