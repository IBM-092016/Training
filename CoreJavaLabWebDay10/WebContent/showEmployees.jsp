<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
<script>
	function editEmployee(empid, empname, empage){
		console.log(empid);
		var element = document.getElementById("empid");
		element.value= empid;
		element = document.getElementById("empname");
		element.value= empname;
		element = document.getElementById("empage");
		element.value= empage;
	}
	
</script>
</head>
<body>
<c:if test="${requestScope.action eq 'update'}">
<form action="UpdateEmployee" method="post" id="saveForm"></form>
</c:if>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Age</th>
			<c:choose>
				<c:when test="${requestScope.action eq 'delete'}"><th>Action</th></c:when>
				<c:when test="${requestScope.action eq 'update'}"><th>Action</th></c:when>						
			<c:otherwise></c:otherwise>
			</c:choose>	
			
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${requestScope.employees}" var="employee">
			<tr>
				<td><c:out value="${employee.id}"></c:out></td>
				<td><c:out value="${employee.name}"></c:out></td>
				<td><c:out value="${employee.age}"></c:out> </td>
				<c:choose>
				<c:when test="${requestScope.action == 'delete'}"><td>
					<form action="DeleteEmployee" method="post">
					<input type="hidden" name=empID value='<c:out value="${employee.id}"></c:out>'/>
					<input type="submit" name="del" value="DELete">
					</form>
					</td></c:when>
					<c:when test="${requestScope.action == 'update'}"><td>
					<input type="button" value="Edit" onclick='editEmployee(<c:out value="${employee.id}"></c:out>, "<c:out value="${employee.name}"></c:out>", <c:out value="${employee.age}"></c:out>)'/>
					</td></c:when>
				<c:otherwise></c:otherwise>
				</c:choose>
			</tr>
		</c:forEach>
		</tbody>
		<c:if test="${requestScope.action == 'update'}">
		<tfoot>
			<tr>
			<td><input type="text" size="4" id="empid" name="empid" form="saveForm" readonly></td>
			<td><input type="text" id="empname" size="10" name="empname" form="saveForm"></td>
			<td><input type="text" size="10" id="empage" name="empage" form="saveForm"></td>
			<td><input type="submit" value="Save" form="saveForm"></td>
			</tr>
		</tfoot>
		</c:if>
	</table>
</body>
</html>
