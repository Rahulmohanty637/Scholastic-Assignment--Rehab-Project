<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- password_reset_request.jsp -->
<form action="PasswordResetServlet" method="post">
    <label for="usernameOrEmail">Email:</label>
    <input type="text" id="usernameOrEmail" name="usernameOrEmail" required>
    <input type="submit" value="Request Password Reset">
</form>

</body>
</html>