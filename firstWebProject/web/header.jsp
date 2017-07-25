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
<style type="text/css">
	form.login, table.login { float : right; }
	ul li a {
		display : block;
		width : 120px;
		height : 35px;
		background : orange;
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
		padding-top : 5px;
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
	<%
		if(member == null) {  // 로그인 하지 않았다면
			
		
	%>
	<form action="login" method="post" class="login">
		<table class="login" width="250" cellpadding="0" cellspacing="0" bgcolor="yellow">
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
		<table class="login" width="250" cellpadding="0" cellspacing="0" bgcolor="yellow">
			<tr>
				<td><%= member.getName() %>님</td>
				<td><a href="/first/logout">로그아웃</a></td>
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
	
	<nav>
		<ul>
			<li><a href="/first/nlist">공지사항</a></li>
			<li><a href="/first/blist?page=1">게시판</a></li>
			<li><a>etc</a></li>
			<li><a>etc</a></li>			
		</ul>	
	</nav>
	<hr style="clear:both;">
</body>
</html>