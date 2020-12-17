<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.*"%>
<%@page import="com.hospitalmanagement.util.DatabaseUtil"%>
<%@page import="com.hospitalmanagement.beans.Patient"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="style_table.css">
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="header2.jsp"></jsp:include>
<table class="content-table">
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Age</th>
<th>Address</th>
<th>DOJ</th>
<th>Type of Room</th>
</tr>
</thead>
<%
try{
String id=(String)request.getAttribute("PatientId");%>
<tbody>
<tr>
<td>

<form class="example" action="PharmacyController" method="post">

<button type="submit" ><i class="fa fa-search"></i></button>
  <input type="hidden" name="action"
						value="searchPatient">
<%if(id!=null){ %>
  <input type="text" placeholder="Enter patient id" name="patient_id" id="id" value=<%= (String) request.getAttribute("PatientId")%>>
<%}else{ %>
 <input type="text" placeholder="Enter patient id" name="patient_id" id="id">
 <%} %>
</form>
</td>
<%
Patient p=(Patient)request.getAttribute("Patient Details");
%>
<td><%=p.getName() %></td>
<td><%=p.getAge()%></td>
<td><%=p.getAddress()%></td>
<td><%=p.getDate()%></td>
<td><%=p.getBedtype() %></td>


</tr>
</tbody>
</table>
<div class="center">
		<h3 align="center">
			<font><strong>Medicines Issued</strong></font>
		</h3>
		
			<table class="content-table">
			<thead>
				<tr>
					<th>Medicine</th>
					<th>Quantity</th>
					<th>Rate</th>
					<th>Amount</th>
				</tr>
				</thead>
<%
Connection con = null;
PreparedStatement ps,ps1 = null;
ResultSet rs,rs2 = null;

	con = DatabaseUtil.getConnection();
	System.out.println(con);
	String sql = "SELECT * FROM Issued_Medicine where id=?";
	ps = con.prepareStatement(sql);
	ps.setString(1, id);
	rs = ps.executeQuery();
	while (rs.next()) {
		int medicine_id=rs.getInt("medicine_id");
		int quantity=rs.getInt("quantity");
		System.out.println(medicine_id+""+quantity+"first while ");
		String sql1 = "SELECT * FROM Medicine where medicine_id=?";
		ps1 = con.prepareStatement(sql1);
		ps1.setInt(1, medicine_id);
		rs2 = ps1.executeQuery();
		while (rs2.next()) {
			String name=rs2.getString("medicine_name");
			double rate=rs2.getDouble("rate");
			System.out.println(name+""+rate+"second while ");
			double amount=rate*quantity;
		
	%>
<tbody>
				<tr>
					<td><%=name%></td>
					<!-- fetching medicine name -->
					<td><%=quantity%></td>
					<!-- fetching quantity-->
					<td>Rs.<%=rate%></td>
					<!-- fetching medicine rate -->
					<td>Rs.<%=amount %></td>
					<!-- calculate amount-->
				
				</tr>
				</tbody>
				</table>	
	
</div>	
<%}} 
%>
<%if(id!=null){ %>
<form action="addMedicine.jsp" method="post">
<div class="button" style="text-align:center">
<%request.setAttribute("medicineId",id); %>

 <input type="submit" name="Issue Medicines" value="Issue Medicines" />

</div>
</form>

<%
}	
 
}catch(Exception e){
		
	}
finally{
	
}%>

<%

%>
				
	

		
</body>
</html>