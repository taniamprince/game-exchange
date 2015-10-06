<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipping</title>
</head>
<body>
<h1>View Order</h1>
<form:form modelAttribute="order" method="post" action="confirmation">

	<h2>Items</h2>
	<table>
    	<tr>
			<th>Title</th>
			<th>Quantity</th>
		</tr>
        <tr>
        
        	<td>${sessionScope.order.orderList[0].title}</td>
        	<td>${sessionScope.order.orderList[0].quantity}</td>
        </tr>
        <tr>
        	<td>${sessionScope.order.orderList[1].title}</td>
        	<td>${sessionScope.order.orderList[1].quantity}</td>
        </tr>
        <tr>
        	<td>${sessionScope.order.orderList[2].title}</td>
        	<td>${sessionScope.order.orderList[2].quantity}</td>
        </tr>
    </table>
    
    <h2>Payment Info</h2>
    <table>
    	<tr>
    		<td>Name: </td>
    		<td>${sessionScope.payment.name}</td>
    	</tr>
    	<tr>
    		<td>CC Number: </td>
    		<td>${sessionScope.payment.CCNum}</td>
    	</tr>
    	<tr>
    		<td>Exp: </td>
    		<td>${sessionScope.payment.expDate}</td>
    	</tr>
    	<tr>
    		<td>CCV: </td>
    		<td>${sessionScope.payment.CCVCode}</td>
    	</tr>
    </table>
    
    <h2>Shipping Info</h2>
    <table>
    	<tr>
    		<td>Addr: </td>
    		<td>${sessionScope.shipping.address1}</td>
    	</tr>
    	<tr>
    		<td>Addr: </td>
    		<td>${sessionScope.shipping.address2}</td>
    	</tr>
    	<tr>
    		<td>City: </td>
    		<td>${sessionScope.shipping.city}</td>
    	</tr>
    	<tr>
    		<td>State: </td>
    		<td>${sessionScope.shipping.state}</td>
    	</tr>
    	<tr>
    		<td>Zip: </td>
    		<td>${sessionScope.shipping.zip}</td>
    		
    	</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit Order"/></td>
		</tr>
    </table>
</form:form>

</body>
</html>