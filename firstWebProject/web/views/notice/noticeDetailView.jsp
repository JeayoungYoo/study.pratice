<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.Notice, member.model.vo.Member"%>

<%
	Notice notice = (Notice) request.getAttribute("notice");
	String fileName = null;
	
	Member member = (Member) session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeDetailView</title>
</head>
<body>

	<h1 align="center"><%= notice.getNoticeNo() %>
		번글 상세 보기
	</h1>
	<br>
	<br>

	<table align="center">
		<tr>
			<td>번호</td>
			<td><%= notice.getNoticeNo() %></td>
		</tr>

		<tr>
			<td>제목</td>
			<td><%= notice.getNoticeTitle() %></td>
		</tr>

		<tr>
			<td>작성자</td>
			<td><%= notice.getNoticeWriter() %></td>
		</tr>

		<tr>
			<td>올린날짜</td>
			<td><%= notice.getNoticeDate() %></td>
		</tr>

		<% if(notice.getFilePath() != null) { 
			fileName = notice.getFilePath().substring(notice.getFilePath().lastIndexOf("/") + 1);
		%>
		<tr>
			<td>첨부파일</td>
			<td><a href="/first/nfdown?path=<%= notice.getFilePath() %>"><%= fileName %></a></td>
		</tr>
		<% } %>
		<tr>
			<td>내용</td>
			<td><%= notice.getNoticeContent() %>
		</tr>
		<% if (member.getId().equals(notice.getNoticeWriter()) == true) { %>
		<tr>
			<td colspan="2">
			<a href="/first/nupView?no=<%= notice.getNoticeNo() %>">수정페이지로 이동</a> &nbsp; &nbsp;
			<a href="/first/ndelete?no=<%= notice.getNoticeNo() %>">삭제하기</a>
			</td>
		</tr>
		<% } %>



	</table>
	<br>
	<br>
	<p align="center">
	<a href="/first/index.jsp">시작페이지로 이동</a> &nbsp; &nbsp;
	<a href="/first/nlist">목록보기로 이동</a>
	</p>
	
</body>
</html>