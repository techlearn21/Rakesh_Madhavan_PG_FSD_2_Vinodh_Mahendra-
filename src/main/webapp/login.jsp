<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Login</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<style>
	.login-form {
	    width: 550px;
	    margin: 50px auto;
	  	font-size: 15px;
	}
	.login-form h2 {
		color: #636363;
		margin: 0 0 15px;
		position: relative;
		text-align: center;
	}
	.login-form .hint-text {
		color: #999;
		margin-bottom: 30px;
		text-align: center;
	}
	.login-form form {
	    margin-bottom: 15px;
	    background: #f7f7f7;
	    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	    padding: 30px;
	}
	.login-form h2 {
	    margin: 0 0 15px;
	}
	.form-control, .btn {
	    min-height: 38px;
	    border-radius: 2px;
	}
	.btn {        
	    font-size: 15px;
	    font-weight: bold;
	}
</style>

</head>
<body>
	

	<div class="login-form">
			<form action="/booking-app/login" method="post">
				<h2 class="text-center">Log in</h2>
				<p class="hint-text">Log in to your account.</p>
				<div class="form-group">
		            <input type="text" class="form-control" placeholder="Username" name="username" required="required">
		        </div>
		        <div class="form-group">
		            <input type="password" class="form-control" placeholder="Password" name="password" required="required">
		        </div>
		        
		        <div class="form-group">
		        	<div class="row">
		            	<div class="col"><button type="submit" class="btn btn-primary btn-block">Log in</button></div>
		            	<div class="col"><button type="reset" class="btn btn-secondary btn-block">Clear</button></div>
	            	</div>
		        </div>
				
		</form>
	</div>

</body>
</html>