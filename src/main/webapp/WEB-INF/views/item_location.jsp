<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Lokalizacja elementu</title>
</head>
<body>
<a href="/api/item/all">Wszystkie elementy</a>
<table border="1">
    <tr>
        <th>Miejsce</th>
        <th>Pozycja</th>
        <th>Ilość</th>
    </tr>
    <c:forEach items="${itemLocations}" var="itemLocation">
    <tr>
        <td>${itemLocation.location.place}</td>
        <td>${itemLocation.location.position}</td>
        <td>${itemLocation.quantity}</td>

        <td><a href="/api/item/location/edit/${itemLocation.id}">Zmień ilość</a> </td>
        <td><a href="/api/item/location/delete/${itemLocation.id}">Usuń</a> </td>
    </tr>
    </c:forEach>
</body>
</html>
