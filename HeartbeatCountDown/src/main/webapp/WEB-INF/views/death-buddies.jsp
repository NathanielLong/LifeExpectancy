<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
</head>
<body>

	<div class="bg-contact3"
		style="background-image: url('images/iStock_45504088_MEDIUM.jpg');">
		<div class="container-contact3">
			<div class="wrap-contact3">
				<span class="contact3-form-title"> Death Buddies!</span>
				<table
					title="List of buddies expiring on ${buds.get(0).getDeathDay() }">
					<tr>
						<th>User Name</th>
					</tr>
					<tr>
						<c:forEach var="b" items="${buds }">
							<td>${b.getUserName() }</td>

							<br>
    Enter your email if you want it to be shared exclusively with your death buddies: 
    <form>
								<input type="email" name="email"></input> <input type="submit"
									value="Submit!" class="btn btn-secondary"></input>
							</form>

						</c:forEach>
					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>