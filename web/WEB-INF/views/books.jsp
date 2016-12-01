<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Книги</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Добавить книгу
</h1>

<c:url var="addAction" value="/books/add" ></c:url>

<form:form action="${addAction}" commandName="books">
<table>
	<c:if test="${!empty books.author}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="author">
				<spring:message text="Author"/>
			</form:label>
		</td>
		<td>
			<form:input path="author" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="title">
				<spring:message text="Title"/>
			</form:label>
		</td>
		<td>
			<form:input path="title" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="description">
				<spring:message text="Description"/>
			</form:label>
		</td>
		<td>
			<form:input path="description" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="year">
				<spring:message text="Year"/>
			</form:label>
		</td>
		<td>
			<form:input path="year" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty books.author}">
				<input type="submit"
					value="<spring:message text="Редактировать"/>" />
			</c:if>
			<c:if test="${empty books.author}">
				<input type="submit"
					value="<spring:message text="Добавить"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Список книг</h3>
<c:if test="${!empty listBooks}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Author</th>
		<th width="120">Title</th>
		<th width="120">Description</th>
		<th width="120">Year</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listBooks}" var="book">
		<tr>
			<td>${book.id}</td>
			<td>${book.author}</td>
			<td>${book.title}</td>
			<td>${book.description}</td>
			<td>${book.year}</td>
			<td><a href="<c:url value='/edit/${book.id}' />" >Редактировать</a></td>
			<td><a href="<c:url value='/remove/${book.id}' />" >Удалить</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
