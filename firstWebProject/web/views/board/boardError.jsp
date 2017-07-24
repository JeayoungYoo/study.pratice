<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardError</title>
</head>
<body>
	<h1 align="center">게시글 상세보기</h1>
	<% if(exception != null) { %>
	JSP 페이지에서 발생한 에러 메세지 : <%= exception.getMessage() %>
	<% } %>
	<br>
	Servlet 에서 전송한 여러 메세지 : <%= (String) request.getAttribute("message") %>
	
</body>
</html>