<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>TODO supply a title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/style.css">



</head>
<body>
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			<li data-target="#carousel-example-generic" data-slide-to="3"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="1111.jpeg">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img src="2222.jpg">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img src="3333.png">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img src="4444.jpeg">
				<div class="carousel-caption"></div>
			</div>
		</div>
		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>



	<header>
		<div id="blackpad"></div>

		<div id="logobox">
			<img id="logo" src="logo.png">
			<p>
				electric<br>Moblie Menu &<br>order<br>system
			</p>
		</div>

		<div id="private">
			<div class="navbar-collapse collapse ">
				<ul class="nav navbar-nav">
					<li><a href="#" data-toggle="modal" data-target="#myModal"><span
							class="glyphicon glyphicon-lock" aria-hidden="true"> 로그인</span></a></li>

					<li><a href="#"><span class="glyphicon glyphicon-plus"
							aria-hidden="true"> 회원가입 </span></a></li>
				</ul>
			</div>
		</div>
	</header>



	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Modal Header</h4>
				</div>
				<div class="modal-body">
					<p>Some text in the modal.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


	<section style="height: 800px;">




		<div class="container">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-3 micon">
					<a href="location.html"> <span
						class="glyphicon glyphicon glyphicon-cutlery" aria-hidden="true"></span>
						<p class="gn">우리동네 메뉴판 !</p>
					</a>
				</div>
				<div class="col-sm-3 micon">
					<a href="search.html"> <span
						class="glyphicon glyphicon-list-alt" aria-hidden="true"></span>
						<p class="gn">셀러 오피스!</p>
					</a>
				</div>
				<div class="col-sm-3"></div>
			</div>

		</div>

		<div class="mobile" id="qr">
			<span class="glyphicon glyphicon-qrcode" aria-hidden="true"></span>
			<p class="gn">QR코드 검색</p>

		</div>





	</section>
	<footer>
		<div class=""></div>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<a href="#">개인정보 처리방침</a> | <a href="#">저작권 정책</a> | <a href="#">관련
						사이트</a> <br>
					<br>
					<p>(34055) 경기도 안양시 동안구 호계동 전화: 010-6635-7088, 팩스: 031-123-5678</p>
					<p>Copyright (C) 2017 KH Information & Security Institute. All
						Rights Reserved.</p>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>