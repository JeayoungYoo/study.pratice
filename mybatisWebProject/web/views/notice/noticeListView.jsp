<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>noticeListView</title>
<script type="text/javascript">
	function show() {
		location.href = "/testm/views/notice/noticeWriteForm.jsp";
	}
</script>

</head>
<body>
	<c:import url="../../header.jsp" />

	<br style="clear: both;">
	<h1 align="center">공지글 목록 보기</h1>
	<br>
	<br>
	<div align="center"
		style="background: #99ccff; height: 50px; padding-top: 15px; clear: both;">
		<form action="nsearch" method="post">
			검색할 제목을 입력하세요 : <input type="search" name="keyword" size="50">
			&nbsp; <input type="submit" value="제목 검색">
		</form>
	</div>
	<br>
	<c:if test="${ !empty member }">

		<div align="center">
			<button onclick="show();">글쓰기</button>
		</div>
	</c:if>
	<br style="clear: both;">
	<table align="center" width="600" border="1" cellspacing="0"
		style="clear: right;">
		<tr bgcolor="#99ccff">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>올린날짜</th>
			<th>첨부파일</th>
		</tr>
		<c:forEach var="n" items="${ list }">
			<tr>
				<td align="center">${ n.noticeNo }</td>
				<td><c:if test="${ !empty member }">
						<c:url var="ndetail" value="ndetail">
							<c:param name="no" value="${ n.noticeNo }" />
						</c:url>
						<a href="ndetail">${ n.noticeTitle }</a>
					</c:if> <c:if test="${ empty member }">
					${ n.noticeTitle }</td>
				</c:if>
				<td align="center">${ n.noticeWriter }</td>
				<td align="center">${ n.noticeDate }</td>
				<td align="center"><c:if test="${ !empty n.filePath }">◎</c:if>
					<c:if test="${ empty n.filePath }">&nbsp;</c:if></td>
			</tr>
		</c:forEach>
	</table>
	<p align="center">
		<c:url var="index" value="/index.jsp" />
		<c:url var="nlist" value="/nlist" />
		<a href="${ index }">시작페이지로 이동</a> &nbsp; <a href="${ nlist }">목록
			전체 보기</a>
	</p>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<c:import url="../../footer.html" />

</body>
</html>