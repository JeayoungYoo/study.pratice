<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First</title>
<style type="text/css">
	.login { float : right; }
	ul li a {
		display : block;
		width : 120px;
		height : 35px;
		background : orange;
		padding-top : 5px;
	}
	
	ul li a:hover {
		background : olive;
		color : white;
		text-shadow : 2px 2px 5px black;
	}
	
	ul li {
		list-style : none;
		float : left;
		margin-right : 5px;
		padding-top : 10px;
		text-align : center;
		font-size : 16pt;
		font-weight : bold;
	}
</style>
</head>
<body>
<header>
<h1>firstWebProject</h1>

</header>
<hr>
<c:if test="${ empty sessionScope.member }">
<form action="login" method="post" class="login">
<table class="login" width="250" cellpadding="0" cellspacing="0" bgcolor="yellow">
	<tr><td>아이디 : </td><td><input type="text" name="userid"></td></tr>
	<tr><td>암 호 : </td><td><input type="password" name="userpwd"></td></tr>
	<tr><td colspan="2" align="center">
	<input type="submit" value="로그인"> &nbsp; &nbsp;
	<c:url var="enroll" value="views/member/enroll.html"/>
	<a href="${ enroll }">회원가입</a>
	</td></tr>
	<tr><td colspan="2" align="center">아이디/암호가 기억나지 않는다면</td></tr>
</table>
</form>
</c:if>

	<c:if test="${ !empty sessionScope.member }">
		<table class="login" width="250" cellpadding="0" cellspacing="0" bgcolor="yellow">
	<tr><td><%-- <%= member.getName() %> --%> ${ member.name } 님 </td>
	<c:url var="logout" value="/logout"/>
	<td><a href="${ logout }">로그아웃</a></td></tr>
	<tr><td></td><td></td></tr>
	<tr><td colspan="2" align="center">
	<c:url var="myinfo" value="views/member/myinfo.jsp"></c:url>
	<a href="${ myinfo }">내 정보보기</a>	
	</td></tr>
	<tr><td colspan="2" align="center"></td></tr>
</table>
</c:if>

<nav>
	<c:url var="notice" value="/nlist"/>
	<c:url var="board" value="/blist"/>
	<ul>
		<li><a href="${notice}">공지사항</a></li>
		<li><a href="${board}">게시판</a></li>
		<li><a>etc</a></li>
		<li><a>etc</a></li>
	</ul>
</nav>
<hr style="clear:both;">
</body>
</html>