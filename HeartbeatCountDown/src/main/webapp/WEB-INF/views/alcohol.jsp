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
<title>Alcohol</title>
</head>
<body>

	<div class="bg-contact3"
		style="background-image: url('images/iStock_45504088_MEDIUM.jpg');">
		<div class="container-contact3">
			<div class="wrap-contact3">
				<div class="contact3-form-radio m-r-42">
					<form class="contact3-form validate-form" action="/bmi"
						method="post">
						<span class="contact3-form-title"> Beat Dropper</span> Do you
						drink alcohol?<br> <label>Yes 
						<input type="radio"
							onclick="javascript:yesnoCheck(); possibleFirst();"
							name="alcohol" value="idrink" id="yesCheck" required>
						</label>
						<br>
						<label>No
						<input type="radio"
							onclick="javascript:yesnoCheck(); possibleFirst();"
							name="alcohol" value="nodrink" id="noCheck"> <br>
						<div id="ifYes" style="visibility: hidden">
						</label>
							<div class="form-group">
								How much do you drink? <br>
								<select class="custom-select" name="amountDrunk">
									<option value=" " hidden=" " id="first">Choose Below</option>
									<option value = "none" id = "zero">Less than 1-2 drinks per day</option>
									<option value="low">A drink before bed (1-2
										drinks per day)</option>
									<option value="medium">Every now and again (2-3.5
										drinks per day)</option>
									<option value="high">Bars are my second home (3.5+
										drinks per day)</option>
								</select>

							</div>
						</div>
						<div class="container-contact3-form-btn">
							<button class="contact3-form-btn">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function yesnoCheck() {
			if (document.getElementById('yesCheck').checked) {
				document.getElementById('ifYes').style.visibility = 'visible';
			} else
				document.getElementById('ifYes').style.visibility = 'hidden';
		}

		function possibleFirst() {
			if (document.getElementById('yesCheck').checked) {
				document.getElementById('first').selected = "true";
			} else
				document.getElementById('zero').selected = "true";
		}
	</script>
</body>
</html>