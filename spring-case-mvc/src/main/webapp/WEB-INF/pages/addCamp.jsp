<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Camp</title>
<style>
body{
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 10px;
  background: linear-gradient(135deg, #71b7e6, #9b59b6);
}
.register{
font-family: "Roboto", sans-serif;
width: 650px;
margin: 30px auto;
background: linear-gradient(to right, #ffffff 0%,#fafafa 50%,#ffffff 99%);
border-radius: 10px;

}
.form-header{
background-color: #EFF0F1;
border-top-left-radius: 10px;
border-top-right-radius: 10px;
}
.form-header h1 {
  font-size: 30px;
  text-align:center;
  color:#666;
  padding:20px 0;
  border-bottom:1px solid #cccccc;
}
.form-body {
  padding:10px 40px;
  color:#666;
}
.form-body .label-title {
  color:#1BBA93;
  font-size: 17px;
  font-weight: bold;
}
.form-body .form-input {
    font-size: 17px;
    box-sizing: border-box;
    width: 100%;
    height: 34px;
    padding-left: 10px;
    padding-right: 10px;
    color: #333333;
    text-align: left;
    border: 1px solid #d6d6d6;
    border-radius: 4px;
    background: white;
    outline: none;
}
.btn {
   display:inline-block;
   padding:10px 20px;
   background-color: #1BBA93;
   font-size:17px;
   border:none;
   border-radius:5px;
   color:#bcf5e7;
   cursor:pointer;
   align-items: center;
}

.btn:hover {
  background-color: #169c7b;
  color:white;
}
.form-footer  {
  background-color: #EFF0F1;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  padding:10px 40px;
  text-align: right;
  border-top: 1px solid #cccccc;
}

.form-footer span {
  float:left;
  margin-top: 10px;
  color:#999;  
  font-style: italic;
  font-weight: thin;
}

</style>
</head>
<body>
<div>
		<form:form class="register" action="/addCamp"  modelAttribute="command" method="post">
			<div class="form-header"><h1>Camp Registration</h1></div>
			<div class="form-body">
			<div>
				<label for=""  class="label-title">Camp ID</label>
				<form:input path="campId" class="form-input"/>
			</div>
			<div>
				<label for=""  class="label-title">Camp Name</label>
				<form:input path="campName" class="form-input"/>
				

			</div>
			
			<div>
				<label for=""  class="label-title">Organizer Name</label>
				<form:input  path="organizerName" class="form-input" />
			</div>
		
			<div>
				<label for=""  class="label-title">Location</label>
				<form:input path="location" class="form-input"/>
			</div>
			<div>
				<label for=""  class="label-title">Conduction Date</label>
				<form:input type="date" path="conductDate" class="form-input" />
			</div>
			</div>
			<div class="form-footer">
			<span>Your blood can save a life</span>
				<input type="submit" value="Add" class="btn">
			</div>
		</form:form>
	</div>

</body>
</html>