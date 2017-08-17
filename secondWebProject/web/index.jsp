<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<script type="text/javascript" src="views/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url : "/second/btop5",
			type : "get",
			dataType : "json",
			success : function(data){
				//console.log(data);
				var jsonStr = JSON.stringify(data);  //객체를 문자열로 변환
				//console.log(jsonStr);
				var json = JSON.parse(jsonStr); //문자열을 배열 객체로 바꿈
						
				var values = "";
				for(var i in json.list){
					//한글 깨짐을 막기 위해 문자 인코딩 처리한 json 객체의 값은 decodeURIComponent() 로 디코딩 처리함
					values += "<tr><td><a href='/second/bdetail?bnum=" + 
							json.list[i].bnum + "&page=1'>" +  
							decodeURIComponent(json.list[i].btitle) + 
							"</a></td></tr>";
				}
				
				$("#toplist").html(values);
			}
		});
	});
</script>
</head>
<body>
<%@ include file="header.jsp" %>
<br>
<table id="toplist" border="1" cellspacing="0">
</table>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<%@ include file="footer.html" %>
</body>
</html>






