<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
			<c:choose>
			<c:when test="${requestScope.action}"><th>Action</th></c:when>				
			<c:otherwise></c:otherwise>
			</c:choose>	
			
			</tr>
		</thead>
		<c:forEach items="${requestScope.employees}" var="employee">
			<tr>
				<td><c:out value="${employee.id}"></c:out></td>
				<td><c:out value="${employee.name}"></c:out></td>
				<td><c:out value="${employee.age}"></c:out> </td>
				<c:choose>
				<c:when test="${requestScope.action}"><td>
					<form action="DeleteEmployee" method="post">
					<input type="hidden" name=empID value='<c:out value="${employee.id}"></c:out>'/>
					<input type="submit" name="del" value="DELete">
					</form>
					</td></c:when>
				<c:otherwise></c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
