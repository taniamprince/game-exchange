<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="../css/mystyle.css" type="text/css" media="screen" />
<title>Order Submitted</title>
</head>
<body>
<div class="container">
	<jsp:include page="Header.jsp"></jsp:include>
	<h2>Order Submitted</h2>
	<div class="row">
		<p>Thank you for your order!</p>
		<p>Your confirmation number is ${sessionScope.confirmation}</p>
		
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>