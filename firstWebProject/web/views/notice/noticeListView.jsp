<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*,notice.model.vo.Notice, member.model.vo.Member"%>

<%
	ArrayList<Notice> list = (ArrayList<Notice>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeListView</title>
<script type="text/javascript">
	function show(){
		location.href = "/first/views/notice/noticeWriteForm.jsp";
	}
</script>
</head>

<body>
	<%@ include file="../../header.jsp"%>
	<h1 align="center">공지글 전체</h1>

	<div align="center"
		style="background: #99ccff; height: 50px; padding-top: 15px; clear: both;">
		<form action="nsearch" method="post">
			검색할 제목을 입력하세요 : <input type="search" name="keyword" size="50">
			&nbsp; <input type="submit" value="제목 검색">
		</form>
	</div>
	<br>
	<% if(member != null){ %>
	<div align="center">
		<button onclick="show();">글쓰기</button>
	</div>
	<% } %>
	<br style="clear: both;">

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
			<td><%=n.getNoticeNo()%></td>
			<td>
				<% if (member != null) { %>
				<a href="/first/ndetail?no=<%=n.getNoticeNo()%>"><%=n.getNoticeTitle()%></a>
				<% } else { %>
				<%=n.getNoticeTitle()%>
				<% } %>
			</td>
			<td><%=n.getNoticeWriter()%></td>
			<td><%=n.getNoticeDate()%></td>
			<td>
				<%
						if (n.getFilePath() != null) {
					%> ◎ <%
						} else {
					%> &nbsp; <%
 	}
 %>
			</td>
		</tr>
		<%
				}
			%>
	</table>
	<p align="center">
		<a href="/first/index.jsp">시작페이지로 이동</a>
	</p>
	<br>
	<%@ include file="../../footer.html"%>
</body>
</html>