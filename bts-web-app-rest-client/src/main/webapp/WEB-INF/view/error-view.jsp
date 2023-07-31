<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Delete Ticket</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="error">
			<h1>Opp's Something Wrong</h1>
			<p>${message}</p>
		</div>
	</div>

	<br>
	<br>
	<br>
	<p>
		<a href="${pageContext.request.contextPath}/ticketrise/list"
			class="add-button"> Back to List &larr;</a>
	</p>


</body>

</html>










