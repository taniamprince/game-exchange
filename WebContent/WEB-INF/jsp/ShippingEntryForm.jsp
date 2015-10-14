<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/mystyle.css" type="text/css" media="screen" />
<title>Shipping</title>
</head>
<body>
<div class="container">
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="row">
		<h2>Shipping</h2>
		<hr>
		<form:form modelAttribute="shipping" method="post" action="submitShipping">
	    <table>
	    	<tr>
	    		<td class="left-col">Address 1: </td>
	    		<td><form:input path="address1"/></td>
	    	</tr>
	    	<tr>
	    		<td>Address 2: </td>
	    		<td><form:input path="address2"/></td>
	    	</tr>
	    	<tr>
	    		<td>City: </td>
	    		<td><form:input path="city"/></td>
	    	</tr>
	    	<tr>
	    		<td>State: </td>
	    		<td><form:input path="state"/></td>
	    	</tr>
	    	<tr>
	    		<td>Zip: </td>
	    		<td><form:input path="zip"/></td>
	    	</tr>
	    </table>
	    <input class="button" type="submit" value="Next"/>
	</form:form>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>