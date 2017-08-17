<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInsertForm</title>
</head>
<body>
<%@ include file="../../header.jsp" %>
<h1 align="center">답변형 게시글 쓰기</h1>
<br>
<form action="/second/binsert" method="post" enctype="multipart/form-data">
<input type="hidden" name="bwriter" value="<%= member.getId() %>">
<table align="center">
	<tr><td>제목</td><td><input type="text" name="btitle"></td></tr>
	<tr><td>작성자</td><td><input type="text" readonly value="<%= member.getId() %>"></td></tr>
	<tr><td>첨부파일</td><td><input type="file" name="upfile"></td></tr>
	<tr><td>내용</td><td><textarea cols="50" rows="7" name="bcontent"></textarea></td></tr>	
	<tr><td colspan="2" align="center"><input type="submit" value="등록하기"> &nbsp; 
		<a href="/second/blist?page=1">목록으로</a></td></tr>
</table>
</form>
<%@ include file="../../footer.html" %>
</body>
</html>