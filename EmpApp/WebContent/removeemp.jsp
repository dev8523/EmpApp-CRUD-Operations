<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#cc99ff">
	<center>
		<form action="RemoveEmpServlet" method="post">
			<h2>Remove Page of Employee</h2>

			<tr>
				<td>Employee Id:</td>
				<td><input type="text" name="empid" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="remove" /></td>
			</tr>
		</form>
	</center>
</body>
</html>