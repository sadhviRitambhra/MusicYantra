<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>music</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
</style>
</head>
<body>
	<%@include file="templets/header.jsp"%>
	<form:form method="POST" action="registerCustomer"
		commandName="customer">
		<div class="container">

			<div class="container col-sm-4">
				<h4>CUSTOMER DETAILS</h4>
				<table class="table">


					<tr>
						<td><form:label path="name">Name</form:label></td>
						<td><form:input path="name" id="name" /></td>
					</tr>

					<tr>
						<td><form:label path="emailId">EMAILID</form:label></td>
						<td><form:input path="emailId" id="emailId" /></td>
					</tr>
					<tr>
						<td><form:label path="phoneNo">Phone No</form:label></td>
						<td><form:input type="phoneNo" path="phoneNo" /></td>
					</tr>
					<tr>
						<td><form:label path="username">UserName</form:label></td>
						<td><form:input path="username" id="username" /></td>
					</tr>

					<tr>
						<td><form:label path="password">password</form:label></td>
						<td><form:input path="password" id="password" /></td>
					</tr>

				</table>
			</div>

			<div class="container col-sm-4">
				<H4>BILLING DETAILS</H4>
				<table class="table">
					<tr>
						<td><label for="billingAddresshouseNo">houseNo</label></td>
						<td><form:input path="billingAddress.houseNo"
								id="billingAddresshouseNo" /></td>

					</tr>
					<tr>
						<td><label for="billingAddressstreetNo">streetNo</label></td>
						<td><form:input path="billingAddress.streetNo"
								id="billingAddressstreetNo" /></td>
					</tr>
					<tr>
						<td><label for="billingAddresslocality">locality</label></td>
						<td><form:input path="billingAddress.locality"
								id="billingAddresslocality" /></td>

					</tr>
					<tr>
						<td><label for="billingAddresslandmark">landmark</label></td>
						<td><form:input path="billingAddress.landmark"
								id="billingAddresslandmark" /></td>

					</tr>
					<tr>
						<td><label for="billingAddressstate">state</label></td>
						<td><form:input path="billingAddress.state"
								id="billingAddressstate" /></td>

					</tr>
					<tr>
						<td><label for="billingAddresscountry">country</label></td>
						<td><form:input path="billingAddress.country"
								id="billingAddresscountry" /></td>

					</tr>
					<tr>
						<td><label for="billingAddresszipcode">zipCode</label></td>
						<td><form:input path="billingAddress.zipCode"
								id="billingAddresszipCode" /></td>
					</tr>
				</table>
			</div>

			<div class="container col-sm-4">
				<h4>SHIPPING PRODUCT</h4>
				<table class="table">

					<tr>
						<td><label for="shippingAddresshouseNo">houseNo</label></td>
						<td><form:input path="shippingAddress.houseNo"
								id="shippingAddresshouseNo" /></td>

					</tr>
					<tr>
						<td><label for="shippingAddressstreetNo">streetNo</label></td>
						<td><form:input path="shippingAddress.streetNo"
								id="shippingAddressstreetNo" /></td>

					</tr>
					<tr>
						<td><label for="shippingAddresslocality">locality</label></td>
						<td><form:input path="shippingAddress.locality"
								id="shippingAddresslocality" /></td>
					</tr>
					<tr>
						<td><label for="shippingAddresslandmark">landmark</label></td>
						<td><form:input path="shippingAddress.landmark"
								id="shippingAddresslandmark" /></td>


					</tr>
					<tr>
						<td><label for="shippingAddressstate">state</label></td>
						<td><form:input path="shippingAddress.state"
								id="shippingAddressstate" /></td>

					</tr>
					<tr>
						<td><label for="shippingAddresscountry">country</label></td>
						<td><form:input path="shippingAddress.country"
								id="shippingAddresscountry" /></td>

					</tr>
					<tr>
						<td><label for="shippingAddressszipCode">zipCode</label></td>
						<td><form:input path="shippingAddress.zipCode"
								id="shippingAddresszipCode" /></td>

					</tr>
				</table>

			</div>

		</div>
		<center>
			<input type="submit" value="Register Now" />
		</center>
	</form:form>
	<%@include file="templets/footer.jsp"%>
</body>
</html>
