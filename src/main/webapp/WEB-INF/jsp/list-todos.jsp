<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<div class="container">
	<table class="table table-striped">
		<caption>Your todo's are</caption>
		<thead>
		<tr>
			<th>Description</th>
			<th>Target date</th>
			<th>Is it done?</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.description}</td>
				<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
				<td>${todo.done}</td>
				<td><a type="btn" class="btn btn-success" href="${pageContext.request.contextPath}/update-todo?id=${todo.id}">Update</a></td>
				<td><a type="btn" class="btn btn-warning" href="${pageContext.request.contextPath}/delete-todo?id=${todo.id}">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div>
		<a class="btn btn-default" href="${pageContext.request.contextPath}/add-todo">Add todo</a>
	</div>
</div>

<%@include file="common/footer.jspf" %>