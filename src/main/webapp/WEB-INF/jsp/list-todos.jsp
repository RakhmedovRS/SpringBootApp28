<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="name" scope="session" type="java.lang.String"/>
<jsp:useBean id="todos" scope="request" type="java.util.List"/>
<html>
<head>
	<title>Todos' for ${name}</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
	<table class="table table-striped">
		<caption>Your todo's are</caption>
		<thead>
		<tr>
			<th>Description</th>
			<th>Target date</th>
			<th>Is it done?</th>
			<th>Delete</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.description}</td>
				<td>${todo.targetDate}</td>
				<td>${todo.done}</td>
				<td><a type="btn" class="btn btn-warning" href="${pageContext.request.contextPath}/delete-todo?id=${todo.id}">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div>
		<a class="btn btn-default" href="${pageContext.request.contextPath}/add-todo">Add todo</a>
	</div>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>