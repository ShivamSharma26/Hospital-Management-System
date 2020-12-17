<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.hospitalmanagement.util.DatabaseUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style_table.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
%>
 <h2 align="center">View Patients</h2>
<% try{ 
connection = DatabaseUtil.getConnection();
String query ="SELECT * FROM PatientInfo";
statement=connection.prepareStatement(query);
resultSet = statement.executeQuery(query);
%><table class="content-table">
<thead>
<tr>
<th>Patient Id</th>
<th>Name</th>
<th>Age</th>  
<th>Address</th>
<th>DOJ</th>
<th>Type of Room</th>
</tr>

</thead>

<% 
while(resultSet.next()){
%> 

<tbody>
<tr>
<td><%=resultSet.getInt("id")%></td> <!-- fetching patient id -->
<td><%=resultSet.getString("name")%></td> <!-- fetching patient name -->
<td><%=resultSet.getInt("age")%></td> <!-- fetching patient age -->
<td><%=resultSet.getString("address") %></td> <!-- fetching address -->
<td><%=resultSet.getString("admissiondate") %></td> <!-- fetching date of joining -->
<td><%=resultSet.getString("bedtype") %></td> <!-- fetching type of room -->
</tr>
</tbody>
<%
}

} catch (Exception e) {
e.printStackTrace();
}
finally{
	
}
%>
</table>
</body>
</html>