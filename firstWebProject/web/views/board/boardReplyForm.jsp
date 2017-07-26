<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int boardNum = Integer.parseInt(request.getParameter("bnum"));
	int currentPage = Integer.parseInt(request.getParameter("page"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardReplyForm</title>
</head>
<body>
	<%@ include file="../../header.jsp"%>
	<h1 align="center"><%=boardNum%>번 글의 답글달기
	</h1>
	<form action="/first/breply" method="post">
		<input type="hidden" name="page" value="<%= currentPage %>">
		<input type="hidden" name="bnum" value="<%= boardNum %>">
		<input type="hidden" name="bwriter" value="<%=member.getId()%>">
		<table align="center" width="600" bgcolor="yellow">
			<tr>
				<td>제목</td>
				<td><input type="text" size="50" name="btitle"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bwriter" readonly
					value="<%=member.getId()%>"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="7" cols="50" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="답글등록"> &nbsp; <a href="javascript:history.go(-1);">취소</a>
				</td>
			</tr>
			</table>

	</form>
	<h4 align="center">
		&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
		<a href="/first/blist?page=<%=currentPage%>">목록으로 가기</a>
	</h4>
	<%@ include file="../../footer.html"%>
</body>
</html>