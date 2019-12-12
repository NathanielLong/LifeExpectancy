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

	<form action="/results">
		Do you smoke? Yes <input type="radio"
			onclick="javascript:yesnoCheck();" name="smoke" id="yesCheck"
			value="ismoke"> No <input type="radio"
			onclick="javascript:yesnoCheck();" name="smoke" id="noCheck"
			value="idontsmoke"> <br>
		<div id="ifYes" style="visibility: hidden">
			<div class="form-group">
				How often do you smoke? <select class="custom-select" name="amount">
					<option value="0" hidden=" ">
					<option value="1">A cig a day</option>
					<option value="5">1/4 a pack</option>
					<option value="10">1/2 a pack</option>
					<option value="20">Pack a day and above</option>
				</select>
			</div>
			<br> For how many years have you smoked: <input type='number'
				id='years' name='years' value="1"><br> Do you still
			smoke? Yes <input type="radio" onclick="javascript:yesnoCheck();"
				name="stillsmokin" id="yesCheck" value="istillsmoke"> No <input
				type="radio" onclick="javascript:yesnoCheck();" name="stillsmokin"
				id="noCheck" value="idontsmokeanymore" checked>
		</div>

		<script type="text/javascript">
			function yesnoCheck() {
				if (document.getElementById('yesCheck').checked) {
					document.getElementById('ifYes').style.visibility = 'visible';
				} else
					document.getElementById('ifYes').style.visibility = 'hidden';

			}
		</script>


		<div class="form-check">
			<label class="form-check-label"> <input type="radio"
				class="form-check-input" name="gender" id="optionsRadios1"
				value="option1" checked=""> Male
			</label>
		</div>
		<div class="form-check">
			<label class="form-check-label"> <input type="radio"
				class="form-check-input" name="gender" id="optionsRadios2"
				value="option2"> Female <br>
			</label>
		</div>



		<div class="form-group">
			<select class="custom-select">
				<c:forEach var="c" items="${ countries }">
					<option value="${c.getLabel()}" name="country">${c.getDisplay()}</option>
				</c:forEach>
			</select>
		</div>



		Do you drink alcohol? Yes <input type="radio"
			onclick="javascript:yesnoCheck();" name="alcohol" value="idrink"
			id="yesCheck"> No <input type="radio"
			onclick="javascript:yesnoCheck();" name="alcohol" value="nodrink"
			id="noCheck"> <br>
		<div id="ifYes" style="visibility: hidden">
			<div class="form-group">
				<select class="custom-select" name="amountDrunk">
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



		<script type="text/javascript">
			function yesnoCheck() {
				if (document.getElementById('yesCheck').checked) {
					document.getElementById('ifYes').style.visibility = 'visible';
				} else
					document.getElementById('ifYes').style.visibility = 'hidden';

			}
		</script>
		Please enter how much you weigh in pounds: <br> <input
			type="number" name="weight"> <br> Please enter your
		height in inches: <br> <input type="number" name="height">
		<br>



		<div class="form-group">
			What is your current income? <select class="custom-select">
				<option value="25,000">25,000 or lower</option>
				<option value="47,500">25,001 - 47,500</option>
				<option value="77,500">47,501 - 77, 500</option>
				<option value="127,000">77,501 - 127,000</option>
				<option value="10000000">127,001 or higher</option>
			</select>
		</div>


		What ethnicity do you identify the most with?

		<div class="form-group">
			<select class="custom-select">
				<option value="Asian-American">Asian-American</option>
				<option value="Hispanic">Hispanic</option>
				<option value="White">White</option>
				<option value="Native-American">Native-American</option>
				<option value="African-American">African-American</option>
			</select>
		</div>

	</form>















</body>
</html>