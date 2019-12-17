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
<title>Education</title>
</head>
<body>

	<div class="bg-contact3"
		style="background-image: url('images/iStock_45504088_MEDIUM.jpg');">
		<div class="container-contact3">
			<div class="wrap-contact3">
				<div class="contact3-form-radio m-r-42">

					<form class="contact3-form validate-form" action="/income"
						method="post">
						<span class="contact3-form-title"> Beat Dropper</span> <input
							value="${ethnicity }" name="ethnicity" type="hidden">
						<div class="form-group">
							Please select your highest level of education attained <br>
							<select class="custom-select" name="education">
								<option value="noHS">No high school diploma</option>
								<option value="highSchool">High school diploma</option>
								<option value="bachelors">Bachelor's degree</option>
								<option value="bachelors">Master's degree</option>
								<option value="bachelors">Doctorate</option>
							</select> <input type="submit" Value="Enter" class="btn btn-primary"></input>
						</div>
						<div class="container-contact3-form-btn">
							<button class="contact3-form-btn">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>