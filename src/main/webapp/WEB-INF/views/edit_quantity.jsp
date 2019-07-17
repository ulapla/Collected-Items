<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edytuj ilość</title>
</head>
<body>
<form:form method="post" action="/api/item/location/edit/${itemLocation.id}" modelAttribute="itemLocation">
    <p>Element: ${itemLocation.item.name}</p>
    <p>Miejse: ${itemLocation.location.place}</p>
    <p>Pozycja: ${itemLocation.location.position}</p>
    <p>Ilość: <form:input path="quantity" value="${quantity}"/></p>
    <form:hidden path="location"/>
    <form:hidden path="item"/>
    <p><button type="submit" value="Save">Zapisz</button></p>
</form:form>
</body>
</html>
