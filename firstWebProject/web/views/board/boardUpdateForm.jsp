<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board"%>
<%
	Board b = (Board) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdateForm</title>
</head>
<body>
	<h1 align="center"><%=b.getBoardNum()%>번글 수정 페이지
	</h1>
	<br>
	<br>
	<form action="/first/bupdate" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="bnum" value="<%=b.getBoardNum()%>">
		<table align="center" width="600" bgcolor="yellow">
			<tr>
				<td>제목</td>
				<td><input type="text" size="50" name="btitle"
					value="<%=b.getBoardTitle()%>"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bwriter" readonly
					value="<%=b.getBoardWriter()%>"></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<%
						if (b.getBoardOriginalFileName() == null) {
					%> <input type="file"
					name="bfile"> <%
 	} else {
 %> <%=b.getBoardOriginalFileName()%>
					<button onclick="showFile();">변경하기</button>
					<br>
					<div id="addFile">
						<input type="file" name="bfile">
					</div> <%
 	}
 %>
				</td>
			</tr>
			<tr>
				<td>기존첨부파일명</td>
				<td><input type="text" name="originfile" value="<%= b.getBoardOriginalFileName() %>"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="7" cols="50" name="bcontent">
	   	<%=b.getBoardContent()%>
	   </textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="수정하기"></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<p align="center">
		<a href="/first/index.jsp">시작페이지로 이동</a> &nbsp; <a href="/first/blist">목록보기로
			이동</a> <a href="javascript:history.go(-1);">이전 페이지로 이동</a>
	</p>
</body>
</html>