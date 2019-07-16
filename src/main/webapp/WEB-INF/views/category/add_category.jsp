<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Dodaj kategorię</title>
</head>
<body>
<form:form method="post" action="/api/category/add" modelAttribute="category">
    <div><form:errors path="*" class="has-error" /></div>
    <p>Nazwa: <form:input path="name"/></p>

    <p><button type="submit" value="Save">Zapisz</button></p>
</form:form>

</body>
</html>
