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
<form:form modelAttribute="order" method="post" action="submitPayment">
    <table>
    	<tr>
    		<td>Name: </td>
    		<td><input name="name"/></td>
    	</tr>
    	<tr>
    		<td>CC Number: </td>
    		<td><input name="ccNum"/></td>
    	</tr>
    	<tr>
    		<td>Exp: </td>
    		<td><input name="exp"/></td>
    	</tr>
    	<tr>
    		<td>CCV: </td>
    		<td><input name="ccv"/></td>
    	</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit"/></td>
		</tr>
    </table>
</form:form>

</body>
</html>