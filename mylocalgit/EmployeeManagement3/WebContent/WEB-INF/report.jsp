<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="jstlcore" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Employee Report</h1></center>
<table border=1 align="center">

<th>Employee ID</th>
<th>Employee Name</th>
<th>Skill</th>
<th>Project ID</th>

<jstlcore:forEach items="${Employee}" var="e" >
<tr>
<td width="100px" bgcolor="#CCCC99">${e.employeeId}</td>
<td width="100px" bgcolor="#CCCC99">${e.employeeName}</td>
<td width="100px" bgcolor="#CCCC99">${e.skill}</td>
<td width="100px" bgcolor="#CCCC99">${e.projectId}</td>

</tr>
</jstlcore:forEach>


</table>
<br><center><a href="displayHome.htm">Home</a></center>
</body>
</html>