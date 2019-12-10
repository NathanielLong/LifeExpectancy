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
<title>smoke</title>
</head>
<body>

	Do you smoke? Yes
	<input type="radio" onclick="javascript:yesnoCheck();" name="yesno"
		id="yesCheck"> No
	<input type="radio" onclick="javascript:yesnoCheck();" name="yesno"
		id="noCheck">
	<br>
	<div id="ifYes" style="visibility: hidden">
		<div class="form-group">
			How often do you smoke? <select class="custom-select">
				<option value="1">A cig a day</option>
				<option value="2">1/4 a pack</option>
				<option value="3">1/2 a pack</option>
				<option value="4">Pack a day and above</option>
			</select>
		</div>
		<br> For how many years have you smoked: <input type='number'
			id='years' name='years'>
	</div>


	<script type="text/javascript">
		function yesnoCheck() {
			if (document.getElementById('yesCheck').checked) {
				document.getElementById('ifYes').style.visibility = 'visible';
			} else
				document.getElementById('ifYes').style.visibility = 'hidden';

		}
	</script>
</body>

</html>