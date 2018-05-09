<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@include file="/WEB-INF/views/templets/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Customer</h1>


            <p class="lead">Customer Details:</p>
        </div>
     </div>
</div>

        <form:form modelAttribute="order" class="form-horizontal">

        <h3>Basic Info:</h3>

        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="cart.customer.name" id="name" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="email">EMAILID</label>
            <form:input path="cart.customer.emailId" id="emailId" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="phone">Phone No</label>
            <form:input path="cart.customer.phoneNo" id="phoneNo" class="form-Control" />
        </div>

        <br/>

        <h3>Billing Address:</h3>
        
        <div class="form-group">
            <label for="billingHouseNo">House No</label>
            <form:input path="cart.customer.billingAddress.houseNo" id="billingAddresshouseNo" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingStreet">Street No</label>
            <form:input path="cart.customer.billingAddress.streetNo" id="billingAddressstreetNo" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billinglocality">locality</label>
            <form:input path="cart.customer.billingAddress.locality" id="billingAddresslocality" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billinglandmark">landmark</label>
            <form:input path="cart.customer.billingAddress.landmark" id="billingAddresslandmark" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingState">State</label>
            <form:input path="cart.customer.billingAddress.state" id="billingAddressstate" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingCountry">Country</label>
            <form:input path="cart.customer.billingAddress.country" id="billingAddresscountry" class="form-Control" />
        </div>

        <div class="form-group">
            <label for="billingZipcode">ZipCode</label>
            <form:input path="cart.customer.billingAddress.zipCode" id="billingAddresszipCode" class="form-Control" />
        </div>

        <input type="hidden" name="_flowExecutionKey" />

        <br/><br/>

        <input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected" />

        <button class="btn btn-default" name="_eventId_cancel">Cancel</button>

        </form:form>

<%@include file="/WEB-INF/views/templets/footer.jsp" %>