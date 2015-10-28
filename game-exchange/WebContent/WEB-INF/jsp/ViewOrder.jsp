<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/mystyle.css" type="text/css" media="screen" />
<title>View Order</title>
</head>
<body>
<div class="container">
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="row">
		<form:form modelAttribute="order" method="post" action="confirmation">
		<h2>Items</h2>
		<hr>
		<table>
	    	<tr>
				<th class="left-col">Title</th>
				<th>Quantity</th>
			</tr>
	       <c:forEach items="${sessionScope.order.orderList}" var="list" varStatus="pStatus">
  	<tr>      
   		<td>${list.title}</td>
    	<td>${list.quantity}</td> 
 	</tr>
</c:forEach>
	    </table>
	    
	    <h2>Payment Info</h2>
	    <hr>
	    <table>
	    	<tr>
	    		<td class="left-col">Name: </td>
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
	    <hr>
	    <table>
	    	<tr>
	    		<td class="left-col">Address 1: </td>
	    		<td>${sessionScope.shipping.address1}</td>
	    	</tr>
	    	<tr>
	    		<td>Address 2: </td>
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
	    </table>
	    <input class="button" type="submit" value="Submit Order"/>
	</form:form>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>