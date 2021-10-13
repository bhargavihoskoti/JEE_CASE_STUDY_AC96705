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
<p>To Register Yourself as a Donor</p>
<a href="addDonor">Register Donor</a>
<hr>
<p>To See Available Donars</p>
<a href="getAllDonors">Show Donors</a>
<hr>
<p>To register a Camp</p>
<a href="addCamp">Add Camp</a>
<hr>
<p>To check Available Camps at Present</p>
<a href="getAllCamps">Show Camps</a>
<hr>
<p>To Search Donors by Location</p>
<a href="searchByLoc">Search by Location</a>
<hr>
<p>To search the Donor by Blood Group</p>
<a href="searchByBloodGroup">Search by Blood Group</a>
<hr>
<p>To Unregister as Donor</p>
<a href="deleteById"> Click to Unregister</a>
<hr>
<p>To Update Donor Location</p>
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