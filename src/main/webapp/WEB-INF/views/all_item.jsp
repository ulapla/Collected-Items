<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Wszystkie elementy</title>
</head>
<body>
<h2>Wszystkie elementy</h2>

<a href="/api/item/add">Dodaj nowy element</a>
<table border="1">
    <tr>
        <th>Nazwa/wartość</th>
        <th>Rodzaj</th>
        <th>Opis</th>
        <th>Ilość</th>
        <th>Lokalizacja</th>
    </tr>

    <tr>
        <form action="/api/item/search/" method="post">
           <td> <input type="text" name="name"/></td>

            <td> <select name="categoryId">
                <option></option>
                <c:forEach items="${categories}" var="category">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>

            <td> <input type="text" name="description"/></td>
            <td></td>
            <td></td>
            <td><button type="submit">Szukaj</button> </td>

        </form>

    </tr>

    <c:forEach items="${items}" var="item">
         <tr>
             <td><a href="/api/item/show/locations/${item.id}">${item.name}</a></td>
            <td>${item.category.name}</td>
            <td>${item.description}</td>
            <td>${item.quantity}</td>
            <td><c:forEach items="${item.itemLocations}" var="location">
                ${location.location.name}<br>
            </c:forEach>
            </td>
             <td><a href="/api/item/edit/${item.id}">Edytuj</a> </td>
             <td><a href="/api/item/delete/${item.id}">Usuń</a> </td>
             <td><a href="/api/item/${item.id}/add/location">Dodaj lokalizację</a> </td>
        </tr>
    </c:forEach>

</table>
<%--<script language="javascript" type="text/javascript" charset="UTF-8"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<%--<script src="/all_item.js"></script>--%>
</body>
</html>
