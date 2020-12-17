<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Patient</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<p style="text-align:center;"><h2> Delete Patient</h2></p>
<p style="text-align:center;">
<form action="confirmDeletePatient.jsp" method="post">
Patient ID  <input type="text" name="pId">
<br>
<input type="submit" value="Submit" name="btn">
</form>
</p>
</body>
</html>