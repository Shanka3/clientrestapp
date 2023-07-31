<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Bugs</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Bug Tracking System</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- put new button: Add Customer -->
			<div class="button_bar">
				<input type="button" value="Add Bug"
					onclick="window.location.href='showFormToCreateTicket'; return false;"
					class="add-button" /> <input type="button" value="Update Ticket"
					onclick="window.location.href='showFormToUpdateTicket'; return false;"
					class="add-button" /> <input type="button" value="Delete Bug"
					onclick="window.location.href='showFormToDeleteTicket'; return false;"
					class="add-button" /> <br>
				<form action="getTicketId">
					<input type="search" pattern="[0-9]{1,}" required="required" placeholder="Enter your bug id"
						class="save search" name="theBugId"> <input type="submit"
						value="Find Bug" class="save search_but" /><br> <br>
				</form>
				<!--  add our html table here -->
			</div>

			<table>
				<tr>
					<th>Bug Id</th>
					<th>Ticket Id</th>
					<th>Bug Name</th>
					<th>Bug Description</th>
					<th>Assigned To</th>
					<th>Status</th>
					<th>Bug Module Type</th>
				</tr>

				<!-- loop over and print our bugs -->
				<c:forEach var="tempBugs" items="${bugs}">



					<tr>
						<td>${tempBugs.bugId}</td>
						<td>${tempBugs.ticketId}</td>
						<td>${tempBugs.bugName}</td>
						<td>${tempBugs.bugDescription}</td>
						<td>${tempBugs.assignedTo}</td>
						<td>${tempBugs.status}</td>
						<td>${tempBugs.bugModuleType}</td>



					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>
