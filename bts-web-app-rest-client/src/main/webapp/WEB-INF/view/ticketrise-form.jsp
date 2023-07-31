<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Create Ticket</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Bug Tracking System</h2>
		</div>
	</div>

	<div id="container">
		<h3>Rise a ticket</h3>

		<form:form action="saveTicket" modelAttribute="ticketRise"
			method="POST">



			<!-- need to associate this data with customer id -->
			<form:hidden path="ticketId" />
			<div class="button_bar">
				<table>
					<tbody>

						<tr>
							<td><label>Enter your name:</label></td>
							<td><form:input path="testerName" required="required"  /></td>
						</tr>

						<tr>
							<td><label>Enter bug name:</label></td>
							<td><form:input path="bugName" required="required" /></td>
						</tr>

						<tr>
							<td><label>Enter bug description:</label></td>
							<td><form:input path="bugDescription" required="required" /></td>
						</tr>

						<tr>
							<td><label>Enter bug module type:</label></td>
							<td><form:input path="bugModuleType" required="required" /></td>
						</tr>

						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Create Ticket" class="save " /></td>
						</tr>


					</tbody>
				</table>
			</div>
		</form:form>


		<p>
			<a href="${pageContext.request.contextPath}/ticketrise/list"
				class="add-button"> Back to List &larr;</a>
		</p>

	</div>

</body>

</html>
