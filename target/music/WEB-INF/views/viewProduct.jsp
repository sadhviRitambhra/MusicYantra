<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@include file="templets/header.jsp"%>
<div class="container" ng-app="cartApp">
	<div class="container">
		<table class="table">
			<tr>
				<th><b>Product Image</b></th>
				<th><b> Product Name</b></th>
				<th><b> Product Description</b></th>

			</tr>

			<tr>
				<td><img class="img-fluid" style="height: 200px; width: 200px"
					src="<c:url value="/resources/images/${products.productId}.png"/>" /></td>
				<td>${products.productName}</td>
				<td>${products.productDescription}</td>

			</tr>
		</table>
	</div>

	<c:set var="role" scope="page" value="${param.role}" />
	<c:set var="url" scope="page" value="/allProducts" />
	<c:if test="${role='admin'}">
		<c:set var="url" scope="page" value="/admin/allProducts" />
	</c:if>

	<p ng-controller="cartCtrl">
		<a href="<c:url value = "${url}" />" class="btn btn-default">Back</a>
		<a href="#" class="btn btn-warning btn-large"
			ng-click="addToCart('${products.productId}')"><span
			class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a> <a
			href="<spring:url value="/customer/cart" />" class="btn btn-default"><span
			class="glyphicon glyphicon-hand-right">View Cart</span></a>
	</p>

</div>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="templets/footer.jsp"%>
