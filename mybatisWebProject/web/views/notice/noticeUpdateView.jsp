<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	Notice n = (Notice)request.getAttribute("notice");	
%>     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeUpdateView</title>
<script type="text/javascript">
	function showFile() {

	}
	
</script>
</head>
<body>
	<h1 align="center">${ notice.noticeNo }번글수정 페이지</h1>
	<br>
	<br>
	<form action="/testm/nupdate" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="no" value="${ notice.noticeNo }">
		<table align="center" width="600" bgcolor="yellow">
			<tr>
				<td>제목</td>
				<td><input type="text" size="50" name="title"
					value="${ notice.noticeTitle }"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" readonly
					value="${ notice.noticeWriter }"></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td><c:if test="${ empty notice.filePath } ">
						<input type="file" name="file">
					</c:if> <c:if test="${ not empty notice.filePath } ">		
		${ notice.filePath } <button onclick="showFile();">변경하기</button>
						<br>
						<div id="addFile">
							<input type="file" name="file">
						</div>
					</c:if></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="7" cols="50" name="content">
	   ${ notice.noticeContent }
	   s</textarea></td>
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
		<a href="/testm/index.jsp">시작페이지로 이동</a> &nbsp; <a href="/testm/nlist">목록보기로
			이동</a> <a href="javascript:history.go(-1);">이전 페이지로 이동</a>
	</p>
</body>
</html>