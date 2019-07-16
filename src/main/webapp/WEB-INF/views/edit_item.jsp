<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edit item</title>
</head>
<body>
<form:form method="post" action="/api/item/edit/${item.id}" modelAttribute="item">
    <div><form:errors path="*" class="has-error" /></div>
    <p>Nazwa: <form:input id="name" path="name" value="${item.name}"/></p>

    <p>Opis: <form:input id="description" path="description" value="${item.description}"/></p>
    <p>Ilość: <form:input id="quantity" path="quantity" value="${item.quantity}"/></p>
    <p><form:select path="category" items="${categories}"  itemValue="id" itemLabel="name" value="category" multiple="false"/></p>

<%--    <p><form:select path="locations" items="${locations}"  itemValue="id" itemLabel="name" multiple="true"/></p>--%>

    <p><button type="submit" value="Save">Save</button></p>
</form:form>
</body>
</html>
