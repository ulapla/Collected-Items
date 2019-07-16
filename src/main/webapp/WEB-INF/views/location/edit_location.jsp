<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edycja lokalizacji</title>
</head>
<body>
<form:form method="post" action="/api/location/edit/${location.id}" modelAttribute="location">
    <p>Miejsce: <form:input path="place" value="${place}"/></p>
    <p>Opis: <form:input path="position" value="${position}"/></p>
    <p><button type="submit" value="Save">Zapisz</button></p>
</form:form>
</body>
</html>
