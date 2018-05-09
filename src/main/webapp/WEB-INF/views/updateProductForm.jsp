<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Music</title>
</head>
<body>
	<%@include file="templets/header.jsp"%>
	<div class="container">
		<h3 align="center">Update Product</h3>


		<form:form
			action="${pageContext.request.contextPath}/admin/updateProductForm/sumbit" method="post" commandName="product" enctype="multipart/form-data">
			<form:hidden path="productId" value="${product.productId}" />

			<div class="form-group">
				<form:label path="productName">Enter product Name</form:label>
				<form:input path="productName" class="form-control"
					style="width:750px" />
			</div>

			<div class="form-group">
				<form:label path="productDescription">Enter ProductDescription</form:label>
				<form:textarea path="productDescription" class="form-control"
					style="width:750px" />
			</div>

			<div class="form-group">
				<form:label path="quantity">Enter Quantity</form:label>
				<form:input path="quantity" class="form-control" style="width:750px" />
			</div>

			<div class="form-group">
				<form:label path="price">Enter Price</form:label>
				<form:input path="price" class="form-control" style="width:750px" />
			</div>

			<div class="form-group">
				<form:label path="image">Enter Image</form:label>
				<form:input type="file" path="image" style="width:750px" />
			</div>

			<input type="submit" value="Submit">
		</form:form>
	</div>

	<%@include file="templets/footer.jsp"%>
</body>
</html>