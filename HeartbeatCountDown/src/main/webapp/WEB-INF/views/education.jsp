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
<title>Education</title>
</head>
<body>

	<form action="/income" method="post">
		<input value="${ethnicity }" name = "ethnicity" type = "hidden">
		<div class="form-group">
			Please select your highest level of education attained <select class="custom-select"
				name="education">
				<option value="noHS">No high school diploma</option>
				<option value="highSchool">High school diploma</option>
				<option value="bachelors">Bachelor's degree</option>
				<option value="bachelors">Master's degree</option>
				<option value="bachelors">Doctorate</option>
			</select> <input type="submit" Value="Enter" class="btn btn-primary"></input>
		</div>
	</form>

</body>
</html>