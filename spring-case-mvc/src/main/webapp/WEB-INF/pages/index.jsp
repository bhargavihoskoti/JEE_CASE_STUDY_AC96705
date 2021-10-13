<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Red Cross</title>
<style>
html{

  background-color: yellow;
  

}
body{

  font-family: "Helvetica", Sans-Serif;
  
  text-align: center;

}
</style>
</head>
<body>

<h1>${majHeading}</h1>
<hr>
<a href="addDonor">Register Donar</a>
<hr>
<a href="getAllDonors">Show Donars</a>
<hr>
<a href="addCamp">Add Camp</a>
<hr>
<a href="getAllCamps">Show Camps</a>
<hr>
<a href="searchByLoc">Search by Location</a>
<hr>
<a href="searchByBloodGroup">Search by Blood Group</a>
<hr>
<a href="deleteById">Delete by Donor ID</a>
<hr>
<a href="updateById">Update by Donor ID</a>
<hr>
<div class="instruct">
<h1>Instructions</h1>
<p>1.Eligible Age to Donate Blood is Above 18</p>
<p>2.Your Previous blood donated date should be more than 6 month</p>
<p>3.Eligible weight is Above 50</p>
</div>
</body>
</html>