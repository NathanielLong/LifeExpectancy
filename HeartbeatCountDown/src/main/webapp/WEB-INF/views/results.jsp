<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ResultsPage</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/united/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WTtvlZJeRyCiKUtbQ88X1x9uHmKi0eHCbQ8irbzqSLkE0DpAZuixT5yFvgX0CjIu"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
</head>
<body>

	<div class="bg-contact3"
		style="background-image: url('images/iStock_45504088_MEDIUM.jpg');">
		<div class="container-contact3">
			<div class="wrap-contact3">
				<span class="contact3-form-title"> Beat Dropper</span>
				<p>You have ${hBeat/39420000} years remaining.</p>
				<p>I predict you make it to ${deathDay }</p>
				<p>
					You have <span id="countdowntimer">${hBeat } </span> heartbeats
					remaining
				</p>

				<div>
					<a
						href="mailto:?subject=I'm dying! Save the Date!&body=You are cordially invited to my funeral. It will probably be a couple days after I die, which, at my current rate, is on ${deathDay } Venue is to be determined. Please RSVP as soon as possible. Want to see if your own funeral might conflict? Visit Beat Dropper! http://beatdropper.us-east-2.elasticbeanstalk.com">Send
						Email</a>
				</div>
				<p>
					Want to see who is dying the same day as you? <br> <a
						href="/death-buddies">Find death buddies!</a>
				</p>
				<div class="heartbeat">
					<span><img align="left" width="200" src="images/heart.png"></span>
				</div>

				<br> <a class="btn btn-primary" href="/scrooge">I Can
					Change!</a> <a class="btn btn-primary" href="/">Home</a> <a
					class="btn btn-primary" href="/hiscores">High Scores!</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var timeleft = $
		{
			hBeat
		};
		var downloadTimer = setInterval(function() {
			timeleft--;
			document.getElementById("countdowntimer").textContent = timeleft;
			if (timeleft <= 0)
				clearInterval(downloadTimer);
		}, (1000 / 1.25));
	</script>




</body>
</html>