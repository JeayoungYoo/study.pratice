<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="boardError.jsp"%>
<%@ page import="board.model.vo.Board, member.model.vo.Member"%>

<%
	Board board = (Board) request.getAttribute("board");
	String fileName = null;
	int currentPage = ((Integer) request.getAttribute("currentPage")).intValue();

	Member member = (Member) session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardDetailView</title>
</head>
<body>

	<h1 align="center"><%=board.getBoardNum()%>
		번글 상세 보기
	</h1>
	<br>
	<br>

	<table align="center" border="1">
		<tr>
			<td>번호</td>
			<td><%=board.getBoardNum()%></td>
		</tr>

		<tr>
			<td>제목</td>
			<td><%=board.getBoardTitle()%></td>
		</tr>

		<tr>
			<td>작성자</td>
			<td><%=board.getBoardWriter()%></td>
		</tr>

		<tr>
			<td>올린날짜</td>
			<td><%=board.getBoardDate()%></td>
		</tr>

		<%
			if (board.getBoardOriginalFileName() != null) {
				fileName = board.getBoardOriginalFileName()
						.substring(board.getBoardOriginalFileName().lastIndexOf("/") + 1);
		%>
		<tr>
			<td>첨부파일</td>
			<td><a
				href="/first/bfdown?rfile=<%=board.getBoardRenameFileName()%>&ofile=<%=board.getBoardOriginalFileName()%>"><%=fileName%></a></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td>내용</td>
			<td><%=board.getBoardContent()%>
		</tr>
		<tr>
			<td colspan="2"><a
				href="/first/views/board/boardReplyForm.jsp?bnum=<%=board.getBoardNum()%>&page=<%=currentPage%>">[댓글]</a>
				&nbsp; &nbsp; <%
			if (member.getId().equals(board.getBoardWriter()) == true) {
		%> <%
				
					if (member != null) { %> <%}
 %> <a href="/first/bupview?bnum=<%=board.getBoardNum()%>">[수정]</a> &nbsp;
				&nbsp; <a href="/first/bdelete?bnum=<%=board.getBoardNum()%>">[삭제]</a>
				&nbsp; &nbsp; <a href="/first/blist?page=<%=currentPage%>">[목록]</a>
			</td>
		</tr>
		<%
			}
		%>



	</table>
	<br>
	<br>
	<p align="center">
		<a href="/first/index.jsp">시작페이지로 이동</a> &nbsp; &nbsp; <a
			href="/first/blist">목록보기로 이동</a>
	</p>
</body>
</html>