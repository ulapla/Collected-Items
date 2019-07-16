<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Wszystkie kategorie</title>
</head>
<body>
<h2>Wszystkie kategorie</h2>
<a href="/api/category/add">Dodaj nową kategorię</a>
<table border="1">
    <tr>
        <th>Miejsce</th>
        <th>Pozycja</th>
    </tr>
    <c:forEach items="${categories}" var="category">
    <tr>
        <td>${category.name}</td>
        <td><a href="/api/category/edit/${category.id}">Edytuj</a> </td>
        <td><a href="/api/category/delete/${category.id}">Usuń</a> </td>
    </tr>
    </c:forEach>

</body>
</html>
