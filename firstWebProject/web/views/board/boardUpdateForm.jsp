<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board"%>
<%
	Board b = (Board) request.getAttribute("board");
	int currentPage = ((Integer)request.getAttribute("page")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdateForm</title>
<script type="text/javascript">
	function showFile(){
		
	}
</script>
</head>
<body>
	<%@ include file="../../header.jsp"%>
	<h1 align="center"><%=b.getBoardNum()%>번글 수정 페이지
	</h1>
	<form action="/first/bupdate" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="bnum" value="<%=b.getBoardNum()%>">
		<input type="hidden" name="page" value="<%=currentPage%>">
		<table align="center" width="600" bgcolor="yellow">
			<tr>
				<td>제목</td>
				<td><input type="text" size="50" name="btitle"
					value="<%=b.getBoardTitle()%>"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bwriter" readonly
					value="<%=member.getId()%>"></td>
			</tr>
			
			<% if (b.getBoardLevel() == 0) { %>
			<tr>
				<td>첨부파일</td>
				<td>
					<%
						if (b.getBoardOriginalFileName() == null) {
					%> <input type="file"
					name="bfile"> <%
 	} else {
 %> <%=b.getBoardOriginalFileName()%>
					
					<div id="addFile">
						<input type="file" name="bfile">
					</div> <%
 	}
 %>
				</td>
			</tr>
			<% } %>
			<tr>
				<td>내용</td>
				<td><textarea rows="7" cols="50" name="bcontent"><%=b.getBoardContent()%></textarea></td>
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