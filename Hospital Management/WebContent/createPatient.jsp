<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="createPatient.css"/>
<meta charset="ISO-8859-1">
<title>Register Patient</title>
<script type="text/javascript" src="validation.js">	
</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<h3 align="center">Patient Registration</h3>
<div class="center">
			<form action="DeskController" method="post" class="form"  onsubmit="return validateData();">
				<table class="content">
					<tr>
						<th> 
							Patient SSN Id<span>*</span>
						</th>
						<td>
							<input type="number" name="ssnid" required id="ssnid"
							title="SSNId must be 9 digit numeric" >
						</td>
						<td><small id="s_id"></small></td>
					</tr>
					
					<tr>
						<th>
							Patient Name<span>*</span>
						</th>
						<td>
							<input type="text" name="name" required id="patientname"
							title="Name should contain only alphabets ">
						</td>
						<td><small id="s_name"></small></td>
						
					</tr>
					
					<tr>
						<th>
							Patient Age<span>*</span>
						</th>
						<td>
							<input type="number" name="age" required id="age" maxlength="3" pattern=\d{3} 
							title="Enter valid age">
						</td>
						<td><small id="s_age"></small></td>
					</tr>
					
					<tr>
						<th>
							Date of Admission<span>*</span>
						</th>
						<td>
							<input type="date" name="dateofadmission" required id="doa" placeholder="dd/mm/yyyy"  
							title="enter date">
						</td>
						<td><small id="s_doa"></small></td>
					</tr>
					
					<tr>
						<th>
							Type of Bed<span>*</span>
						</th>
						<td>
							<select name="bedtype"   class="bed-select" required>
								<option value="none" selected hidden>Select</option>
								<option value="generalward">General Ward</option>
								<option value="semisharing">Semi-Sharing</option>
								<option value="singleroom">Single Room</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<th>
							Address<span>*</span>
						</th>
						<td>
							<input type="text" name="address" required  id="addr"
							title="Enter Address "></td>
							<td><small id="s_addr"></small></td>
					</tr>
					
					<tr>
						<th>
							State<span>*</span>
						</th>
						<td>
							<select name="state"   class="state-select" required>
								<option value="none" selected hidden>Select</option>
								<option value="Andhra Pradesh">Andhra Pradesh</option>
								<option value="Delhi">Delhi</option>
								<option value="Gujarat">Gujarat</option>
								<option value="Kerala">Kerala</option>
								<option value="Madhya Pradesh">Madhya Pradesh</option>
								<option value="Maharashtra">Maharashtra</option>
								<option value="Punjab">Punjab</option>
								<option value="Rajasthan">Rajasthan</option>
								<option value="Tamil Nadu">Tamil Nadu</option>
								<option value="Telangana">Telangana</option>
							</select>
						</td>
					</tr>
					
					<tr>
						<th>
							City<span>*</span>
						</th>
						<td>
							<select name="city"   class="state-select" required>
								<option value="none" selected hidden>Select</option>
								<option value="Banglore">Banglore</option>
								<option value="Bhopal">Bhopal</option>
								<option value="Chennai"> Chennai</option>
								<option value="Hyderabad">Hyderabad</option>
								<option value="Indore">Indore</option>
								<option value="Mumbai">Mumbai</option>
								<option value="Nagpur">Nagpur</option>
								<option value="Pune">Pune</option>
								<option value="Raipur">Raipur</option>
								<option value="Surat">Surat</option>	
								<option value="Udaipur">Udaipur</option>	
							</select>
						</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<span>(*) Fields are compulsory </span>
						</td>
						
					</tr>
					
					<tr>
						<td>
							<input type="hidden" name="action" value="addPatient">
							<input type="submit" name="submit" value="submit" />
						</td>
						<td>
							<input type="reset" name="reset" />
						</td>
					</tr>
					
				</table>
			</form>
		</div>

</body>
</html>