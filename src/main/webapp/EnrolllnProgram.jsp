<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Available Programs</h1>
    <ul>
        <c:forEach items="${programs}" var="program">
            <li>
                <strong>${program.programName}</strong> - ${program.description}
                <form action="EnrollServlet" method="post">
                    <input type="hidden" name="programId" value="${program.programId}">
                    <input type="submit" value="Enroll">
                </form>
            </li>
        </c:forEach>
    </ul>
</body>
</html>