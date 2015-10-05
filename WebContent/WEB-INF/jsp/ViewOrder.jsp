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
        	<td><input value="Mass Effect" name ="title1"/></td>
        	<td><input value="0" name="quantity1"/></td>
        </tr>
        <tr>
        	<td><input value="Dragon Age" name ="title1"/></td>
        	<td><input value="0" name="quantity1"/></td>
        </tr>
        <tr>
        	<td><input value="Saints Row" name ="title1"/></td>
        	<td><input value="0" name="quantity1"/></td>
        </tr>
    </table>
    
    <h2>Payment Info</h2>
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
    </table>
    
    <h2>Shipping Info</h2>
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
			<td colspan="2"><input type="submit" value="Submit Order"/></td>
		</tr>
    </table>
</form:form>

</body>
</html>