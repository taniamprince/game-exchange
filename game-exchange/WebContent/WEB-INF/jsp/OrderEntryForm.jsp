<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/mystyle.css" type="text/css" media="screen" />
<title>Order</title>
</head>
<body>
<div class="container">
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="row">
	<c:if test="${failed == true}">
	Error, order could not be processed.
	</c:if>
		<h2>Games</h2>
		<hr>
		<form:form modelAttribute="quantity" method="post" action="purchase/submitItems">
	    <table>
	    	<tr>
				<th class="left-col">Title</th>
				<th>Description</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>			
			<c:forEach items="${inventory}" var="list" varStatus="pStatus">
		  	<tr>      		  		
		   		<td>${list.name}</td>
		   		<td>${list.description}</td>
		   		<td>${list.price}</td>
		   		<td><form:input path="quantity[${pStatus.index}]" /></td>
		 	</tr>
			</c:forEach>		
	    </table>
	    <input class="button" type="submit" value="Next"/>
		</form:form>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>