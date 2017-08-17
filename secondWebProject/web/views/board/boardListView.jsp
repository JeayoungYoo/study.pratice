<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="boardError.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	int listCount = ((Integer)request.getAttribute("listCount")).intValue();
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int startPage = ((Integer)request.getAttribute("startPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardListView</title>
<script type="text/javascript">
	function showInsertForm() {
		location.href = "views/board/boardInsertForm.jsp";
	}
</script>
</head>
<body>
	<c:import url="/header.jsp" />
	<h1 align="center">게시글 목록</h1>
	<h3 align="center">
		총 게시글 갯수 : ${ listCount }
		<c:if test="${ !empty sessionScope.member }">
&nbsp; &nbsp; &nbsp; <button onclick="showInsertForm();">글쓰기</button>
		</c:if>
	</h3>
	<table align="center" border="1" cellspacing="0" width="700">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>첨부파일</th>
		</tr>
		<c:forEach var="b" items="${ list }">
			<tr>
				<td align="center">${ b.boardNum }</td>
				<td><c:if test="${ b.boardLevel eq 1 }">
	&nbsp; &nbsp; ▶ 
	</c:if> <c:if test="${ b.boardLevel eq 2 }">
	&nbsp; &nbsp; &nbsp; &nbsp; ▶▶
	</c:if> <c:if test="${ !empty sessionScope.member }">
						<c:url var="bdetail" value="/bdetail">
							<c:param name="bnum" value="${ b.boardNum }" />
							<c:param name="page" value="${ currentPage }" />
						</c:url>
						<a href="${ bdetail }">${ b.boardTitle }</a>
					</c:if> <c:if test="${ empty sessionScope.member }">
		${ b.boardTitle }
	</c:if></td>
				<td align="center">${ b.boardWriter }</td>
				<td align="center">${ b.boardDate }</td>
				<td align="center">${ b.boardReadCount }</td>
				<td align="center"><c:if
						test="${ !empty b.boardOriginalFileName }">
		 ◎
	</c:if> <c:if test="${ empty b.boardOriginalFileName }">
		&nbsp;
	</c:if></td>
			</tr>
		</c:forEach>
		<%-- 페이지 번호 처리 --%>
		<tr align="center" height="20">
			<td colspan="6"><c:if test="${ currentPage <= 1 }">
		[이전] &nbsp;
	</c:if> <c:if test="${ currentPage > 1 }">
					<c:url var="blist" value="/blist">
						<c:param name="page" value="${ currentPage-1 }" />
					</c:url>
					<a href="${ blist }">[이전]</a> &nbsp;
	</c:if> <%-- 페이지 숫자 보여주기 --%> <c:forEach var="p" begin="${ startPage }"
					end="${ endPage }">
					<c:if test="${ p == currentPage }">
						<font color="red" size="4"><b>[${ p }] </b></font>
					</c:if>
					<c:if test="${ p != currentPage }">
						<c:url var="blist" value="/blist">
							<c:param name="page" value="${ p }" />
						</c:url>
						<a href="${ blist }">${ p }</a>
					</c:if>
				</c:forEach> <c:if test="${ currentPage >= maxPage }">[다음]</c:if> <c:if
					test="${ currentPage < maxPage }">
					<c:url var="blist" value="/blist">
						<c:param name="page" value="${ currentPage+1 }" />
					</c:url>
					<a href="${ blist }">[다음]</a>
				</c:if></td>
		</tr>
	</table>
	<br>
	<h4 align="center">
		<c:url var="index" value="/index.jsp"></c:url>
		<a href="${index}">시작페이지로 이동</a>
	</h4>
	<br>
	<c:import url="/footer.html" />
</body>
</html>





