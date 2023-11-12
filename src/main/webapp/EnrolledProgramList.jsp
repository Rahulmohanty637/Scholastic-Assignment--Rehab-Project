<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ page import="java.util.List"%>
<%@ page import="Model.Program"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Your Profile Picture</h1>
    <table border="1">
    <thead>
        <tr>
            <th>Program ID</th>
            <th>Program Name</th>
            <th>Date</th>
        </tr>
    </thead>
    <tbody>
        <%
        List<Program> enrolledprogram = (List<Program>) request.getAttribute("enrolledPrograms");
        if (enrolledprogram != null && !enrolledprogram.isEmpty()) {
            for (Program enp : enrolledprogram) {
        %>
        <tr>
            <td><%= enp.getProgram_id() %></td>
            <td><%= enp.getProgram_name() %></td>
            <td><%= enp.getEnrollment_date() %></td>
            
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4">You have no appointments.</td>
        </tr>
        <%
        }
        %>
    </tbody>
</table>
</body>
</html>