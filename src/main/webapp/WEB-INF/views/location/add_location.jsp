<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Dodaj lokalizację</title>
</head>
<body>
<form:form method="post" action="/api/location/add" modelAttribute="location">
    <div><form:errors path="*" class="has-error" /></div>
    <p>Miejsce: <form:input path="place"/></p>
    <p>Pozycja: <form:input  path="position"/></p>
    </p>

    <p><button type="submit" value="Save">Zapisz</button></p>
</form:form>
</body>
</html>
