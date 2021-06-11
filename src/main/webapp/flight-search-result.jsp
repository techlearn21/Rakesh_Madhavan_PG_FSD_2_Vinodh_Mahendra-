<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.booking.model.Flight"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">

<title>Flights</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>
body {
	color: #fff;
	background: rgb(255, 255, 255);
	font-family: 'Roboto', sans-serif;
}
.form-control {
	height: 40px;
	box-shadow: none;
	color: #969fa4;
}
.form-control:focus {
	border-color: #5cb85c;
}
.form-control, .btn {        
	border-radius: 3px;
}
.signup-form {
	width: 650px;
	margin: 0 auto;
	padding: 30px 0;
  	font-size: 15px;
}
.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	position: relative;
	text-align: center;
}
.signup-form h2:before, .signup-form h2:after {
	content: "";
	height: 2px;
	width: 30%;
	background: #d4d4d4;
	position: absolute;
	top: 50%;
	z-index: 2;
}	
.signup-form h2:before {
	left: 0;
}
.signup-form h2:after {
	right: 0;
}
.signup-form .hint-text {
	color: #999;
	margin-bottom: 30px;
	text-align: center;
}
.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	padding: 30px;
}
.signup-form .form-group {
	margin-bottom: 20px;
}
.signup-form input[type="checkbox"] {
	margin-top: 3px;
}
.signup-form .btn {        
	font-size: 16px;
	font-weight: bold;		
	min-width: 140px;
	outline: none !important;
}
.signup-form .row div:first-child {
	padding-right: 10px;
}
.signup-form .row div:last-child {
	padding-left: 10px;
}    	
.signup-form a {
	color: #fff;
	text-decoration: underline;
}
.signup-form a:hover {
	text-decoration: none;
}
.signup-form form a {
	color: #5cb85c;
	text-decoration: none;
}	
.signup-form form a:hover {
	text-decoration: underline;
} 
</style>


</head>

<body>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="collapse navbar-collapse" id="navbarNavDropdown">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="home.html">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          User
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	          <a class="dropdown-item" href="profile.html">Profile</a>
	          <a class="dropdown-item" href="logout.html">Logout</a>
	          <a class="dropdown-item" href="#">Something else here</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Guest
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	          <a class="dropdown-item" href="register.html">Register</a>
	          <a class="dropdown-item" href="login.html">Login</a>
	          <a class="dropdown-item" href="#">Something else here</a>
	        </div>
	      </li>
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Admin
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
	          <a class="dropdown-item" href="addflight.html">Add Flight</a>
	          <a class="dropdown-item" href="admin-profile.html">Reset Admin Password</a>
	          <a class="dropdown-item" href="#">Something else here</a>
	        </div>
	      </li>
	    </ul>
	  </div>
	</nav>
	
	
	<!--  
		<img class="w3-image" src="./../images/plane3.jpg" alt="The Airline" style="min-width:1000px" width="1800" height="500">
	-->
	
	
	<div class="signup-form">
		
			<h2>Results</h2>
			<p class="hint-text">Flight details based on your search</p>    	
		
	</div>
		<!-- </form>  -->
	
	<form>
	<div class="container">
	  <div class="row">
	    <div class="col-12">
	      <table class="table table-bordered">
	        <thead>
	          <tr>
	            <th scope="col">Select Flight</th>
	            <th scope="col">Airline</th>
	            <th scope="col">From</th>
	            <th scope="col">To</th>
	            <th scope="col">Price Per Ticket</th>
	          </tr>
	        </thead>
	        <tbody>
	          <tr>
	            <td>
	              <div class="custom-control custom-checkbox">
	                  <input type="checkbox" class="custom-control-input" id="customCheck3">
	                  <label class="custom-control-label" for="customCheck3">3</label>
	              </div>
	            </td>
	            <td>Bootstrap Flexbox Tutorial and Examples</td>
	            <td>Cristina</td>
	            <td>1.877</td>
	            <td>1.234</td>
	          </tr>
	          
	          <tr>
	            <td>
	              <div class="custom-control custom-radio">
	                  <input type="radio" class="custom-control-input" id="customCheck4">
	                  <label class="custom-control-label" for="customCheck4">4</label>
	              </div>
	            </td>
	            <td>Bootstrap Flexbox Tutorial and Examples</td>
	            <td>Cristina</td>
	            <td>1.877</td>
	            <td>1.234</td>
	          </tr>
	          	          
	          	<%
					List<Flight> searchResults = new ArrayList();
					searchResults = (List<Flight>) request.getAttribute("searchResults");
					if(searchResults !=null && searchResults.size() > 0) {
						for (int i = 0; i < searchResults.size(); i++) {
					
				%>
			        	<tr>
				            <td>
				              <div class="custom-control custom-radio custom-control-inline">
				                  <input type="radio" class="custom-control-input" id=<%="radio" + i %>>
				                  <label class="custom-control-label" for=<%= "customRadio"+ i %>><%= i + 1 %></label>
				              </div>
				            </td>
				            <td><%= searchResults.get(i).getAirline() + "-" + searchResults.get(i).getCode() %></td>
				            <td><%= searchResults.get(i).getSource() + " at " + searchResults.get(i).getStarttime() %></td>
				            <td><%= searchResults.get(i).getDestination() + " at " + searchResults.get(i).getEndtime()%></td>
				            <td><%= searchResults.get(i).getPrice() %></td>
			            </tr>
			     <%
						}
					} else {
						System.out.println("No results retrieved");
					}
			     %>   
			  
	        </tbody>
	      </table>
	    </div>
	  </div>
	</div>
	</form>
	
	<div class="signup-form">
	<form action="/booking-app/book" method="post">	
        <div class="form-group">
			<div class="row">
				<div class="col"></div>
				<div class="col"><button type="submit" class="btn btn-primary btn-block">Book</button></div>
				<div class="col"></div>
			</div>        	
        </div>
	</form>
	</div>


</body>
</html>