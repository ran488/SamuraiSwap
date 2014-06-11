<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="application.css" />
<title>Samurai Swap!</title>
</head>
<body>
	<table width="65%" bgcolor="white" border="0" align="center">
		<tr>
			<td><img alt="Logo" src="logo.png" border="0" /></td>
		</tr>
		<tr>
			<td>
				<ul>
					<li><a href="test.jsp">Test MongoDB connectivity</a></li>
					<li><a href="api/hello">Rest Greeting (default)</a></li>
					<li><a href="api/hello?name=ran488">Rest Greeting (my
							name)</a></li>
					<li><a href="createItem.html">Try to add a new Swap Item (form)</a>
						<form action="api/createSwapItem" method="POST">
							<input type="submit" value="Create New Swap Item (default vals)" />
						</form>
					</li>
					<li><a href="api/getSwapItems">Get Swap Items (raw REST)</a></li>
					<li><a href="SwapItems.html">Get Swap Items (Angular)</a></li>
					<li><a href="api/reset" onclick="return confirm('Are you sure you want to delete?');">Reset Database (DELETE EVERYTHING!!!!)</a></li>
					<li><a href="demo.html">AngularJS First Demo</a></li>
				</ul>
			</td>
			<td align="center"><img src="samurai-warrior.png"></td>
		</tr>
	</table>
</body>
</html>