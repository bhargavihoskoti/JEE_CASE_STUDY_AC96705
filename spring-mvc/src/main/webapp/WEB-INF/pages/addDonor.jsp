<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Donor</title>
</head>
<body>
<div>
		<form:form action="/addDonor" modelAttribute="command" method="post">
			<div>
				<label for="">Registration ID</label>
				<form:input path="regId" />
			</div>
			<div>
				<label for="">Donor Name</label>
				<form:input path="donorName" />
				<form:errors path="donorName" cssStyle="color:#ff0000;"/>

			</div>
			<div>
				<label for="">Blood Group</label>
				<form:select path="bloodGrp" >
				<form:option value="A+" value="A+"/>
				<form:option value="A-" value="A-"/>
				<form:option value="B-" value="B-"/>
				<form:option value="B+" value="B+"/>
				<form:option value="AB-" value="AB-"/>
				<form:option value="AB+" value="AB+"/>
				<form:option value="O-" value="O-"/>
				<form:option value="O+" value="O+"/>
				</form:select>
			</div>
			<div>
				<label for="">Contact Number</label>
				<form:input type="number" path="phoneNumber" />
			</div>
			<div>
				<label for="">Last Blood Date</label>
				<form:input type="date" path="lastDonated" />
			</div>
			<div>
				<label for="">Donor Location</label>
				<form:input path="location" />
			</div>
			<div>
				<label for="">Blood Camp ID</label>
				<form:input path="campId" />
			</div>
			<div>
				<input type="submit" value="Add">
			</div>
		</form:form>
	</div>

</body>
</html>