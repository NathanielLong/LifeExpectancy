<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/superhero/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-LS4/wo5Z/8SLpOLHs0IbuPAGOWTx30XSoZJ8o7WKH0UJhRpjXXTpODOjfVnNjeHu"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>selectwisely...</title>
</head>
<body>

	<form action="/scroogeresults">
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
					<option value="1">A cig a day</option>
					<option value="5">1/4 a pack</option>
					<option value="10">1/2 a pack</option>
					<option value="20">Pack a day and above</option>
				</select> <input style="visibility: hidden" type="radio"
					onclick="javascript:yesnoCheck();" name="stillsmokin" id="yesCheck"
					value="istillsmoke"><input style="visibility: hidden"
					type="radio" onclick="javascript:yesnoCheck();" name="stillsmokin"
					id="noCheck" value="idontsmokeanymore">
			</div>
		</div>

		<div class="form-group">
			Where do plan on moving? (if you aren't planning on moving, leave
			this field as is) <select class="custom-select">

				<c:forEach var="c" items="${ countries }">
					<option value="${c.getLabel()}" name="${user.country }">${c.getDisplay()}</option>
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
					<option value="medium">Every now and again (2-3.5 drinks
						per day)</option>
					<option value="high">Bars are my second home (3.5+ drinks
						per day)</option>
				</select>
			</div>
		</div>

		If you plan on losing weight please enter the weight you are aiming
		for: <br> <input type="number" name="weight"> <br> <input
			type="number" name="weight" style="visibility: hidden"> <br>

		<div class="form-group">
			Are you planning on getting a raise? If so, please enter your new
			possible income: (if not applicable, please leave field as is) <select
				class="custom-select" default="${user.income}"}><option
					value="25,000">25,000 or lower</option>
				<option value="47,500">25,001 - 47,500</option>
				<option value="77,500">47,501 - 77, 500</option>
				<option value="127,000">77,501 - 127,000</option>
				<option value="10000000">127,001 or higher</option>
			</select>
		</div>
		<input class="btn btn-primary" type="submit" value="Enter">

		<!-- The rest of these will be hidden -->
		<div style="visibility: hidden" class="form-group">
			<select class="custom-select" name="ethnicity">
				<option value="Asian-American">Asian</option>
				<option value="Hispanic">Hispanic</option>
				<option value="White">White</option>
				<option value="Native-American">Native-American</option>
				<option value="African-American">African-American</option>
			</select> <input type="submit" Value="Enter." class="btn btn-primary"></input>
		</div>

		<div>
			<input style="visibility: hidden" type="date" name="borned">
		</div>

		<div style="visibility: hidden" class="form-group">
			<select class="custom-select" name="country">
				<c:forEach var="c" items="${ countries }">
					<option value="${c.getLabel()}">${c.getDisplay()}</option>
				</c:forEach>
			</select>
		</div>

		<div style="visibility: hidden" class="form-check">
			<label class="form-check-label"> <input type="radio"
				class="form-check-input" name="gender" id="optionsRadios1"
				value="MLE" checked=""> Male
			</label>
		</div>
		<div style="visibility: hidden" class="form-check">
			<label class="form-check-label"> <input type="radio"
				class="form-check-input" name="gender" id="optionsRadios2"
				value="FMLE">
			</label>
		</div>

		<div>
			<input style="visibility: hidden" type="text" name="userName">
		</div>

	</form>

	<h1 style="color: red">${user.country }</h1>
	${user.income } ${user.smoke }

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