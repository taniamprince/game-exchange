<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/mystyle.css" type="text/css" media="screen" />
<title>Contact Us</title>
</head>
<body>
<div class="container">
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="row">
		<h2>Contact Us</h2>
		<p>Please fill out the form below and we will get right back to you!<br/><br/></p>
		<table class="contact">
			<tr>
				<td>Name:</td>
				<td><input type="text"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text"></td>
			<tr>
			<tr>
				<td valign="top">Message:</td>
				<td><textarea cols="90" rows="8"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="button" type="submit" value="Submit"/><br/><br/></td>
			</tr>
		</table>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>