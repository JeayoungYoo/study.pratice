<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member"%>
<%
	Member m = (Member) session.getAttribute("member");
	String[] addr = m.getAddress().split(",");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My page</title>
</head>
<body>
	<h1 align="center"><%=m.getName()%>님 정보 보기</h1>
	<br>
	<center>
	<form action="/first/mupdate" method="post">
		<table width="600" cellspacing="5" bgcolor="brown">
			<tr>
				<td width="150">아 이 디</td>
				<td width="450"><input type="text" name="userid" value="<%= m.getId() %>" readonly>
					&nbsp; &nbsp;
					<button>중복체크</button></td>
			</tr>
			<tr>
				<td>이 름</td>
				<td><input type="text" name="name" value="<%= m.getName() %>" readonly></td>
			</tr>

			<tr>
				<td>암 호</td>
				<td><input type="password" name="userpwd" value="<%= m.getPasswd() %>"></td>
			</tr>
			<tr>
				<td>암호확인</td>
				<td><input type="password" name="userpwd2"></td>
			</tr>
			<tr>
				<td>성 별</td>
				<td>
				<% if(m.getGender().equals("M")) { %>
						<input type="radio" name="gender" value="M" checked>남
						<input type="radio" name="gender" value="F"> 여 
					<% } else { %>
						<input type="radio" name="gender" value="M">남
						<input type="radio" name="gender" value="F" checked>여
					<% } %>
				</td>
			</tr>
			<tr>
				<td>나 이</td>
				<td><input type="number" min="20" max="100" value="<%= m.getAge() %>"
					name="age" id="age" readonly></td>
			</tr>
			<tr>
				<td>이 메 일</td>
				<td><input type="email" name="email" value=<%= m.getEmail() %>></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="tel" name="phone" value=<%= m.getPhone() %>></td>
			</tr>
			<tr>
				<td>우편번호</td>
				<td><input type="text" name="post" size="10" value=<%= addr[0] %>></td>
			</tr>
			<tr>
				<td>주 소</td>
				<td><input type="text" name="address1" value=<%= addr[1] %>></td>
			</tr>
			<tr>
				<td>상세주소</td>
				<td><input type="text" name="address2" value=<%= addr[2] %>></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="확인">
					<a href="/first/mdelete?userid=<%= m.getId() %>">탈퇴하기</a></td>
					<!-- 쿼리스트링 : 서블릿이름?이름=값&이름=값 -->
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>

		</table>
	</form>
	<!--  상대경로로 대상 파일을 지정하는 경우 :
		<a href="../../index.jsp">시작페이지로 이동</a>
 	-->
	<!-- 절대경로로 대상 파일을 지정하는 방법 : 
		"/context root명/대상파일의 위치경로와 파일명"
	 -->
	<a href="/first/index.jsp">시작페이지로 이동</a>
	</center>

</body>
</html>