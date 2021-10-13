<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor details</title>
</head>
<body>
<table>
	<tr>
		<td>Registration ID</td>
		<td>Donor Name</td>
		<td>Blood Group</td>
		<td>Contact Number</td>
		<td>Last Blood Date</td>
		<td>Donor Location</td>
		<td>Blood Camp ID</td>
	</tr>
<c:forEach items="${data}" var="eachItem">	
	<tr>
		<td>${eachItem.regId}</td>
		<td>${eachItem.studentName}</td>
		<td>${eachItem.bloodGrp}</td>
		<td>${eachItem.phoneNumber}</td>
		<td>${eachItem.lastDonated}</td>
		<td>${eachItem.campId}</td>
	</tr>
</c:forEach>	
</table>
</body>
</html>