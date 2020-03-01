<jsp:useBean id="name" scope="session" type="java.lang.String"/>
<html>
<head>
	<title>Simple JSP page</title>
</head>

<body>
Add todo page for ${name}
	<form method="post">
		Description: <input name="description" type="text"/>
		<input type="submit"/>
	</form>
</body>

</html>