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

					Will you continue to smoke? Yes <input type="radio"
						onclick="javascript:yesnoChecksmoke();" name="smokeStatus" id="yesCheck"
						value="smokeTrue"
						<c:set var = "cigSmoke" value = "0"/>
							<c:if test="${cigSmoke != userDeets.numOfCigarettes }">
							checked
							</c:if>
						> 
						No <input type="radio" onclick="javascript:yesnoChecksmoke();" name="smokeStatus" id="noCheck"
						value="smokeFalse"
						<c:if test="${cigSmoke == userDeets.numOfCigarettes }">
							checked
							</c:if>
						> <br>
					<div id="ifYes" style="visibility: hidden">
						<div class="form-group">
							How often will you smoke? <select class="custom-select"
								name="numOfCigarettes">
								<option value="0" hidden=" "
								<c:set var = "valuecig0" value = "0"/>
							<c:if test="${valuecig0 == userDeets.numOfCigarettes }">
							selected
							</c:if>
								>
								<option value="1"
								<c:set var = "valuecig1" value = "1"/>
							<c:if test="${valuecig1 == userDeets.numOfCigarettes }">
							selected
							</c:if>>A cigarette per day</option>
								<option value="5"
								<c:set var = "valuecig5" value = "5"/>
							<c:if test="${valuecig5 == userDeets.numOfCigarettes }">
							selected
							</c:if>
								>1/4 a pack per day</option>
								<option value="10"
								<c:set var = "valuecig10" value = "10"/>
							<c:if test="${valuecig10 == userDeets.numOfCigarettes }">
							selected
							</c:if>
								>1/2 a pack per day</option>
								<option value="20"
								<c:set var = "valuecig20" value = "20"/>
							<c:if test="${valuecig20 == userDeets.numOfCigarettes }">
							selected
							</c:if>
								>Pack a day and above</option>
							</select> <input style="visibility: hidden" type="radio"
								onclick="javascript:yesnoCheck();" name="smoke"
								id="yesCheck" value="SmokeTrue"><input
								style="visibility: hidden" type="radio"
								onclick="javascript:yesnoCheck();" name="smoke"
								id="noCheck" value="smokeFalse" checked>
							<input type='number' id='years' name='yearsSmoked' value="${userDeets.yearsSmoked}"

								style="visibility: hidden">
						</div>
					</div>

					<div class="form-group">
						Where do plan on moving? (if you aren't planning on moving, leave
						this field as is)<br> <select class="custom-select"
							name="country">

							<c:forEach var="c" items="${ countries }">
								<option value="${c.getLabel()}"
							<c:if test="${c.getLabel() == userDeets.country }">
							selected
							</c:if>
								>${c.getDisplay()}</option>
							</c:forEach>
						</select>
					</div>

					Will you drink alcohol? Yes <input type="radio"
						onclick="javascript:yesnoCheck();" name="alcohol" value="idrink"
						id="yesCheckalc"
						<c:set var = "checkDrink" value = "none"/>
							<c:if test="${checkDrink != userDeets.amountDrunk }">
							checked
							</c:if>
						> No <input type="radio"
						onclick="javascript:yesnoCheck();" name="alcohol" value="nodrink"
						id="noCheckalc"
							<c:if test="${checkDrink == userDeets.amountDrunk }">
							checked
							</c:if>
						> <br>
					<div id="ifYesalc" style="visibility: hidden">
						<div class="form-group">
							How often will you drink? <select class="custom-select"
								name="amountDrunk">
								<option value="none" hidden=" "
								<c:set var = "valuedrink0" value = "none"/>
							<c:if test="${valuedrink0 == userDeets.amountDrunk }">
							selected
							</c:if>
								>
								
								<option value="low"
								<c:set var = "valuelow" value = "low"/>
							<c:if test="${valuelow == userDeets.amountDrunk }">
							selected
							</c:if>
							>A drink before bed (1-2 drinks per
									day)</option>
								<option value="medium"
								<c:set var = "valuemed" value = "medium"/>
							<c:if test="${valuemed == userDeets.amountDrunk }">
							selected
							</c:if>
								>Every now and again (2-3.5
									drinks per day)</option>
								<option value="high"
								<c:set var = "valuehigh" value = "high"/>
							<c:if test="${valuehigh == userDeets.amountDrunk }">
							selected
							</c:if>
								>Bars are my second home (3.5+
									drinks per day)</option>
							</select>
						</div>
					</div>

					If you plan on losing weight please enter the weight you are aiming
					for: <br> <input type="number" name="weight"
						value="${userDeets.weight }"> <br> <input
						type="number" name="height" value="${userDeets.height }"
						style="visibility: hidden"> <br>
					Have a different heartrate? Enter the new one: <br>
						<input type="number" name="bpm"
						value="${userDeets.bpm }"> <br>
						<br>

					<div class="form-group">
						Are you planning on getting a change in income? If so, please enter your new
						possible income: (if not applicable, please leave field as is)<br>
						<select class="custom-select" name="income">
							
							<option value="25000"
							<c:set var = "value25" value = "25000"/> 
							<c:if test="${value25 == userDeets.income }">
							selected
							</c:if>
							>25,000 or lower</option>
							<option value="47500"
							<c:set var = "value47" value = "47500"/>
							<c:if test="${value47 == userDeets.income }">
							selected
							</c:if>
							>25,001 - 47,500</option>
							<option value="77500"
							<c:set var = "value77" value = "77500"/>
							<c:if test="${value77 == userDeets.income }">
							selected
							</c:if>
							>47,501 - 77, 500</option>
							<option value="127000"
							<c:set var = "value127" value = "127000"/>
							<c:if test="${value127 == userDeets.income }">
							selected
							</c:if>
							>77,501 - 127,000</option>
							<option value="10000000"
							<c:set var = "value10000000" value = "10000000"/>
							<c:if test="${value10000000 == userDeets.income }">
							selected
							</c:if>
							>127,001 or higher</option>
						</select>
					</div>
					<div class="form-group">
						Please select education change you would like to see: <br>
						<select class="custom-select" name="education">
							<option value = "none"
							<c:set var = "valuenone" value = "none"/>
							<c:if test="${valuenone == userDeets.education }">
							selected
							</c:if>
							>No further education</option>
							<option value="highSchool"
							<c:set var = "valuehs" value = "highSchool"/>
							<c:if test="${valuehs == userDeets.education }">
							selected
							</c:if>
							>High school diploma</option>
							<option value="bachelors"
							<c:set var = "valuebach" value = "bachelors"/>
							<c:if test="${valuebach == userDeets.education }">
							selected
							</c:if>
							>Bachelor's degree or higher</option>
						</select>
					</div>

					<input type="submit" Value="Commit to this path"
						formaction="/scroogeresults" class="btn btn-primary"></input> <input
						type="submit" Value="See the results of your choices"
						formaction="/newresults" class="btn btn-primary" name="choices">

					<!-- The rest of these will be hidden -->
						<input style="visibility: hidden" type="number" name="id"
							value="${userDeets.id }">
						<input style="visibility: hidden" type="number" name="age"
							value="${userDeets.age }">	
						<input style="visibility: hidden" type="text" name="deathDay"
							value="${userDeets.deathDay }">
						<input style="visibility: hidden" type="number" name="deathYear"
							value="${userDeets.deathYear }">
						<input style="visibility: hidden" type="text" name="dob"
							value="${userDeets.dob }">
						<input style="visibility: hidden" type="text" name="email"
							value="${userDeets.email }">
						<input style="visibility: hidden" type="text" name="ethnicity"
							value="${userDeets.ethnicity }">
						<input style="visibility: hidden" type="text" name="gender"
							value="${userDeets.gender }">
						<input style="visibility: hidden" type="text" name="height"
							value="${userDeets.height }">
					<input style="visibility: hidden" type="text" name="name"
						value="${userDeets.name }">
					<input style="visibility: hidden" type="text" name="password"
						value="${userDeets.password }">
						<input style="visibility: hidden" type="text" name="userName"
							value="${userDeets.userName }">
					
				</form>
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