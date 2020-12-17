<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" href="style_table.css">
<link rel="stylesheet" href="style.css">
</head>

<body>
	<div id="header" class="container-fluid  bg-dark" style="text-align: center">
		<p>ABC Hospital Management System</p>
	</div>
	<div id="sub-header" style="text-align: center">
		<h2>ABC Hospital Management System</h2>
		<hr/>
		<div class="patientInfo">
			<form>
				<select onchange="location = this.value;" disabled>
					<option value="none" selected hidden>Patient</option>
					<option value="createPatient.jsp">Patient Registration</option>
					<option value="deletePatient.jsp"> Delete Patient</option>
					<option value="#"> Update Patient </option>
					<option value="searchPatient.jsp">Search Patient </option>
					<option value="viewPatient.jsp">View Patient Details </option>
					<option value="#"> Bill Patient</option>
				</select>
			</form>
		</div>
		<div class="pharmacyInfo">
			<form>
				<select onchange="location = this.value;"disabled >
					<option value="none" selected hidden>Pharmacy</option>
					<option value="issueMedicine.jsp">Issue Medicines</option>
				</select>
			</form>
		</div>
		<div class="diagnotistInfo">
			<form>
				<select onchange="location = this.value;" >
					<option value="none" selected hidden>Diagnotist</option>
					<option value="#">Patient Registration</option>
				</select>
			</form>
		</div>
	</div>


</body>
</html>