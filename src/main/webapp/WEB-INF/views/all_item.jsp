<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Wszystkie elementy</title>
</head>
<body>
<h2>Wszystkie elementy</h2>
<table border="1">
    <tr>
        <th>Nazwa/wartość</th>
        <th>Rodzaj</th>
        <th>Opis</th>
        <th>Ilość</th>
        <th>Lokalizacja</th>
    </tr>

    <c:forEach items="${items}" var="item">
         <tr>
            <td>${item.name}</td>
            <td>${item.category.name}</td>
            <td>${item.description}</td>
            <td>${item.quantity}</td>
            <td><c:forEach items="${item.itemLocations}" var="location">
                ${location.location.name},
            </c:forEach>
            </td>
             <td><a href="/api/item/edit/${item.id}">edit</a> </td>
        </tr>
    </c:forEach>

</table>
<script language="javascript" type="text/javascript" charset="UTF-8"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/all_item.js"></script>
</body>
</html>
