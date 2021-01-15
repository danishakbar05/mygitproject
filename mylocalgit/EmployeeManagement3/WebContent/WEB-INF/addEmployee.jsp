<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Add Employee to Project</h1></center>

<sp:form action="insertemployee.htm" modelAttribute="employee">
<table align="center">
<tr><td>Employee Name</td><td><sp:input path="employeeName"/></td></tr>
<tr><td>Skill</td><td><sp:input path="skill"/></td></tr>
<tr><td>ProjectId</td><td><sp:select path="projectId">
		 <sp:options items="${projectids}"/>
		 </sp:select></td></tr>
<tr><td colspan="2"><center><input type="submit" name="ok" value="Add Employee"></center></td></tr>
</table>
</sp:form>
<span style="color:red"><center>${message}</center></span>
<span style="color:red"><center>${error}</center></span>
<br><center><a href="displayHome.htm">HOME</a></center>
</body>
</html>