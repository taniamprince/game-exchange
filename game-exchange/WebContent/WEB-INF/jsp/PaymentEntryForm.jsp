<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/mystyle.css" type="text/css" media="screen" />
<title>Payment</title>
</head>
<body>
<div class="container">
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="row">
		<h2>Payment</h2>
		<hr>
		<form:form modelAttribute="payment" method="post" action="submitPayment">
	    <table>
	    	<tr>
	        	
	    		<td class="left-col">Name: </td>
	    		<td><form:input path="cardholder_name" /></td>
	    	</tr>
	    	<tr>
	    		<td>CC Number: </td>
	    		<td><form:input path="cc_num"/></td>
	    	</tr>
	    	<tr>
	    		<td>Exp: </td>
	    		<td><form:input path="exp"/></td>
	    	</tr>
	    	<tr>
	    		<td>CCV: </td>
	    		<td><form:input path="ccv"/></td>
	    	</tr>
	    </table>
	    <input class="button" type="submit" value="Next"/>
		</form:form>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>