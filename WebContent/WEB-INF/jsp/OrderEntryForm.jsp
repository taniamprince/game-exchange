<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Entry</title>
</head>
<body>
<h1>Order Entry</h1>
<form:form modelAttribute="order" method="post" action="purchase/submitItems">
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
		<tr>
			<td colspan="2"><input type="submit" value="Submit Order"/></td>
		</tr>
    </table>
</form:form>

</body>
</html>