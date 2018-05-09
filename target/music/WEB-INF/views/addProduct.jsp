<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="templets/header.jsp"%>
	<div class="container">
		<h1 align="center">Add Product</h1>
		<form:form method="POST"
			action="${pageContext.request.contextPath}/admin/addProduct"
			commandName="product" enctype="multipart/form-data">
			<center>
				<table class="table">

					<tr>
						<td><form:label path="productName">Name</form:label></td>
						<td><form:input path="productName" id="productName" /></td>
					</tr>
					<br>
					<tr>
						<td><form:label path="productDescription">Description</form:label></td>
						<td><form:input path="productDescription"
								id="productDescription" /></td>
					</tr>
					<br>
					<tr>
						<td><form:label path="quantity">Quantity</form:label></td>
						<td><form:input path="quantity" id="quantity" /></td>
					</tr>
					<br>
					<tr>
						<td><form:label path="price">Price</form:label></td>
						<td><form:input path="price" id="price" /></td>
					</tr>
					<tr>
						<td><form:label path="image">Image</form:label></td>
						<td><form:input type="file" path="image" /></td>
					</tr>

				</table>

				<input type="submit" value="Submit">
			</center>
		</form:form>
	</div>
	<%@include file="templets/footer.jsp"%>
</body>
</html>
