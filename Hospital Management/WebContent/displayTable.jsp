<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Display</title>
</head>
<body>
<div style="text-align:center;">
<table>
<tr>
<td>Patient Id</td>
<td>${pid}</td> <!-- fetching Patient id -->
</tr>
<tr>
<td>Test</td>
<td>${testname}</td> <!-- fetching Test Name -->
</tr>
<tr>
<td>Amount</td>
<td>${amt}</td> <!-- fetching Test Amount -->
</tr>
</table>
</div>
</body>
</html>