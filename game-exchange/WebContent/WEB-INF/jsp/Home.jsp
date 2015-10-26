<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/GameExchange/css/mystyle.css" type="text/css" media="screen" />
<title>Game Exchange</title>
</head>
<body>
<div class="container">
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="row">
		<h2>Products &amp; Services</h2>
		<div class="col-3">
		  <p><img src="/GameExchange/images/mass-effect.jpg"></p>
		  <h3>Mass Effect</h3>
		</div>
		<div class="col-3">
		  <p><img src="/GameExchange/images/dragon-age.jpg"></p>
		  <h3>Dragon Age</h3>
		</div>
		<div class="col-3">
		  <p><img src="/GameExchange/images/saints-row.jpg"></p>
		  <h3>Saints Row</h3>
		  </div>
		<div class="col-3">
		  <p><img src="/GameExchange/images/halo-3.jpg"></p>
		  <h3>Halo 3</h3>
		</div>
	</div>
	<hr>
	<div class="row">
		<div class="col-6">
		  <h2>Vision &amp; Mission</h2>
		  <p>Game Exchange buys and sells second hand games at great prices. Whether you are looking for a rare limited edition or just want to exchange your collection for something new, Game Exchange has the game for you.</p>
	    </div>
		<div class="col-6">
			<h2>Business Strategy</h2>
			<p>Game Exchange aspires to offer the most extensive collection of used video games. Our goal is to provide great quality service and games to our customers while keeping prices low.</p>
		</div>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</div>
</body>
</html>