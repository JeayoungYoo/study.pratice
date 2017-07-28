<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="board.model.vo.Board, java.util.ArrayList, java.sql.Date"%>

<%
	ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" src="views/js/jquery-3.2.1.min.js"></script>

</head>
<body>
	<%@ include file="header.jsp"%>
	<table align="center" border="1" cellspacing="0" width="700" id="gg">
		<tr>
			<th>글번호</th>
			<th>제목</th>
		</tr>



	</table>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@ include file="footer.html"%>
	<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "btlist",
			data : {
				no : "t5"
			},
			type : "post",
			dataType : "json",
			success : function(data) {
				//console.log(data);
				var jsonStr = JSON.stringify(data); //객체를 문자열로 변환
				//console.log(jsonStr);
				var json = JSON.parse(jsonStr); //문자열을 배열 객체로 바꿈

				value = $("#gg").html();

				for ( var i in json.list) {
					//한글 깨짐을 막기 위해 문자 인코딩 처리한 json 객체의 값은 decodeURIComponent() 로 디코딩 처리함
					value += "<tr><td>" + json.list[i].boardNum + "</td><td>" +  
					<%if (member != null) {%>
					"<a href='/first/bdetail?bnum=" + json.list[i].boardNum + "&page=1'>"					
							+ decodeURIComponent(json.list[i].boardTitle)
							+ "</a>" + <%} else {%> 
							decodeURIComponent(json.list[i].boardTitle) 							
							<%}%>"</td></tr>";
							
				}

				$("#gg").html(value);
			}
		});

	}); //click
</script>
</body>

</html>