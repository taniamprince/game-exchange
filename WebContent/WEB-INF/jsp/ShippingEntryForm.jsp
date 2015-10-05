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
<h1>Shipping</h1>
<form:form modelAttribute="order" method="post" action="submitShipping">
    <table>
    	<tr>
    		<td>Addr: </td>
    		<td><input name="addr1"/></td>
    	</tr>
    	<tr>
    		<td>Addr: </td>
    		<td><input name="addr2"/></td>
    	</tr>
    	<tr>
    		<td>City: </td>
    		<td><input name="city"/></td>
    	</tr>
    	<tr>
    		<td>State: </td>
    		<td><input name="state"/></td>
    	</tr>
    	<tr>
    		<td>Zip: </td>
    		<td><input name="zip"/></td>
    	</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit"/></td>
		</tr>
    </table>
</form:form>

</body>
</html>