<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Edycja kategorii</title>
</head>
<body>
<form:form method="post" action="/api/category/edit/${category.id}" modelAttribute="category">
    <p>Miejsce: <form:input path="name" value="${name}"/></p>
    <p><button type="submit" value="Save">Zapisz</button></p>
</form:form>
</body>
</html>
