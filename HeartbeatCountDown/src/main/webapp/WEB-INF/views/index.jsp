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
		<div class="container-contact3">
			<div class="wrap-contact3">
				<form class="contact3-form validate-form" action="/date" method = "post">
					<span class="contact3-form-title"> Beat Dropper</span>

					<!-- <div class="wrap-contact3-form-radio">
						<div class="contact3-form-radio m-r-42">
							<input class="input-radio3" id="radio1" type="radio"
								name="choice" value="say-hi" checked="checked"> <label
								class="label-radio3" for="radio1"> Say Hi </label>
						</div>

						<div class="contact3-form-radio">
							<input class="input-radio3" id="radio2" type="radio"
								name="choice" value="get-quote"> <label
								class="label-radio3" for="radio2"> Get a Quote </label>
						</div>
					</div> -->

					<div class="wrap-input3 validate-input"
						data-validate="Name is required">
						<input class="input3" type="text" name="userName"
							placeholder="Your Name"></input><span class="focus-input3"></span>
					</div>

					<div class="container-contact3-form-btn">
						<button class="contact3-form-btn">Submit</button>
					</div>
				</form>

				<!-- 		<a href="/hiscores" class="btn btn-primary">See the High Scores</a> -->
			</div>
		</div>
	</div>


	<!-- 	
	<a href = "/hiscores" class = "btn btn-primary">See the High Scores</a> -->

</body>
</html>