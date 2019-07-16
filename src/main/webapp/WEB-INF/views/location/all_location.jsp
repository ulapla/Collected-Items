<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Wszystkie lokalizacje</title>
</head>
<body>
<h2>Wszystkie lokalizacje</h2>
<a href="/api/location/add">Dodaj nową lokalizację</a>
<table border="1">
    <tr>
        <th>Miejsce</th>
        <th>Pozycja</th>
    </tr>
<c:forEach items="${locations}" var="location">
    <tr>
    <td>${location.place}</td>
    <td>${location.position}</td>
    <td><a href="/api/location/edit/${location.id}">Edytuj</a> </td>
    <td><a href="/api/location/delete/${location.id}">Usuń</a> </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
