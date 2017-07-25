<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInsertForm</title>
</head>
<body>
	<%@ include file="../../header.jsp"%>
	<h1>게시글 쓰기</h1>


	<form action="/first/binsert" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="bwriter" value="<%= member.getId() %>">
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
				<td>첨부파일</td>
				<td><input type="file" name="bfile"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="7" cols="50" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="등록하기"> &nbsp; <input type="reset" value="등록취소">
				</td>
			</tr>
		</table>
	</form>
	<%@ include file="../../footer.html"%>
</body>
</html>