<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Книги</title>
	<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/npm.js" />"></script>

</head>
<body>
	<div class="container">
		<ul class="nav nav-tabs">
			<li role="presentation" class="active"><a href="books">Книги</a></li>
			<li role="presentation"><a href="categories">Категории</a></li>
		</ul>
	</div>

<c:url var="addAction" value="/admin/books/add" ></c:url>
<div class="container">
<c:if test="${!empty listBooks}">
	<table class="table">
		<thead class="table table-bordered">
			<tr>
				<th>#</th>
				<th>Автор</th>
				<th>Наименование</th>
				<th>Описание</th>
				<th>Год</th>
				<th>Категория</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listBooks}" var="book">
				<tr>
					<td scope="row">${book.id}</td>
					<td>${book.author}</td>
					<td>${book.title}</td>
					<td>${book.description}</td>
					<td>${book.year}</td>
					<td>${book.category.name}</td>
					<td><a href="<c:url value='/admin/edit/${book.id}' />" class="glyphicon glyphicon-pencil"></a></td>
					<td><a href="<c:url value='/admin/remove/${book.id}'/>"  class="glyphicon glyphicon-trash"></a></td>
				</tr>
			</c:forEach>
			<form:form action="${addAction}" commandName="books">
					<tr>
					<c:if test="${!empty books.author}">
						<td>
							<form:input path="id" readonly="true" size="8"  disabled="true" />
							<form:hidden path="id" />
						</td>
					</c:if>
						<c:if test="${empty books.author}">
							<td>
							<c:out value="id"></c:out>
							</td>
						</c:if>
						<td>
							<form:input path="author" cssClass="form-control" placeholder="автор"/>
						</td>
						<td>
							<form:input path="title" cssClass="form-control" placeholder="наименование"/>
						</td>
						<td>
							<form:input path="description" cssClass="form-control" placeholder="описание"/>
						</td>
						<td>
							<form:input path="year" cssClass="form-control" placeholder="год"/>
						</td>
						<td>
							<form:select cssClass="form-control" multiple="true" path="category.id" id="listCategoryes">
								<form:options items="${listCategoryes}" itemValue="id" itemLabel="name" />
							</form:select>
						</td>
					<td colspan="2">
						<c:if test="${!empty books.author}">
							<input type="submit" class="btn btn-primary"
								   value="<spring:message text="Редактировать"/>" />
						</c:if>
						<c:if test="${empty books.author}">
							<input type="submit" class="btn btn-success"
								   value="<spring:message text="Добавить"/>"/>
						</c:if>
					</td>
					</tr>
			</form:form>
		</tbody>
	</table>
</c:if>
</div>
</body>
</html>
