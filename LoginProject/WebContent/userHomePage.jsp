<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
</head>
<body>
	Welcome home, ${name}!
	<form action="showUsers">
		<h2>Click to display all users</h2>
		<input type="submit" value="Display">
	</form>
</body>
</html>