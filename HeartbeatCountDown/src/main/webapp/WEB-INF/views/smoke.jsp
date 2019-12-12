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
	<form action="/gender">
		Do you smoke? Yes <input type="radio"
			onclick="javascript:yesnoCheck();" name="smoke" id="yesCheck"
			value="ismoke"> No <input type="radio"
			onclick="javascript:yesnoCheck();" name="smoke" id="noCheck"
			value="idontsmoke"> <input type="submit" Value="Enter."
			class="btnbtn-primary"></input> <br>
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


	</form>


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