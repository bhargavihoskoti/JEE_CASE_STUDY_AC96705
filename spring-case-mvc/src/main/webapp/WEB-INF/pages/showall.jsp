<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donor details</title>
<style>
html,
body {
	height: 100%;
}

body {
	margin: 0;
	background: linear-gradient(45deg, #49a09d, #5f2c82);
	font-family: sans-serif;
	font-weight: 100;
}
.container {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

table {
	width: 900px;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0,0,0,0.1);
}
td ,th{
	padding: 40px;
	background-color: rgba(255,255,255,0.2);
	color: #fff;
}

th {
	text-align: left;
}

thead {
	th {
		background-color: #55608f;
	}
}

tbody {
	tr {
		&:hover {
			background-color: rgba(255,255,255,0.3);
		}
	}
	td {
		position: relative;
		&:hover {
			&:before {
				content: "";
				position: absolute;
				left: 0;
				right: 0;
				top: -9999px;
				bottom: -9999px;
				background-color: rgba(255,255,255,0.2);
				z-index: -1;
			}
		}
	}
}
		


</style>
</head>
<body>
<div class="container">
<table>
	<thead>
	<tr>
		<th>Registration ID</th>
		<th>Donor Name</th>
		<th>Blood Group</th>
		<th>Contact Number</th>
		<th>Last Blood Date</th>
		<th>Donor Location</th>
		<th>Blood Camp ID</th>
	</tr>
	</thead>
	
   <c:forEach items="${data}" var="eachItem">
   <tbody>	
	<tr>
		<td>${eachItem.regId}</td>
		<td>${eachItem.donorName}</td>
		<td>${eachItem.bloodGrp}</td>
		<td>${eachItem.phoneNumber}</td>
		<td>${eachItem.lastDonated}</td>
		<td>${eachItem.location}</td>
		<td>${eachItem.campId}</td>
	</tr>
	</tbody>
</c:forEach>	
	
</table>
</div>
</body>
</html>