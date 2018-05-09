
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

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<div>
	<header>
	
	<div class= "navbar navbar-inverse navbar-fixed-top">
		<div class="container">
		<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myNavbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>

		  	      <span class="icon-bar"></span>
				  <span class="icon-bar"></span>
				  <span class="icon-bar"></span>
		  </button>
		  
		<a class="navbar-brand" href="#"><img class="imgfluid"
						src="<c:url value="/resources/images/logo.png" />" height="40px"
						width="120px"></a>
		   </div>
		   <div class="navbar-collapse collapse navbar-responsive-collapse" id="myNavbar">   
			<ul class="nav navbar-nav pull-left">
	
		<%-- <nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href=""><img class="imgfluid"
						src="<c:url value="/resources/images/logo.png" />" height="40px"
						width="120px"></a>
				</div> --%>
				<ul class="nav navbar-nav">
					<li class="active"><a href=""><span
							class="glyphicon glyphicon-home">Home</span></a></li>
					<li><a href="allProducts">Products</a></li>
					<li><a href=<c:url value="admin/addProduct"/>>Add Product</a></li>

				</ul>
				</li>
				</ul>
				<ul class="nav navbar-nav pull-right">
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
						<li><a href=<c:url value="/customer/cart"/>><span
								class="glyphicon glyphicon-shopping-cart">Cart</span></a></li>

						<li><a href="<c:url value="/j_spring_security_logout"/>">Logout</a></li>

						<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
							<li><a href="<c:url value="/admin"/>">Admin</a></li>
						</c:if>
					</c:if>

					<c:if test="${pageContext.request.userPrincipal.name == null}">
						<li><a href="<c:url value="/login"/>"><span
								class="glyphicon glyphicon-log-in"></span>Login</a></li>
						<li><a href="<c:url value="/registerCustomer"/>">Register</a></li>

					</c:if>
				</ul>

			</div>
		</nav>
	</header>
</div>