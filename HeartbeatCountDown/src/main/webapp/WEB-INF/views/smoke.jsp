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
<title>smoke</title>
</head>
<body>

	<div class="bg-contact3"
		style="background-image: url('images/iStock_45504088_MEDIUM.jpg');">
		<div class="container-contact3">
			<div class="wrap-contact3">
				<div class="contact3-form-radio m-r-42">
					<form action="/gender" method="post">
						<span class="contact3-form-title"> Beat Dropper</span> Do you
						smoke?<br> Yes <input type="radio"
							onclick="javascript:yesnoCheck(); possibleSecond();" name="smoke"
							id="yesCheck" value="ismoke"> No <input type="radio"
							onclick="javascript:yesnoCheck(); possibleSecond();" name="smoke"
							id="noCheck" value="idontsmoke"> <br>
						<div id="ifYes" style="visibility: hidden">
							<div class="form-group">
								How often do you smoke? <select class="custom-select"
									name="amount">
									<option value="0" hidden=" " id="haha">
									<option value="1" id="second">A cig a day</option>
									<option value="5">1/4 a pack</option>
									<option value="10">1/2 a pack</option>
									<option value="20">Pack a day and above</option>
								</select>
							</div>
							<br> For how many years have you smoked: <input
								type='number' id='years' name='years' value="0"><br>
							Do you still smoke? Yes <input type="radio"
								onclick="javascript:yesnoCheck();" name="stillsmokin"
								id="yesCheck" value="istillsmoke"> No <input
								type="radio" onclick="javascript:yesnoCheck();"
								name="stillsmokin" id="noCheck" value="idontsmokeanymore"
								checked>
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

		function possibleSecond() {
			if (document.getElementById('yesCheck').checked) {
				document.getElementById('second').selected = "true";
			} else
				document.getElementById('haha').selected = "true";
		}
	</script>
</body>



</html>