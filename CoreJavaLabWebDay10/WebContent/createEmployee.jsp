<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new employee</title>
</head>
<body>
	<h2>Create new employee</h2>
	<form method="POST" action="CreateEmployee">
		<p>
			Employee name: <input type="text" name="empname" size="30" />
		</p>
		<p>
			Employee age: <input type="text" size="20" name="empage" />
		</p>
		<p>
			<input type="submit" value="Submit" />
		</p>
	</form>
</body>
</html>