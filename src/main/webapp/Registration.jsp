<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	
	function toggleCounselorFields() {
		
		var role = document.getElementById("role").value;
		var patientFieldhistory = document
				.getElementById("patientFieldhistory");
		var patientFieldhistorydoc = document
				.getElementById("patientFieldhistorydoc");
		var counselorFieldsqual = document
				.getElementById("counselorFieldsqual");
		var counselorFieldsspel = document
				.getElementById("counselorFieldsspel");
		var counselorFieldsphn = document.getElementById("counselorFieldsphn");

		// Show counselor-specific fields only when the role is "Counselor"
		counselorFieldsqual.style.display = role === "Counselor" ? "table-row-group"
				: "none";
		counselorFieldsspel.style.display = role === "Counselor" ? "table-row-group"
				: "none";
		counselorFieldsphn.style.display = role === "Counselor" ? "table-row-group"
				: "none";

		patientFieldhistory.style.display = role === "Patient" ? "table-row-group"
				: "none";
		patientFieldhistorydoc.style.display = role === "Patient" ? "table-row-group"
				: "none";

	}
</script>
</head>
<body>
	<h2>User and Counselor Registration</h2>
	<form action="Registration_controller" method="POST">
		<table>
			<tr>
				<td><label for="username">Username:</label></td>
				<td><input type="text" id="username" name="username" required></td>
			</tr>
			<tr>
				<td><label for="password">Password:</label></td>
				<td><input type="password" id="password" name="password"
					required></td>
			</tr>
			<tr>
				<td><label for="email">Email:</label></td>
				<td><input type="email" id="email" name="email" required></td>
			</tr>
			<tr>
				<td><label for="firstName">First Name:</label></td>
				<td><input type="text" id="firstName" name="firstName" required></td>
			</tr>
			<tr>
				<td><label for="lastName">Last Name:</label></td>
				<td><input type="text" id="lastName" name="lastName" required></td>
			</tr>
			<tr>
				<td><label for="role">Role:</label></td>
				<td><select id="role" name="role" required
					onchange="toggleCounselorFields()">
						<option value="Patient">Patient</option>
						<option value="Counselor">Counselor</option>
				</select></td>
			</tr>
			<tr id="patientFieldhistory" style="display: none;">
				<td><label for="medichistory">Medical History:</label></td>
				<td><input type="text" id="medichistory" name="medichistory"></td>
			</tr>
			<tr id="patientFieldhistorydoc" style="display: none;">
				<td><div class="btn">
						<span>File</span> <input name="document" type="file">
					</div></td>
				<td><div class="file-path-wrapper">
					</div></td>
			</tr>
			<tr id="counselorFieldsqual" style="display: none;">
				<td><label for="qualifications">Qualifications:</label></td>
				<td><input type="text" id="qualifications"
					name="qualifications"></td>
			</tr>
			<tr id="counselorFieldsspel" style="display: none;">
				<td><label for="specializations">Specializations:</label></td>
				<td><input type="text" id="specializations"
					name="specializations"></td>
			</tr>
			<tr id="counselorFieldsphn" style="display: none;">
				<td><label for="Phone No.">Phone no.:</label></td>
				<td><input type="tel" id="phone" name="pnone_no."></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
</body>
</html>