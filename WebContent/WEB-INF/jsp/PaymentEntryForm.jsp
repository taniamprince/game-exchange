<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
<h1>Payment</h1>
<form:form modelAttribute="payment" method="post" action="submitPayment">
    <table>
    	<tr>
        	
    		<td>Name: </td>
    		<td><form:input path="name" /></td>
    	</tr>
    	<tr>
    		<td>CC Number: </td>
    		<td><form:input path="CCNum"/></td>
    	</tr>
    	<tr>
    		<td>Exp: </td>
    		<td><form:input path="expDate"/></td>
    	</tr>
    	<tr>
    		<td>CCV: </td>
    		<td><form:input path="CCVCode"/></td>
    	</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit"/></td>
		</tr>
    </table>
</form:form>

</body>
</html>