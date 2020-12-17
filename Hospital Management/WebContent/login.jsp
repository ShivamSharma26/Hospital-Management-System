<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String errMessage=(String)request.getAttribute("message"); %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="login.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<div class="center">
			<h1>Login</h1>
			<form name="myform" action="LoginController" method="post">
				<% if(errMessage!=null){ %>
				 <h4 style="color:red;"><%=errMessage%></h4>
				<% } %>
				<div class="txt_field">
					<input type="text" name="username" required title="Username may be alphabetic and alphaumeric"/>
					<span></span>
					<label>Username</label>
				</div>
				
				<div class="txt_field">
					<input type="password" name="password" required title="Password must contain 1 uppercase ,1 special character,alphanumeric characters" />
					<span></span>
					<label>Password</label>
				</div>
				<input type="hidden" name="action" value="login"/>
				<input type="submit" value="Login" />
			</form>
</div>
</body>
</html>