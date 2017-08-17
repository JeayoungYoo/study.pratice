<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice" %>    
<%
	Notice n = (Notice)request.getAttribute("notice");	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeUpdateView</title>
<script type="text/javascript">
	function showFile(){
		
	}
</script>
</head>
<body>
<h1 align="center"><%= n.getNoticeNo() %>번글 수정 페이지</h1>
<br><br>
<form action="/second/nupdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="no" value="<%= n.getNoticeNo() %>">
<table align="center" width="600" bgcolor="yellow">	
	<tr><td>제목</td>
	   <td><input type="text" size="50" name="title" value="<%= n.getNoticeTitle() %>"></td></tr>
	<tr><td>작성자</td>
	   <td><input type="text" name="writer" readonly value="<%= n.getNoticeWriter() %>"></td></tr>
	<tr><td>첨부파일</td>
		<td><% if(n.getFilePath() == null){ %>			
		<input type="file" name="file">
		<% }else{ %>
		<%= n.getFilePath() %> <button onclick="showFile();">변경하기</button><br>
		<div id="addFile">
		<input type="file" name="file">
		</div>
		<% } %>
		</td></tr>	
	<tr><td>내용</td>
	   <td><textarea rows="7" cols="50" name="content">
	   	<%= n.getNoticeContent() %>
	   </textarea></td></tr>
	<tr><td colspan="2" align="center"> 
		<input type="submit" value="수정하기">		
	</td></tr>	
</table>
</form>
<br><br>
<p align="center">
<a href="/second/index.jsp">시작페이지로 이동</a> &nbsp;
<a href="/second/nlist">목록보기로 이동</a>
<a href="javascript:history.go(-1);">이전 페이지로 이동</a>
</p>
</body>
</html>