<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css" href="styles.css">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>StartPage</title>
</head>
<body>

	<div class="bg-contact3"
		style="background-image: url('images/iStock_45504088_MEDIUM.jpg');">
		<div class="container">
			<div class="row">
				<!-- <div class = "column"></div> -->
				<div class="col-lg-6">
					<div class="container-contact3">
						<div class="wrap-contact3">
							<form class="contact3-form validate-form" action="/login-result"
								method="post">
								<span class="contact3-form-title"> Existing User</span>
								<div class="wrap-input3 validate-input"
									data-validate="Name is required">
									<input class="input3" type="text" name="userName"
										placeholder="Username: " required></input><span
										class="focus-input3"></span>
								</div>
								<div class="wrap-input3 validate-input"
									data-validate="Password is required">
									<input class="input3" type="password" name="passWord"
										placeholder="Password: " required></input><span
										class="focus-input3"></span>

								</div>

								<span> ${wrong }</span>

								<div class="container-contact3-form-btn">
									<button class="contact3-form-btn" type="submit">Submit</button>
								</div>
							</form>

							<!-- 		<a href="/hiscores" class="btn btn-primary">See the High Scores</a> -->
						</div>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="container-contact3">
						<div class="wrap-contact3">
							<form class="contact3-form validate-form" action="/date"
								method="post">
								<span class="contact3-form-title"> New User </span>

								<div class="wrap-input3 validate-input"
									data-validate="Name is required">
									<input class="input3" type="text" name="name"
										placeholder="Name: " required></input><span
										class="focus-input3"></span>
								</div>
								<div class="wrap-input3 validate-input"
									data-validate="userName is required">
									<input class="input3" type="text" name="userName"
										placeholder="Username: " required></input><span
										class="focus-input3"></span>
								</div>
								<div class="wrap-input3 validate-input"
									data-validate="Name is required">
									<input id="password" class="input3" type="password"
										name="passWord" placeholder="Password: "
										onkeyup="confirmPassword()" required></input><span
										class="focus-input3"></span>

								</div>
								<div class="wrap-input3 validate-input"
									data-validate="Password is required">
									<input id="confirm_password" class="input3" type="password"
										placeholder="Confirm Password: " onkeyup="confirmPassword()"
										required></input><span class="focus-input3"></span>
								</div>
								<span id="message"></span>

								<div class="container-contact3-form-btn">
									<button id="submit" class="contact3-form-btn">Submit</button>
								</div>
							</form>

							<!-- 		<a href="/hiscores" class="btn btn-primary">See the High Scores</a> -->
						</div>
					</div>


				</div>
				<!-- 		<div class="column">
	</div> -->
			</div>



		</div>
	</div>
	<script>
		function confirmPassword() {
			if (document.getElementById("password").value === document
					.getElementById("confirm_password").value) {
				document.getElementById("message").style.color = "black";
				document.getElementById("message").innerHTML = "Passwords are matching";
				document.getElementById("submit").disabled = false;
			} else {
				document.getElementById("message").style.color = "red";
				document.getElementById("message").innerHTML = "Passwords are not matching!";
				document.getElementById("submit").disabled = true;
			}
		}
	</script>

</body>
</html>