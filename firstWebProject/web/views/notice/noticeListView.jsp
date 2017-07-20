<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,notice.model.vo.Notice, member.model.vo.Member" %>    
    
<%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
	Member member = (Member) session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeListView</title>
</head>
<body>
	<h1 align="center">공지글 전체</h1>
	<br><br>
	<table align="center" width="600" border="1" cellspacing="0">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>올린날짜</th>
			<th>첨부파일</th>
		</tr>
		<% 
			for (Notice n : list) {
		%>
		<tr>
			<td><%= n.getNoticeNo() %></td>
			<td><% if(member != null) { %>
				<a href="/first/ndetail?no=<%= n.getNoticeNo() %>"><%= n.getNoticeTitle() %></a>
			<% } else { %>
				<%= n.getNoticeTitle() %>
			<% } %>
			</td>
			<td><%= n.getNoticeWriter() %></td>
			<td><%= n.getNoticeDate() %></td>
			<td>
			<% if(n.getFilePath() != null) { %>
				◎
			<% } else { %>
				&nbsp;
			<% } %>
			</td>			
		</tr>
		<% } %>
	</table>
	<p align="center">
		<a href="/first/index.jsp">시작페이지로 이동</a>
	</p>
</body>
</html>