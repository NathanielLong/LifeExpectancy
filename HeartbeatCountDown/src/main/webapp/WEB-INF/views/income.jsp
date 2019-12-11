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
<title>youbroke</title>
</head>
<body>

	<form action="/ethnicity">
		<div class="form-group">
			What is your current income? <select class="custom-select" name = "income">
				<option value="25000">25,000 or lower</option>
				<option value="47500">25,001 - 47,500</option>
				<option value="77500">47,501 - 77, 500</option>
				<option value="127000">77,501 - 127,000</option>
				<option value="10000000">127,001 or higher</option>
			</select> <input type="submit" Value="Enter." class="btnbtn-primary"></input>
		</div>
	</form>

</body>
</html>