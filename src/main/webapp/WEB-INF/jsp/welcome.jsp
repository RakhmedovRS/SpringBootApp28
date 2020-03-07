<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<div class="container">
	Welcome ${name}. <a href="${pageContext.request.contextPath}/list-todos">Click here</a> to manage your todo's
</div>

<%@include file="common/footer.jspf" %>