<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="boardError.jsp" %>
<%@ page import="board.model.vo.Board, java.util.*, java.sql.Date" %>
<%	
	Board board = (Board)request.getAttribute("board");	
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();	
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardDetailView</title>
</head>
<body>
<%@ include file="../../header.jsp" %>
<h1 align="center">게시글 상세보기</h1>
<table align="center" cellpadding="10" cellspacing="0" border="1" width="500"> 
    <tr align="center" valign="middle">  
          <th colspan="2"><%= board.getBoardNum() %> 번글 상세보기</th> 
    </tr>      
    <tr><td height="15" width="100">제 목</td>          
        <td><%= board.getBoardTitle() %></td> 
    </tr>     
    <tr><td>내 용</td> 
        <td><%= board.getBoardContent() %></td>         
    </tr> 
    <tr><td>첨부파일</td> 
        <td><% if(board.getBoardOriginalFileName() == null){ %>
        	첨부파일 없음 
        	<% }else{ %>
        	<a href="/second/bfdown?ofile=<%= board.getBoardOriginalFileName() %>&rfile=<%= board.getBoardRenameFileName() %>"><%= board.getBoardOriginalFileName() %></a>         
        	<% } %> 
        </td> 
    </tr>
    <tr align="center" valign="middle"> 
        <td colspan="2"> 
         <c:if test="${ !empty sessionScope.member }">
            <a href="/second/views/board/boardReplyForm.jsp?bnum=<%= board.getBoardNum() %>&page=<%= currentPage %>"> [댓글달기] </a> &nbsp;&nbsp; 
         <c:if test="${ member.id == board.boardWriter }">
         
            <a href="/second/bupview?bnum=<%= board.getBoardNum() %>&page=<%= currentPage %>"> [수정페이지로 이동] </a> &nbsp;&nbsp; 
            <a href="/second/bdelete?bnum=<%= board.getBoardNum() %>"> [글삭제] </a> &nbsp;&nbsp; 
         </c:if>
         </c:if>
            <a href="/second/blist?page=<%= currentPage %>">[목록]</a>            
        </td> 
    </tr> 
</table>
<br>
<%@ include file="../../footer.html" %>
</body>
</html>