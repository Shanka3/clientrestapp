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
		<div id="header">
			<h2>BTS - Bug Tracking System</h2>
		</div>
	</div>

	<div id="container">
		<h3>Delete a ticket</h3>

		<form:form action="deleteTicket" modelAttribute="theTicketResolve"
			method="DELETE">


			<div class="button_bar">
				<table>
					<tbody>

						<tr>
							<td><label>Enter bug Id:</label></td>
							<td><form:input path="bugId" pattern="[0-9]{1,}"
									required="required" /></td>
						</tr>

						<tr>
							<td><label></label></td>
							<td><input
								onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"
								type="submit" value="Delete Bug" class="save" /></td>
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