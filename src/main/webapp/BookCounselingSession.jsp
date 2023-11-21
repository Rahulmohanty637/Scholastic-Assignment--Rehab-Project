<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Book a Counseling Session</h1>

	<form action="BookCounselingSessionServlet" method="post">
		<label for="sessionDate">Session Date:</label> <input type="date"
			id="sessionDate" name="sessionDate" required> <label
			for="sessionTime">Session Time:</label> <input type="time"
			id="sessionTime" name="sessionTime" required> <label
			for="sessionDuration">Session Duration (in minutes):</label> <input
			type="number" id="sessionDuration" name="sessionDuration" required>

		<label for="counselor">Select a Counselor:</label> <select
			id="counselor" name="counselor" required>
			<option value="hdtj">Counselor 1</option>
			<option value="Peter">Counselor 2</option>
			<!-- Add more counselor options as needed -->
		</select> <label for="patientId">Your Patient ID:</label> <input type="text"
			id="patientId" name="patientId" required> <input
			type="submit" value="Book Session">
	</form>

	<%
	String bookingSuccess = request.getParameter("bookingSuccess");
	if (bookingSuccess != null && bookingSuccess.equals("true")) {
	%>
	<div style="color: green;">Your counseling session has been
		successfully booked!</div>
	<%
	}
	%>
</body>
</html>