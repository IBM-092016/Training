<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Demo Using j_security_check</h2>
	<form name="loginForm" method="POST" action="j_security_check">
		<p>
			User name: <input type="text" name="j_username" size="20" />
		</p>
		<p>
			Password: <input type="password" size="20" name="j_password" />
		</p>
		<p>
			<input type="submit" value="Submit" />
		</p>
	</form>
</body>
</html>