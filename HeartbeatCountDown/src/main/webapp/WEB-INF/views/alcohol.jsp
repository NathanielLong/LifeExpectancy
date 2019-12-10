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

	<form action="">
		Do you drink alcohol? Yes <input type="radio"
			onclick="javascript:yesnoCheck();" name="yesno" id="yesCheck">
		No <input type="radio" onclick="javascript:yesnoCheck();" name="yesno"
			id="noCheck"> <input type="submit" Value="Enter."
			class="btnbtn-primary"></input> <br>
		<div id="ifYes" style="visibility: hidden">
			<div class="form-group">
				? <select class="custom-select">
					<option value="1">A drink before bed</option>
					<option value="2">Every now and again</option>
					<option value="3">Bars are my second home</option>
					<option value="4">*gurgle gurgle*</option>
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
			</form>
		</script>
</body>
</html>