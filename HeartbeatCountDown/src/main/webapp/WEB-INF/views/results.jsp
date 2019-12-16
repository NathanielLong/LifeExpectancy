<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/united/bootstrap.min.css" rel="stylesheet" integrity="sha384-WTtvlZJeRyCiKUtbQ88X1x9uHmKi0eHCbQ8irbzqSLkE0DpAZuixT5yFvgX0CjIu" crossorigin="anonymous">
<link rel="stylesheet" href = "styles.css">
</head>
<body>
<div>
<img align = "left" src = "https://theladdermn.files.wordpress.com/2013/03/human_heart.jpg">
</div>
<p> You have ${hBeat/39420000} years remaining.</p>
<p> You have <span id="countdowntimer">${hBeat } </span> heartbeats remaining</p>

<a class="btn btn-primary" href="/scrooge">I Can Change!</a>
<script type="text/javascript">
    var timeleft = ${hBeat};
    var downloadTimer = setInterval(function(){
    timeleft--;
    document.getElementById("countdowntimer").textContent = timeleft;
    if(timeleft <= 0)
        clearInterval(downloadTimer);
    },(1000/1.25));
</script>
</body>
</html>