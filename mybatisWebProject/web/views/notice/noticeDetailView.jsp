<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeDetailView</title>
</head>
<body>
	<h1 align="center">${notice.noticeNo }번글 상세 보기</h1>
	<br>
	<br>
	<table align="center">
		<tr>
			<td>번호</td>
			<td>${notice.noticeNo }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${notice.noticeTitle }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${notice.noticeWriter }</td>
		</tr>
		<tr>
			<td>올린날짜</td>
			<td>${notice.noticeDate }</td>
		</tr>
		<c:if test="${!empty notice.filePath }">
			<tr>
				<td>첨부파일</td>
				<td><c:url var="nf" value="/nfdown">
						<c:param name="path" value="${notice.filePath }" />
					</c:url> <a href="${nf }"> ${notice.filePath }</a></td>
			</tr>
		</c:if>
		<tr>
			<td>내용</td>
			<td>${notice.noticeContent }</td>
		</tr>
		<c:if test="${member.id eq notice.noticeWriter }">
			<tr>
				<td colspan="2" align="center"><c:url var="nupv"
						value="/nupview">
						<c:param name="no" value="${notice.noticeNo }" />
					</c:url> <a href="${nupv }">수정페이지로 이동</a> &nbsp; &nbsp; <c:url var="ndel"
						value="/ndelete">
						<c:param name="no" value="${notice.noticeNo }" />
					</c:url> <a href="${ndel }">삭제하기</a></td>
			</tr>
		</c:if>

	</table>
	<br>
	<br>
	<p align="center">
		<c:url var="idx" value="/index.jsp" />
		<a href="${idx }">시작페이지로 이동</a> &nbsp;
		<c:url var="nl" value="/nlist" />
		<a href="${nl }">목록 전체 보기</a>
	</p>
</body>
</html>