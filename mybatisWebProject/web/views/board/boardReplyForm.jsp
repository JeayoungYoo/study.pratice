<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- <%
	int boardNum = Integer.parseInt(request.getParameter("bnum"));
	int currentPage = Integer.parseInt(request.getParameter("page"));
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardReplyForm</title>
</head>
<body>
	<%@ include file="../../header.jsp"%>
	<h1 align="center">${ bnum }번 글의 댓글달기
	</h1>
	<br>
	<form action="/testm/breply" method="post">
		<input type="hidden" name="page" value="${ currentPage }>"> <input
			type="hidden" name="bnum" value="${ bnum }"> <input
			type="hidden" name="bwriter" value="${ member.id }">
		<table align="center">
			<tr>
				<td>제목</td>
				<td><input type="text" name="btitle"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" readonly value="${ member.id }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="50" rows="7" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="댓글등록"> &nbsp; <a href="javascript:history.go(-1);">이전
						페이지로</a></td>
			</tr>
		</table>
	</form>
	<h4 align="center">
		<a href="/testm/blist?page=${ currentPage }">목록</a>
	</h4>
	<%@ include file="../../footer.html"%>
</body>
</html>




