<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="name" scope="session" type="java.lang.String"/>
<jsp:useBean id="todos" scope="request" type="java.util.List"/>
<html>
<head>
	<title>Todos' for ${name}</title>
</head>

<body>
<H1>Your todo's</H1>
<table>
	<caption>Your todo's are</caption>
	<thead>
	<tr>
		<th>Description</th>
		<th>Target date</th>
		<th>Is it done?</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${todos}" var="todo">
		<tr>
			<td>${todo.description}</td>
			<td>${todo.targetDate}</td>
			<td>${todo.done}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
	<a href="/add-todo">Add todo</a>
</body>

</html>