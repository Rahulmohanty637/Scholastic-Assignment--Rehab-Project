<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Welcome,
		<%=session.getAttribute("patientName")%>!
	</h1>


	<h2>Your Information:</h2>
	<ul>
		<li><strong>Name:</strong> <%=session.getAttribute("patientName")%></li>
		<li><strong>Email:</strong> <%=session.getAttribute("patientEmail")%></li>
		<li><strong>Medical History:</strong> <%=session.getAttribute("medicalHistory")%></li>

	</ul>


	<h2>Actions:</h2>
	<ul>
		<li>
		<form action="ProgramServlet" method="post">
		Enroll in a Program <input type="submit" value="Program">
		</form>
		</li>
		<li>
		<form action="LoginServlet" method="post">
		<a href="BookCounselingSession.jsp">Book a Counseling
				Session</a></form>
				</li>

	</ul>


	<h2>Your Enrolled Programs:</h2>
	<ul>
		<li><strong>Program 1:</strong> Description or details</li>
		<li><strong>Program 2:</strong> Description or details</li>

	</ul>


	<h2>Your Upcoming Appointments:</h2>
	<ul>
		<li><strong>Appointment 1:</strong> Date, time, counselor</li>
		<li><strong>Appointment 2:</strong> Date, time, counselor</li>

	</ul>


</body>
</html>