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
<table>
  <tr>
    <th>User id</th>
    <th>Name</th>
  </tr>
  <c:forEach var = "u" items = "${scores }">
  <tr>
    <td>${u.getId() }</td>
    <td>${u.getUserName() }</td>
  </tr>
  </c:forEach>
</table>

</body>
</html>