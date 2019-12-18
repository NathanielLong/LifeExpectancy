<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/united/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WTtvlZJeRyCiKUtbQ88X1x9uHmKi0eHCbQ8irbzqSLkE0DpAZuixT5yFvgX0CjIu"
	crossorigin="anonymous">
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