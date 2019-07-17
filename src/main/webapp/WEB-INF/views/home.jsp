<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/api/item/all">Wszystkie elementy</a>
<a href="/api/item/add">Dodaj nowy element</a>
<a href="/api/location/all">Wszystkie lokalizacje</a>
<a href="/api/location/add">Dodaj nową lokalizację</a>
<a href="/api/category/all">Wszystkie kategorie</a>
<a href="/api/category/add">Dodaj nową kategorię</a>
<p>Ilość wszystkich elementów: ${quantityAll}</p>
    <form action="/api/item/search/" method="post">
        Wyszukaj <br>Nazwa: <input type="text" name="name"/>
    <input type="hidden" name="description"/>
    </form>
</body>
</html>
