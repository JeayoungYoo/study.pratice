<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%-- jsp comment element --%>
<!--  html commecnt tag -->
<%
	Member member = (Member) session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
</head>
<body>
	<header>
		<h1>firstWebProject</h1>

	</header>
	<hr>
	<%
		if(member == null) {  // 로그인 하지 않았다면
			
		
	%>
	<form action="login" method="post">
		<table width="250" cellpadding="0" cellspacing="0" bgcolor="yellow">
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>암호 :</td>
				<td><input type="password" name="userpwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="로그인">
					&nbsp; &nbsp; <a href="views/member/enroll.html">회원가입</a></td>
			</tr>
			<tr>
				<td colspan="2" align="center">아이디/암호가 기억나지 않는다면</td>
			</tr>
		</table>
	</form>
	<% } else { %>
		<table width="250" cellpadding="0" cellspacing="0" bgcolor="yellow">
			<tr>
				<td><%= member.getName() %>님</td>
				<td><a href="logout">로그아웃</a></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<a href="/first/views/member/myinfo.jsp">내 정보보기</a>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"></td>
			</tr>
		</table>
	<% } %>
</body>
</html>