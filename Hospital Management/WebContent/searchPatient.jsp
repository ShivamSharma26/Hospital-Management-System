<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Patient</title>
<script type="text/javascript">
function yesnoCheck() 
{
    if (document.getElementById('yesCheck').checked) 
    {
       document.getElementById('ifYes').style.display = 'block';
    } 
   
}

</script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div>
<p style="text-align:center;"><h2> View Patient</h2></p>
<p style="text-align:center;">
<form action="ViewPatientController" method="post">
Patient ID  <input type="text" name="pId" id="id">
<br>
<input type="submit"  onclick="javascript:yesnoCheck();"  id="yesCheck" value="Submit" name="btn" >
</form>
</p>
</div>
<%try{ %>
<div id="ifYes" >
<br>
<%String date1=(String)request.getAttribute("DOJ");
System.out.println("jsp"+date1);%>
<h2 align="center"><font><strong>View Patient</strong></font></h2>
<table style="text-align:center;">
<tr>
<td>Patient Id</td>
<td>${pid} </td> <!-- fetching Patient id -->
</tr>
<tr>
<td>Patient Name</td>
<td>${pname}</td> <!-- fetching Patient name -->
</tr>
<tr>
<td>Patient Age</td>
<td>${age}</td> <!-- fetching Patient age -->
</tr>
<tr>
<td>Date of Admission</td>
<td><%=date1 %></td> <!-- fetching Date of Admission -->
</tr>
<tr>
<td>Type of Bed</td>
<td>${tob}</td> <!-- fetching Type of Bed -->
</tr>
<tr>
<td>Address</td>
<td>${address}</td> <!-- fetching Patient Address -->
</tr>
<tr>
<td>State</td>
<td>${state}</td> <!-- fetching Patient State -->
</tr>
<tr>
<td>City</td>
<td>${city}</td> <!-- fetching Patient City -->
</tr>
<%}catch(Exception e){
	}finally{
	}%>

</table>
</div>
</body>
</html>