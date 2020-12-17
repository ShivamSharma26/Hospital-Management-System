<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hospitalmanagement.util.DatabaseUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Patient</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%


Connection con = null;
PreparedStatement ps = null;
ResultSet resultSet = null;
con = DatabaseUtil.getConnection();
System.out.println(con);
%>
<%

	String id=request.getParameter("pId");
	System.out.println("Patient id on Search screen is"+id);
	
	String sql ="SELECT * FROM PatientInfo where id=?";
	ps=con.prepareStatement(sql);
	ps.setString(1, id);
	resultSet = ps.executeQuery();
	while(resultSet.next()){ 
	String name=resultSet.getString("name");
	System.out.println("Patient id "+resultSet.getString("name"));

	
	
	int age=resultSet.getInt("age");
	String date1=resultSet.getString("admissiondate");
	String tob=resultSet.getString("bedtype");
	String addr=resultSet.getString("address");
	String st=resultSet.getString("state");
	String ct=resultSet.getString("city");
%>


<h2 align="center"><font><strong>Delete Patient</strong></font></h2>
<form action="DeletePatientController" method="post">
<input type="hidden" name="pid" value="<%=id%>">
<table>
<tr>
<td>Patient Id</td>
<td><%=id %></td> <!-- fetching Patient id -->
</tr>
<tr>
<td>Patient Name</td>
<td><%=name %></td> <!-- fetching Patient name -->
</tr>
<tr>
<td>Patient Age</td>
<td><%=age %></td> <!-- fetching Patient age -->
</tr>
<tr>
<td>Date of Admission</td>
<td><%=date1 %></td> <!-- fetching Date of Admission -->
</tr>
<tr>
<td>Type of Bed</td>
<td><%=tob %></td> <!-- fetching Type of Bed -->
</tr>
<tr>
<td>Address</td>
<td><%=addr %></td> <!-- fetching Patient Address -->
</tr>
<tr>
<td>State</td>
<td><%=st %></td> <!-- fetching Patient State -->
</tr>
<tr>
<td>City</td>
<td><%=ct %></td> <!-- fetching Patient City -->
</tr>
<% }

%>
</table>
<br>
<p style="text-align:center;"><input type="submit" value="Submit" name="btn"></p>
</form>

</body>
</html>