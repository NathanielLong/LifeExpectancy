<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.4.1/simplex/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-cRAmF0wErT4D9dEBc36qB6pVu+KmLh516IoGWD/Gfm6FicBbyDuHgS4jmkQB8u1a"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>youranalcoholic</title>
</head>
<body>
	<form action="/bmi">
		Do you drink alcohol? Yes <input type="radio"
			onclick="javascript:yesnoCheck(); possibleFirst();" name="alcohol" value="idrink"
			id="yesCheck"> No <input type="radio"
			onclick="javascript:yesnoCheck(); possibleFirst();" name="alcohol" value="nodrink"
			id="noCheck"> <input type="submit" Value="Enter."
			value="none" class="btnbtn-primary"></input> <br>
		<div id="ifYes" style="visibility: hidden">
			<div class="form-group">
			How much do you drink?
				<select class="custom-select" name="amountDrunk">
					<option value="none" hidden=" " id="teehee"></option>
					<option value="low" id="first">A drink before bed (1-2 drinks per
						day)</option>
					<option value="medium">Every now and again (2-3.5 drinks
						per day)</option>
					<option value="high">Bars are my second home (3.5+ drinks
						per day)</option>
				</select>
			</div>
		</div>
	</form>
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
				document.getElementById('teehee').selected = "true";
		}
	</script>
</body>
</html>