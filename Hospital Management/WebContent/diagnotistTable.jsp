<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<br>
<br>
<br>
<%
String id= request.getParameter("pid");
String test= request.getParameter("test");
int cost=0;

String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "testdb";
String userId = "root";
String password = "Shivam";
try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;

try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM diagnosis where testname="+test;

resultSet = statement.executeQuery(sql);
while(resultSet.next()){ 
	
	cost=resultSet.getInt("amt");
		

%>
<h2 style="text-align:center;">Diagnostics</h2>
<br>
<br>
<br>
<br>
<div style="text-align:center;">
<form action="Diagnostics" method="post">
<input type="hidden" name="patientId" value="<%=id%>">
<input type="hidden" name="testname" value="<%=test%>">
<input type="hidden" name="testcost" value="<%=cost%>">
<table>
<tr>
<td>Name of Test</td>
<td>Amount</td>
</tr> 
<tr>
<td><%=test %></td>
<td><%=cost %></td>
</tr>
<% 	
}

} catch (Exception e) {
e.printStackTrace();
}
finally{
	
}
%>

</table>
<br>
<input type="submit" value="Add" name="btn">
</form>
</div>
</body>
</html>