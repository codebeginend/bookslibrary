<%--
  Created by IntelliJ IDEA.
  User: zaur
  Date: 08.12.16
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
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
<c:url var="addAction" value="/admin/categories/add" ></c:url>
<div class="container">
    <ul class="nav nav-tabs">
        <li role="presentation"><a href="books">Книги</a></li>
        <li role="presentation" class="active"><a href="categories">Категории</a></li>
    </ul>
</div>
<div class="container">
    <c:if test="${!empty listCategoryes}">
        <table class="table">
            <thead class="thead">
            <tr>
                <th>#</th>
                <th>Наименование</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCategoryes}" var="category">
                <tr>
                    <td scope="row">${category.id}</td>
                    <td>${category.name}</td>
                    <td><a href="<c:url value='/admin/categories/edit/${category.id}' />" class="glyphicon glyphicon-pencil"></a></td>
                    <td><a href="<c:url value='/admin/categories/remove/${category.id}'/>"  class="glyphicon glyphicon-trash"></a></td>
                </tr>
            </c:forEach>
            <form:form action="${addAction}" commandName="categories">
                <tr>
                    <c:if test="${!empty categories.name}">
                        <td>
                            <form:input path="id" readonly="true" size="8"  disabled="true" />
                            <form:hidden path="id" />
                        </td>
                    </c:if>
                    <c:if test="${empty categories.name}">
                        <td>
                            <c:out value="id"></c:out>
                        </td>
                    </c:if>
                    <td>
                            <form:input path="name" cssClass="form-control" placeholder="наименование"/>
                    </td>
                    <td colspan="2">
                        <c:if test="${!empty categories.name}">
                            <input type="submit" class="btn btn-primary"
                                   value="<spring:message text="Редактировать"/>" />
                        </c:if>
                        <c:if test="${empty categories.name}">
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
