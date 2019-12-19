<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ResultsPage</title>
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
				<span class="contact3-form-title"> Beat Dropper</span>
				<p>You have ${yearsLeft} years remaining.</p>
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
				<div class="heartbeat" style = "animation: heartbeat ${1/beatRate}s infinite">

					<span><img align="left" width="200" src="images/heart.png"></span>
				</div>

				<br> <a class="btn btn-primary" href="/scrooge">I Can
					Change!</a> <a class="btn btn-primary" href="/">Home</a> <a
					class="btn btn-primary" href="/hiscores">High Scores!</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var timeleft = ${hBeat};
		var downloadTimer = setInterval(function() {
			timeleft--;
			document.getElementById("countdowntimer").textContent = timeleft;
			if (timeleft <= 0)
				clearInterval(downloadTimer);
		}, (1000 / ${beatRate}));
	</script>




</body>
</html>