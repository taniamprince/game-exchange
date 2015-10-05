<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="data" class="edu.osu.cse5234.model.Item" scope="session"/>
<jsp:setProperty name="data" property="*"/>

<form:form modelAttribute="order" method="post" action="purchase/submitItems">
    <table>
    	<tr>
    		<td><jsp:getProperty name="data" property="title"/></td>
    		<td></td>
    	</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit"/></td>
		</tr>
    </table>
</form:form>

</body>
</html>