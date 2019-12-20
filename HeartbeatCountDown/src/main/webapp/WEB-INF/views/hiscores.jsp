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
</head>
<body>

	<div class="bg-contact3"
		style="background-image: url('images/iStock_45504088_MEDIUM.jpg');">
		<div class="container-contact3">
			<div class="wrap-contact3">
				<span class="contact3-form-title"> High Scores!</span>
				<table id="scoreboard" class="table"">
					<tr>
						<th onclick="sortTable(0)">Username</th>
						<th onclick="sortTable(1)">Country</th>
						<th onclick="sortTableNum(2)">Years Left</th>
						<th onclick="sortTableNum(3)">Age</th>
						<th onclick="sortTableNum(4)">Heartbeats</th>

					</tr>
					<c:forEach var="u" items="${scores }">
						<tr>
							<td>${u.getUser().getUserName() }</td>
							<td>${u.getUser().getCountry() }</td>
							<td>${u.getHeartBeats()/39420000 }</td>
							<td>${u.getUser().getAge() }</td>
							<td> <span id="countdowntimer">${u.getHeartBeats() } </span>
							<td>
						</tr>
					</c:forEach>
				</table>
				<br><a class="btn btn-primary" href="/">Home</a><br>
			</div>
		</div>
	</div>



	<script>
	var timeleft = ${hBeat};
	var downloadTimer = setInterval(function() {
		timeleft--;
		document.getElementById("countdowntimer").textContent = timeleft;
		if (timeleft <= 0)
			clearInterval(downloadTimer);
	}, (1000 / ${beatRate}));
	
		function sortTable(n) {
			var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
			table = document.getElementById("scoreboard");
			switching = true;
			// Set the sorting direction to ascending:
			dir = "asc";
			/* Make a loop that will continue until
			no switching has been done: */
			while (switching) {
				// Start by saying: no switching is done:
				switching = false;
				rows = table.rows;
				/* Loop through all table rows (except the
				first, which contains table headers): */
				for (i = 1; i < (rows.length - 1); i++) {
					// Start by saying there should be no switching:
					shouldSwitch = false;
					/* Get the two elements you want to compare,
					one from current row and one from the next: */
					x = rows[i].getElementsByTagName("TD")[n];
					y = rows[i + 1].getElementsByTagName("TD")[n];
					/* Check if the two rows should switch place,
					based on the direction, asc or desc: */
					if (dir == "asc") {
						if (x.innerHTML.toLowerCase() > y.innerHTML
								.toLowerCase()) {
							// If so, mark as a switch and break the loop:
							shouldSwitch = true;
							break;
						}
						if (Number(x.innerHTML) > Number(y.innerHTML)) {
							shouldSwitch = true;
							break;
						}
					} else if (dir == "desc") {
						if (x.innerHTML.toLowerCase() < y.innerHTML
								.toLowerCase()) {
							// If so, mark as a switch and break the loop:
							shouldSwitch = true;
							break;
						}
						if (Number(x.innerHTML) < Number(y.innerHTML)) {
							shouldSwitch = true;
							break;
						}
					}
				}
				if (shouldSwitch) {
					/* If a switch has been marked, make the switch
					and mark that a switch has been done: */
					rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
					switching = true;
					// Each time a switch is done, increase this count by 1:
					switchcount++;
				} else {
					/* If no switching has been done AND the direction is "asc",
					set the direction to "desc" and run the while loop again. */
					if (switchcount == 0 && dir == "asc") {
						dir = "desc";
						switching = true;
					}
				}
			}
		}

		function sortTableNum(n) {
			var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
			table = document.getElementById("scoreboard");
			switching = true;
			// Set the sorting direction to ascending:
			dir = "asc";
			/* Make a loop that will continue until
			no switching has been done: */
			while (switching) {
				// Start by saying: no switching is done:
				switching = false;
				rows = table.rows;
				/* Loop through all table rows (except the
				first, which contains table headers): */
				for (i = 1; i < (rows.length - 1); i++) {
					// Start by saying there should be no switching:
					shouldSwitch = false;
					/* Get the two elements you want to compare,
					one from current row and one from the next: */
					x = rows[i].getElementsByTagName("TD")[n];
					y = rows[i + 1].getElementsByTagName("TD")[n];
					/* Check if the two rows should switch place,
					based on the direction, asc or desc: */
					if (dir == "asc") {

						if (Number(x.innerHTML) > Number(y.innerHTML)) {
							shouldSwitch = true;
							break;
						}
					} else if (dir == "desc") {

						if (Number(x.innerHTML) < Number(y.innerHTML)) {
							shouldSwitch = true;
							break;
						}
					}
				}
				if (shouldSwitch) {
					/* If a switch has been marked, make the switch
					and mark that a switch has been done: */
					rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
					switching = true;
					// Each time a switch is done, increase this count by 1:
					switchcount++;
				} else {
					/* If no switching has been done AND the direction is "asc",
					set the direction to "desc" and run the while loop again. */
					if (switchcount == 0 && dir == "asc") {
						dir = "desc";
						switching = true;
					}
				}
			}
		}
	</script>
</body>
</html>