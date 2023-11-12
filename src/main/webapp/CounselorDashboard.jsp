<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Welcome, <%= session.getAttribute("counselorName") %>!</h1>
    
    <!-- Display counselor-specific information -->
    <h2>Your Information:</h2>
    <ul>
        <li><strong>Name:</strong> <%= session.getAttribute("counselorName") %></li>
        <li><strong>Email:</strong> <%= session.getAttribute("counselorEmail") %></li>
        <li><strong>Qualifications:</strong> <%= session.getAttribute("qualifications") %></li>
        <li><strong>Specializations:</strong> <%= session.getAttribute("specializations") %></li>
        <!-- Add more counselor information here -->
    </ul>
    
    <!-- Counselor Actions -->
    <h2>Actions:</h2>
    <ul>
        <li><a href="ViewAppointments.jsp">View Appointments</a></li>
        <li><a href="WriteReports.jsp">Write Reports</a></li>
        <!-- Add more counselor actions here -->
    </ul>
    
    <!-- Display upcoming appointments or other counselor-specific data -->
    <!-- Example: Upcoming Appointments -->
    <h2>Your Upcoming Appointments:</h2>
    <ul>
        <li><strong>Appointment 1:</strong> Date, time, patient</li>
        <li><strong>Appointment 2:</strong> Date, time, patient</li>
        <!-- Add more appointments here -->
    </ul>
    
    <!-- Add more sections and content as needed -->
</body>
</html>