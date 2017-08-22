<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeWriteForm</title>
</head>
<body>
	<h1 align="center">공지글 등록 페이지</h1>
	<br>
	<br>
	<form action="/testm/ninsert" method="post"
		enctype="multipart/form-data">
		<table align="center" width="600" bgcolor="yellow">
			<tr>
				<td>제목</td>
				<td><input type="text" size="50" name="title"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" readonly
					value="${ member.id }"></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="7" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="등록하기"> &nbsp; <input type="reset" value="등록취소">
				</td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<p align="center">


		<a href="/testm/index.jsp">시작페이지로 이동</a> &nbsp; <a href="/testm/nlist">목록보기로
			이동</a>
	</p>
</body>
</html>