<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Deallocate Employee</h1></center>
<form action="deallocateemployee.htm">
<table align="center">
<tr><td>Employee Id</td><td><input type="text" name="empid"/></td></tr>

<tr><td colspan="2"><center><input type="submit" name="ok" value="Deallocate Employee"></center></td></tr>
</table>

<span style="color:red"><center>${message}</center></span>
<span style="color:red"><center>${error}</center></span>
<br><center><a href="displayHome.htm">HOME</a></center>
</body>
</html>