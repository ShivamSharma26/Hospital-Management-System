<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("success");
String med_name = (String) request.getAttribute("name");
%>
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
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/json2/20130526/json2.min.js"></script>
<script type="text/javascript">
<link rel="stylesheet" href="style_table.css">
<link rel="stylesheet" href="style.css">
	function addRow() {
		var table = document.getElementById("dataTable");

		//Create an empty <tr> element and add it to the 1st position of the table:
		//var row = table.insertRow(0);
		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);
		//Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);

		var x = document.getElementById("msg").innerText;
		
		cell1.innerHTML = document.getElementById("med_name").value;
		cell2.innerHTML = document.getElementById("quantity").value;
		cell3.innerHTML = "Rs."+x;

		var y = document.getElementById("quantity").value;
		var result = x * y;

		cell4.innerHTML = "Rs."+result;

		console.log(result);

	}
	function callServletWithAjax() {

		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				if (xmlhttp.responseText != 0.0) {
					document.getElementById("msg").innerHTML = xmlhttp.responseText;
				} else {
					alert('Medicine not available');
				}
			}
		};
		var para1 = document.getElementById("med_name").value;
		var para2 = document.getElementById("quantity").value;

		console.log(para1);
		console.log(para2);
		console.log(document.getElementById("med_name").value);
		xmlhttp.open("POST", "IssueMedicineController?med_name=" + para1, true);
		xmlhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		
		xmlhttp.send("quant=" + para2);

	}
</script>
</head>
<body>
<jsp:include page="header2.jsp"></jsp:include>
	<form class="example">
		<table class="content-table">
			<tr>
				<td>Medicine Name:</td>

				<td><input type="text" id="med_name" name="med_name"></td>
				<td>Quantity:</td>
				<td><input type="text" id="quantity" name="quantity" min="1"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="rate" id="rate" />

					<button type="button" onclick="callServletWithAjax()">Search</button>
					<input type="hidden" name="action" id="rate" /></td>
				<td>
					<p id="msg"></p>
				</td>
			</tr>
			
		</table>
	</form>



	<%
		try {/*Double rate=0.0;
			
			rate=(Double)request.getAttribute("rate");
			System.out.println("rate is:"+rate);
			if(rate>0.0)
			{*/
	%>
	<div>
		<div class="content" style="float: left">

			<table class="content-table" id="dataTable" border="1">
				<tr>
					<th>Medicine Name</th>
					<th>Quantity</th>
					<th>Rate</th>
					<th>Amount</th>

				</tr>
			</table>
		</div>
		<div class="button-content" style="float: right">
			<input type="submit" value="Add" onclick="addRow()" />
		</div>
<%String id=(String)request.getAttribute("medicineId");
System.out.println("addMedicine"+id);
%>
	</div>
	<form action=# method="post">
	<%request.setAttribute("id",id); %>
	<input type="submit" name="Update" value="Update" />
	</form>
	<%
		} catch (Exception e) {
	} finally {
	}
	%>

</body>
</html>