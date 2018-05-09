<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templets/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>


            <p class="lead">Customer Details:</p>
        </div>

        <form:form commandName="order" class="form-horizontal">

        <h3>Shipping Address:</h3>

       <div class="form-group">
            <label for="shippingHouseNo">House No</label>
            <form:input path="cart.customer.shippingAddress.houseNo" id="shippingAddresshouseNo" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingStreet">Street No</label>
            <form:input path="cart.customer.shippingAddress.streetNo" id="shippingAddressstreetNo" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippinglocality">locality</label>
            <form:input path="cart.customer.shippingAddress.locality" id="shippingAddresslocality" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippinglandmark">landmark</label>
            <form:input path="cart.customer.shippingAddress.landmark" id="shippingAddresslandmark" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingState">State</label>
            <form:input path="cart.customer.shippingAddress.state" id="shippingAddressstate" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingCountry">Country</label>
            <form:input path="cart.customer.shippingAddress.country" id="shippingAddresscountry" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="shippingZipcode">ZipCode</label>
            <form:input path="cart.customer.shippingAddress.zipCode" id="shippingAddresszipCode" class="form-Control" />
        </div>
        
        
        <input type="hidden" name="_flowExecutionKey" />

        <br/><br/>

        <button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>

        <input type="submit" value="Next" class="btn btn-default" name="_eventId_shippingDetailCollected" />

        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

        </form:form>

<%@include file="/WEB-INF/views/templets/footer.jsp" %>