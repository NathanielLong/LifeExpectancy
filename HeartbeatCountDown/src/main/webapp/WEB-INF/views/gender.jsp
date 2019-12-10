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
<title>gender</title>
</head>
<body>
	<form action="/country">
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
			<input type="submit" Value="Enter." class="btnbtn-primary"></input>
			</label>
		</div>
	</form>

</body>
</html>