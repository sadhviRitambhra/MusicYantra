<!DOCTYPE html>

<html>
<head>

<title>insert a image</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>


<body>

	<%@include file="templets/header.jsp"%>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="./resources/images/music0.jpg" width=100%>
			</div>

			<div class="item">
				<img src="./resources/images/music1.jpg" width=100%>
			</div>

			<div class="item">
				<img src="./resources/images/s.jpg" width=100%>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>


		<center>
			<div>
				<h2>
					<centre>
					<img src="./resources/images/m1.jpg" class="img-circle" width="304"
						height="236"> <img src="./resources/images/m2.jpg"
						class="img-circle" width="304" height="236"> <img
						src="./resources/images/m3.jpg" class="img-circle" width="304"
						height="236"></centre>
				</h2>

			</div>
		</center>


		<%@include file="templets/footer.jsp"%>
</body>
</html>
