<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardError</title>
</head>
<body>
<h1>게시글 서비스 에러 발생</h1>
<c:if test="${ !empty exception }">
JSP 페이지에서 발생한 에러 메세지 : ${ exception.getMessage() }
</c:if>
<br>
Servlet 에서 전송한 에러 메세지 : <fmt:requestEncoding value="utf-8"/>
${ message }<br>


</body>
</html>