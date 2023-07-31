<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Update Ticket</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>BTS - Bug Tracking System</h2>
		</div>
	</div>

	<div id="container">
		<h3>Update a ticket</h3>

		<form:form action="updateTicket" modelAttribute="ticketResolve"
			method="POST">


			<div class="button_bar">
				<table>
					<tbody>

						<tr>
							<td><label>Enter developer Id:</label></td>
							<td><form:input type="tel" path="devId" pattern="[0-9]{1,}"
									required="required" /></td>
						</tr>

						<tr>
							<td><label>Enter bug Id:</label></td>
							<td><form:input type="tel" path="bugId" 
									pattern="[0-9]{1,}" required="required" /></td>
						</tr>

						<tr>
							<td><label>Enter status:</label></td>
							<td><form:input type="text" path="status"
									required="required" /></td>
						</tr>



						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Update Ticket" class="save" /></td>
						</tr>


					</tbody>
				</table>

			</div>
		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/ticketrise/list"
				class="add-button"> Back to List &larr;</a>
		</p>

	</div>

</body>

</html>
