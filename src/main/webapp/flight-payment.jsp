<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.booking.model.Flight"%>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">

<title>Payment</title>

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
	width: 450px;
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
	
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
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

		<div class="signup-form">
			<form action="/booking-app/flight-confirmation" method="post">
				<h2>Payment</h2>
				<p class="hint-text">Pay using your card</p>
		        
    		    <div class="form-group">
					<div class="row">
						<div class="col"><h5><span class="label label-default">Card Holder's name</span></h5></div>
					</div>
					<div class="row">
						<div class="col"><input type="text" class="form-control" name="name" required="required"></div>
					</div>
		        </div>
		        
		        <div class="form-group">
					<div class="row">
						<div class="col"><h5><span class="label label-default">Card Number</span></h5></div>
					</div>
					<div class="row">
						<div class="col"><input type="number" class="form-control" name="number" required="required"></div>
					</div>        	
		        </div>
		        
		        <div class="form-group">
					<div class="row">
						<div class="col"><h5><span class="label label-default">Expiration</span></h5></div>
					</div>     
					<div class="row">
						<div class="col">
							<select class="form-control" name="expiry_month" id="expiry_month">
				                <option></option>
				                <option value="01">Jan (01)</option>
				                <option value="02">Feb (02)</option>
				                <option value="03">Mar (03)</option>
				                <option value="04">Apr (04)</option>
				                <option value="05">May (05)</option>
				                <option value="06">June (06)</option>
				                <option value="07">July (07)</option>
				                <option value="08">Aug (08)</option>
				                <option value="09">Sep (09)</option>
				                <option value="10">Oct (10)</option>
				                <option value="11">Nov (11)</option>
				                <option value="12">Dec (12)</option>
				              </select>
						</div>
						<div class="col">
							<select class="form-control" name="expiry_year">
				                <option value="21">2021</option>
				                <option value="22">2022</option>
				                <option value="23">2023</option>
				                <option value="24">2024</option>
				                <option value="25">2025</option>
				                <option value="26">2026</option>
				                <option value="27">2027</option>
				              </select>
						</div>
					</div>   	
		        </div>
		        
		        <div class="form-group">
					<div class="row">
						<div class="col"><h5><span class="label label-default">CVV</span></h5></div>
					</div> 
					<div class="row">
						<div class="col"><input type="number" class="form-control" name="cvv" required="required"></div>
					</div>
					<input type="hidden" name="flightCode" value="<%= request.getParameter("flightCode") %>" />
		        </div>
		        		        
		        <div class="form-group">
					<div class="row">
						<div class="col"></div>
						<div class="col"><button type="submit" class="btn btn-primary btn-block">Pay Now</button></div>
						<div class="col"></div>
					</div>        	
		        </div>
				
		</form>
	</div>

</body>
</html>