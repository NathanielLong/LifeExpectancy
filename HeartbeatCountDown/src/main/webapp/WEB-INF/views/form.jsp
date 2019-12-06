<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/united/bootstrap.min.css" rel="stylesheet" integrity="sha384-WTtvlZJeRyCiKUtbQ88X1x9uHmKi0eHCbQ8irbzqSLkE0DpAZuixT5yFvgX0CjIu" crossorigin="anonymous">
</head>
<body>
${name }

form<form action="results-page">
Enter your date of birth:<input type ="number" name = "dob"></input>
<br>
Do you smoke? y/n:<input type ="text" name = "smoke"></input>
<br>
Enter your gender :<input type ="text" name = "gender"></input>
<br>
Enter the country you live in:<input type ="text" name = "country"></input>
<br>
<input type="submit" Value="Calculate." class = "btn btn-primary"></input>
</form>
</body>
</html>