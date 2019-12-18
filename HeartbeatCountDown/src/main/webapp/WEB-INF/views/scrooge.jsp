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
<title>SelectWisely...</title>
</head>
<body>

	<div class="bg-contact3"
		style="background-image: url('images/iStock_45504088_MEDIUM.jpg');">
		<div class="container-contact3">
			<div class="wrap-contact3">

				<form class="contact3-form validate-form" action="/scroogeresults"
					method="post">
					<span class="contact3-form-title"> I Can Change</span>
					<c:if test="${choices  == true}">
						<p>This was your current heart-beats left:</p>${currentHBeat }
			<p>This is your new heart-beats left with these choices:</p>${newHBeat}
			<p>This is the difference in those heart-beats:</p>${newHBeat - currentHBeat}

		</c:if>
<<<<<<< HEAD
		Will you continue to smoke? Yes <input type="radio"
			onclick="javascript:yesnoChecksmoke();" name="smoke" id="yesCheck"
			value="ismoke"> No <input type="radio"
			onclick="javascript:yesnoChecksmoke();" name="smoke" id="noCheck"
			value="idontsmoke"> <br>
		<div id="ifYes" style="visibility: hidden">
			<div class="form-group">
				How often will you smoke? <select class="custom-select"
					name="amount">
					<option value="0" hidden=" ">
					<option value="1">A cigarette per day</option>
					<option value="5">1/4 a pack per day</option>
					<option value="10">1/2 a pack per day</option>
					<option value="20">Pack a day and above</option>
				</select> <input style="visibility: hidden" type="radio"
					onclick="javascript:yesnoCheck();" name="stillSmokin" id="yesCheck"
					value="${userDeets.stillSmokin }"><input style="visibility: hidden"
					type="radio" onclick="javascript:yesnoCheck();" name="stillSmokin"
					id="noCheck" value="${userDeets.stillSmokin }" checked> <input
					type='number' id='years' name='years' value="${userDeets.years}"
					style="visibility: hidden">
=======
					Will you continue to smoke? Yes <input type="radio"
						onclick="javascript:yesnoChecksmoke();" name="smoke" id="yesCheck"
						value="ismoke"> No <input type="radio"
						onclick="javascript:yesnoChecksmoke();" name="smoke" id="noCheck"
						value="idontsmoke"> <br>
					<div id="ifYes" style="visibility: hidden">
						<div class="form-group">
							How often will you smoke? <select class="custom-select"
								name="amount">
								<option value="0" hidden=" ">
								<option value="1">A cigarette per day</option>
								<option value="5">1/4 a pack per day</option>
								<option value="10">1/2 a pack per day</option>
								<option value="20">Pack a day and above</option>
							</select> <input style="visibility: hidden" type="radio"
								onclick="javascript:yesnoCheck();" name="stillSmokin"
								id="yesCheck" value="istillsmoke"><input
								style="visibility: hidden" type="radio"
								onclick="javascript:yesnoCheck();" name="stillSmokin"
								id="noCheck" value="${userDeets.stillSmokin }" checked>
							<input type='number' id='years' name='years' value="0"
								style="visibility: hidden">
						</div>
					</div>

					<div class="form-group">
						Where do plan on moving? (if you aren't planning on moving, leave
						this field as is)<br> <select class="custom-select"
							name="country">

							<c:forEach var="c" items="${ countries }">
								<option value="${c.getLabel()}">${c.getDisplay()}</option>
							</c:forEach>
						</select>
					</div>

					Will you continue to drink alcohol? Yes <input type="radio"
						onclick="javascript:yesnoCheck();" name="alcohol" value="idrink"
						id="yesCheckalc"> No <input type="radio"
						onclick="javascript:yesnoCheck();" name="alcohol" value="nodrink"
						id="noCheckalc"> <br>
					<div id="ifYesalc" style="visibility: hidden">
						<div class="form-group">
							How often will you drink? <select class="custom-select"
								name="amountDrunk">
								<option value="none" hidden=" ">
								<option value="low">A drink before bed (1-2 drinks per
									day)</option>
								<option value="medium">Every now and again (2-3.5
									drinks per day)</option>
								<option value="high">Bars are my second home (3.5+
									drinks per day)</option>
							</select>
						</div>
					</div>

					If you plan on losing weight please enter the weight you are aiming
					for: <br> <input type="number" name="weight"
						value="${userDeets.weight }"> <br> <input
						type="number" name="height" value="${userDeets.height }"
						style="visibility: hidden"> <br>

					<div class="form-group">
						Are you planning on getting a raise? If so, please enter your new
						possible income: (if not applicable, please leave field as is)<br>
						<select class="custom-select" name="income">
							<option value="25000">25,000 or lower</option>
							<option value="47500">25,001 - 47,500</option>
							<option value="77500">47,501 - 77, 500</option>
							<option value="127000">77,501 - 127,000</option>
							<option value="10000000">127,001 or higher</option>
						</select>
					</div>

					<input value="${ethnicity }" name="ethnicity" type="hidden">

					<div class="form-group">
						Please select your what level of education you will strive for: <br>
						<select class="custom-select" name="education">
							<option value="highSchool">High school diploma</option>
							<option value="bachelors">Bachelor's degree</option>
							<option value="bachelors">Master's degree</option>
							<option value="bachelors">Doctorate</option>
						</select>
					</div>

					<input type="submit" Value="Commit to this path"
						formaction="/scroogeresults" class="btn btn-primary"></input> <input
						type="submit" Value="See the results of your choices"
						formaction="/newresults" class="btn btn-primary" name="choices">

					<!-- The rest of these will be hidden -->
					<div style="visibility: hidden" class="form-group">
						<select class="custom-select" name="ethnicity">
							<option value="Asian-American">Asian</option>
							<option value="Hispanic">Hispanic</option>
							<option value="White">White</option>
							<option value="Native-American">Native-American</option>
							<option value="African-American">Black</option>
						</select>
					</div>

					<div>
						<input style="visibility: hidden" type="date" name="dob"
							value="${userDeets.dob }">
					</div>

					<div style="visibility: hidden" class="form-check">
						<label class="form-check-label"> <input type="radio"
							class="form-check-input" name="gender" id="optionsRadios1"
							value="MLE" checked="">
						</label>
					</div>
					<div style="visibility: hidden" class="form-check">
						<label class="form-check-label"> <input type="radio"
							class="form-check-input" name="gender" id="optionsRadios2"
							value="FMLE">
						</label>
					</div>

					<div>
						<input style="visibility: hidden" type="text" name="userName"
							value="${userDeets.userName }">
					</div>

					<input style="visibility: hidden" type="text" name="name"
						value="${userDeets.name }"> <input
						style="visibility: hidden" type="text" name="password"
						value="${userDeets.password }"> <input
						style="visibility: hidden" type="number" name="deathYear"
						value="${userDeets.deathYear }">
				</form>
>>>>>>> 14b99486d9fd3dff156ef2ef23348104f6a67e81
			</div>
		</div>
	</div>


	<script type="text/javascript">
		function yesnoChecksmoke() {
			if (document.getElementById('yesCheck').checked) {
				document.getElementById('ifYes').style.visibility = 'visible';
			} else
				document.getElementById('ifYes').style.visibility = 'hidden';

		}
	</script>

	<script type="text/javascript">
		function yesnoCheck() {
			if (document.getElementById('yesCheckalc').checked) {
				document.getElementById('ifYesalc').style.visibility = 'visible';
			} else
				document.getElementById('ifYesalc').style.visibility = 'hidden';

		}
	</script>
</body>


</html>