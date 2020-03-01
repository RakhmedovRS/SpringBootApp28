<jsp:useBean id="name" scope="session" type="java.lang.String"/>
<html>
<head>
	<title>Simple JSP page</title>
</head>

<body>Welcome ${name}. <a href="${pageContext.request.contextPath}/list-todos">Click here</a> to manage your todo's</body>
</html>